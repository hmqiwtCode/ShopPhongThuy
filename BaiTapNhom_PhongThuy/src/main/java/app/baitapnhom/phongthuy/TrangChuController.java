package app.baitapnhom.phongthuy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import app.baitapnhom.ediachi.Huyen;
import app.baitapnhom.ediachi.Tinh;
import app.baitapnhom.ediachi.Xa;
import app.baitapnhom.entities.DiaChi;
import app.baitapnhom.entities.ItemCart;
import app.baitapnhom.entities.KhachHang;
import app.baitapnhom.entities.NhaCungCap;
import app.baitapnhom.entities.NhanVien;
import app.baitapnhom.entities.SanPham;
import app.baitapnhom.service.SanPhamService;
import app.baitapnhom.service.ThaoTacSanPhamService;

@Controller
@SessionAttributes({ "listItemCart" })
public class TrangChuController {

	@Autowired
	private ThaoTacSanPhamService<NhaCungCap> thaoTacNhaCC;

	@Autowired
	private ThaoTacSanPhamService<KhachHang> thaoTacKhachHang;

	@Autowired
	private ThaoTacSanPhamService<NhanVien> thaoTacNhanVien;


	@Autowired
	private SanPhamService spService;

	@ModelAttribute("listItemCart")
	public List<ItemCart> createListItemCart() {
		System.out.println("1");
		return new ArrayList<ItemCart>();
	}

	@RequestMapping(value = { "/", "/trangchu" })
	public String hienThiSanPham(Model model, @ModelAttribute("listItemCart") List<ItemCart> listItemCart) {
		List<NhaCungCap> listNCC = thaoTacNhaCC.getTatCa(NhaCungCap.class);
		List<NhaCungCap> listChuyen = new ArrayList<NhaCungCap>();
		for (int i = 0; i < listNCC.size(); i++) {
			System.out.println(listNCC.get(i));
			if (!listChuyen.contains(listNCC.get(i)))
				listChuyen.add(listNCC.get(i));
		}
		model.addAttribute("listSPController", listChuyen);
		model.addAttribute("sl", String.valueOf(listItemCart.size()));
		return "stores";
	}

	@PostMapping(value = "/themSanPhamGioHang", headers = { "Content-type=application/json" })
	@ResponseBody
	public String themSanPham(Model model, @RequestBody ItemCart itemCart,
			@ModelAttribute("listItemCart") List<ItemCart> listItemCart) {
		int id = itemCart.getMaSanPham();
		SanPham sp = spService.getSanPhamByID(id);
		itemCart.setMaSanPham(sp.getMasp());
		itemCart.setTenSanPham(sp.getTensp());
		itemCart.setGiaTien(sp.getGiaban());
		itemCart.setTongTien(itemCart.getGiaTien() * itemCart.getSoLuong());
		itemCart.setUrlHinh(sp.getUrlhinh());
		if (!(listItemCart.contains(itemCart))) {
			itemCart.setSoLuong(itemCart.getSoLuong() + 1);
			listItemCart.add(itemCart);
		} else {
			ItemCart cartSL = new ItemCart();
			for (int i = 0; i < listItemCart.size(); i++) {
				if (listItemCart.get(i).getMaSanPham() == itemCart.getMaSanPham()) {
					cartSL = listItemCart.get(i);
				}
			}
			cartSL.setSoLuong(cartSL.getSoLuong() + 1);

		}
		// model.addAttribute("listItemCart", listItemCart);
		return String.valueOf(listItemCart.size());
	}

	@GetMapping("/checkout/cart")
	public String hienThiCartItem(Model model, @ModelAttribute("listItemCart") List<ItemCart> listItemCart) {
		double tongTien = 0.0;
		for (int i = 0; i < listItemCart.size(); i++) {
			double sp = listItemCart.get(i).getGiaTien();
			int soLuong = listItemCart.get(i).getSoLuong();
			tongTien += sp * soLuong;
		}
		System.out.println(tongTien);
		model.addAttribute("listTemp", listItemCart);
		model.addAttribute("tongTien", tongTien);
		return "cart";
	}

	@PostMapping(value = "/checkout/updateCartItem", headers = { "Content-type=application/json" })
	@ResponseBody
	public String capNhatSanPhamGioHang(Model model, @RequestBody ItemCart itemCart,
			@ModelAttribute("listItemCart") List<ItemCart> listItemCart) {
		int id = itemCart.getMaSanPham();
		int soLuong = itemCart.getSoLuong();

		for (int i = 0; i < listItemCart.size(); i++) {
			if (listItemCart.get(i).getMaSanPham() == id) {
				listItemCart.get(i).setSoLuong(soLuong);
			}
		}
		double tongTien = 0.0;
		for (int i = 0; i < listItemCart.size(); i++) {
			double sp = listItemCart.get(i).getGiaTien();
			int soLuongSP = listItemCart.get(i).getSoLuong();
			tongTien += sp * soLuongSP;
		}
		if (soLuong == 0) {
			for (int i = 0; i < listItemCart.size(); i++) {
				if (listItemCart.get(i).getMaSanPham() == id)
					listItemCart.remove(i);
			}
			return String.valueOf(tongTien);
		}

		return String.valueOf(tongTien);
	}

