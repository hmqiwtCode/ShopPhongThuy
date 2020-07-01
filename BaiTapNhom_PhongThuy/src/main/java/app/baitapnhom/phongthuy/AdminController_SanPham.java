package app.baitapnhom.phongthuy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import app.baitapnhom.entities.LoaiSanPham;
import app.baitapnhom.entities.NhaCungCap;
import app.baitapnhom.entities.NuocSanXuat;
import app.baitapnhom.entities.SanPham;
import app.baitapnhom.service.LayThongTinService;
import app.baitapnhom.service.SanPhamService;
import app.baitapnhom.service.ThaoTacSanPhamService;

@Controller
@RequestMapping("/admin")

public class AdminController_SanPham {

	@Autowired
	private SanPhamService spService;

	@Autowired
	private ThaoTacSanPhamService<NhaCungCap> thaoTacNCC;

	@Autowired
	private ThaoTacSanPhamService<LoaiSanPham> thaoTacLoaiSP;

	@Autowired
	private ThaoTacSanPhamService<NuocSanXuat> thaoTacNuocSX;

	@Autowired
	private LayThongTinService layThongTinService;

	@GetMapping("/themsanpham")
	public String themSanPham(Model model) {
		model.addAttribute("sp", new SanPham());
		model.addAttribute("ncc", new NhaCungCap());
		model.addAttribute("loaisp", new LoaiSanPham());
		model.addAttribute("nuocsx", new NuocSanXuat());
		model.addAttribute("listNCC", thaoTacNCC.getTatCa(NhaCungCap.class));
		model.addAttribute("listLoaiSPI", thaoTacLoaiSP.getTatCa(LoaiSanPham.class));
		model.addAttribute("listNuocSXI", thaoTacNuocSX.getTatCa(NuocSanXuat.class));
		return "themsanpham";
	}

	@PostMapping("/hienthisanpham")
	public String upload(@ModelAttribute("sp") SanPham sp, Model model,
			@RequestParam("fileAnh") MultipartFile multipartFile, @RequestParam("getNhaCC") String ncc,
			@RequestParam("getLoaiSP") String loaisp, @RequestParam("getNuocSX") String nuocsx,
			HttpServletRequest request) throws IOException {
		NhaCungCap nccI = layThongTinService.getNhaCUngCap(ncc);
		LoaiSanPham loaispI = layThongTinService.getLoaiPham(loaisp);
		NuocSanXuat nuocsxI = layThongTinService.getNuocSanXuat(nuocsx);
		sp.setNhacc(nccI);
		sp.setLoaisp(loaispI);
		sp.setNuocsx(nuocsxI);
		saveImage(request, multipartFile, sp);
		return "OK";
	}

	@PostMapping("/themnhacungcap")
	public String themNhaCungCap(@ModelAttribute("ncc") NhaCungCap ncc) {
		List<NhaCungCap> list = thaoTacNCC.getTatCa(NhaCungCap.class);
		if(list.size() == 0)
			ncc.setMancc("1");
		else
			ncc.setMancc(String.valueOf(list.size()+1));
		thaoTacNCC.Them(ncc);
		return "OK";
	}

	@PostMapping("/themnuocsanxuat")
	public String themNuocSanXuat(@ModelAttribute("nuocsx") NuocSanXuat nsx) {
		List<NuocSanXuat> list = thaoTacNuocSX.getTatCa(NuocSanXuat.class);
		if(list.size() == 0)
			nsx.setManuoc("1");
		else
			nsx.setManuoc(String.valueOf(list.size()+1));
		thaoTacNuocSX.Them(nsx);
		return "OK";
	}

	@PostMapping("/themloaisanpham")
	public String themLoaiSanPham(@ModelAttribute("loaisp") LoaiSanPham loaisp) {
		List<LoaiSanPham> list = thaoTacLoaiSP.getTatCa(LoaiSanPham.class);
		if(list.size() == 0)
			loaisp.setMaloai("1");
		else
			loaisp.setMaloai(String.valueOf(list.size()+1));
		thaoTacLoaiSP.Them(loaisp);
		return "OK";
	}
	

	private void saveImage(HttpServletRequest request, MultipartFile multipartFile, SanPham sp) throws IOException {
		InputStream stream = multipartFile.getInputStream();
		byte[] data = new byte[stream.available()];
		stream.read(data);
		String tenHinh = randomNameFile(request) + "." + multipartFile.getOriginalFilename().split("\\.")[1];
		sp.setUrlhinh(tenHinh);
		spService.themSanPham(sp);
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("resources/imguploads/") + tenHinh;
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
	}
	
	private String randomNameFile(HttpServletRequest request) {
		String url = request.getRealPath("resources/imguploads/");
		File file = new File(url);
		if(!file.exists())
			file.mkdir();
        List<String> getName = new ArrayList<String>();
        
        File folder = new File(request.getRealPath("resources/imguploads/"));
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            getName.add(listOfFiles[i].getName().split("\\.")[0]);
            System.out.println(listOfFiles[i].getName());
          }
        }
        String name = fileNameA();
        if(!(getName.contains(name)))
        		return name;
        else {
        	while(true) {
        		name = fileNameA();
            	if(getName.contains(name) == false)
            		return name;
        	}
        }
	}
	
	private String fileNameA() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
        while (salt.length() < 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
        
	}
	
	
	
	

}
