package app.baitapnhom.phongthuy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
		String fileName = "";
		List<SanPham> listSP = spService.getTatCaSanPham();
		if (listSP.size() == 0)
			fileName = "1";
		else
			fileName = String.valueOf(listSP.size() + 1);

		InputStream stream = multipartFile.getInputStream();
		byte[] data = new byte[stream.available()];
		stream.read(data);
		String tenHinh = fileName + "." + multipartFile.getOriginalFilename().split("\\.")[1];
		sp.setUrlhinh(tenHinh);
		spService.themSanPham(sp);
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("resources/imguploads/") + tenHinh;
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
	}
	
	

}