	@GetMapping("/checkout/shipping")
	public String thanhToan(Model model, Principal principal)
			throws MalformedURLException, IOException, InterruptedException {
		kiemTraTaiKhoan(model,principal);
		model.addAttribute("listTP", getTinhThanh());
		model.addAttribute("diachi", new DiaChi());
		return "DiaChiThanhToan";
	}
	
	
	private void kiemTraTaiKhoan(Model model, Principal principal) {
		@SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < authorities.size(); i++) {
			sb.append(authorities.get(i).toString());
		}

		if (sb.toString().contains("ROLE_QUANLY")) {
			List<NhanVien> listNhanVien = thaoTacNhanVien.getTatCa(NhanVien.class);
			for (int i = 0; i < listNhanVien.size(); i++) {
				if (listNhanVien.get(i).getMa().equals(principal.getName())) {
					NhanVien nv = null;
					nv = listNhanVien.get(i);
					model.addAttribute("nguoi", nv);

				}
			}
		} else {
			List<KhachHang> listKhachHangs = thaoTacKhachHang.getTatCa(KhachHang.class);
			for (int i = 0; i < listKhachHangs.size(); i++) {
				if (listKhachHangs.get(i).getMa().equals(principal.getName())) {
					KhachHang kh = null;
					kh = listKhachHangs.get(i);
					model.addAttribute("nguoi", kh);

				}
			}

		}
	}

	private static List<Tinh> getTinhThanh() throws MalformedURLException, IOException, InterruptedException {
		List<Tinh> contactList = new ArrayList<Tinh>();
		URL url = new URL("https://thongtindoanhnghiep.co/api/city");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code : " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			JsonParser jsonParser = new JsonParser();
			JsonObject jo = (JsonObject) jsonParser.parse(response.toString());
			JsonArray jsonArr = jo.getAsJsonArray("LtsItem");
			Gson googleJson = new Gson();

			Type type = new TypeToken<List<Tinh>>() {
			}.getType();
			contactList = googleJson.fromJson(jsonArr, type);
			in.close();
		}
		return contactList;

	}

	@PostMapping(value = "/checkout/getHuyen", headers = { "Content-type=application/json" })
	@ResponseBody
	public String getHuyen(@RequestBody Huyen huyen) throws MalformedURLException, IOException, InterruptedException {

		return getHuyenMa(huyen.getID());
	}

	private static String getHuyenMa(int id) throws MalformedURLException, IOException, InterruptedException {
		StringBuilder bl = new StringBuilder();
		URL url = new URL("https://thongtindoanhnghiep.co/api/city/" + id + "/district");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code : " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			Gson googleJson = new Gson();

			Type type = new TypeToken<List<Huyen>>() {
			}.getType();
			List<Huyen> contactList = googleJson.fromJson(response.toString(), type);
			for (int i = 0; i < contactList.size(); i++) {
				bl.append(contactList.get(i).getID() + ":" + contactList.get(i).getTitle());
				if (i < contactList.size() - 1)
					bl.append(",");
			}

			in.close();
		}
		return bl.toString();

	}

	@PostMapping(value = "/checkout/getXa", headers = { "Content-type=application/json" })
	@ResponseBody
	public String getXa(@RequestBody Xa xa) throws MalformedURLException, IOException, InterruptedException {
		StringBuffer response = new StringBuffer();
		StringBuffer rl = new StringBuffer();
		URL url = new URL("https://thongtindoanhnghiep.co/api/district/"+xa.getQuanhuyenid()+"/ward");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code : " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			Gson googleJson = new Gson();

			Type type = new TypeToken<List<Xa>>() {
			}.getType();
			List<Xa> contactList = googleJson.fromJson(response.toString(), type);
			for (int i = 0; i < contactList.size(); i++) {
				rl.append(contactList.get(i).getTitle());
				if (i < contactList.size() - 1)
					rl.append(",");
			}

			in.close();
		}

		return rl.toString();
	}
	
	
	@PostMapping(value = "/checkout/themDiaChi", headers = { "Content-type=application/json" })
	@ResponseBody
	public String themDiaChi(@RequestBody DiaChi diaChi,Principal principal) {
		KhachHang kh = null;
		List<KhachHang> listKH = thaoTacKhachHang.getTatCa(KhachHang.class);
		for (int i = 0; i < listKH.size(); i++) {
			if(listKH.get(i).getMa().equals(principal.getName()))
				kh = listKH.get(i);
		}
		kh.setListdiachi(Arrays.asList(diaChi));
		thaoTacKhachHang.Sua(kh);
		return "Thành Công";
	}
	
	@RequestMapping("/checkout/payment")
	public String payment(Model model,@ModelAttribute("listItemCart") List<ItemCart> listItemCart,Principal principal) {
		kiemTraTaiKhoan(model,principal);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
        date.setDate(date.getDate() + 7);
        model.addAttribute("date", formatter.format(date).toString());
        model.addAttribute("listItemInCart", listItemCart);
		return "payment";
	}

}