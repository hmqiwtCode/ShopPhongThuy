package app.baitapnhom.phongthuy;

import java.security.Principal;
import java.util.ArrayList;
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
				if(listItemCart.get(i).getMaSanPham() == id)
					listItemCart.remove(i);
			}
			return String.valueOf(tongTien);
		}

		return String.valueOf(tongTien);
	}
	
	
	@GetMapping("/checkout/shipping")
	public String thanhToan(Model model,Principal principal) {
		@SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < authorities.size(); i++) {
			sb.append(authorities.get(i).toString());
		}
		
		if(sb.toString().contains("ROLE_QUANLY")) {
			List<NhanVien> listNhanVien = thaoTacNhanVien.getTatCa(NhanVien.class);
			for (int i = 0; i < listNhanVien.size(); i++) {
				if(listNhanVien.get(i).getMa().equals(principal.getName())) {
					NhanVien nv = null;
					nv = listNhanVien.get(i);
					model.addAttribute("nguoi", nv);
					
				}
			}
		}else {
			List<KhachHang> listKhachHangs = thaoTacKhachHang.getTatCa(KhachHang.class);
			for (int i = 0; i < listKhachHangs.size(); i++) {
				if(listKhachHangs.get(i).getMa().equals(principal.getName())) {
					KhachHang kh = null;
					kh = listKhachHangs.get(i);
					model.addAttribute("nguoi", kh);
					
				}
			}
			
		}
		model.addAttribute("diachi", new DiaChi());
		return "DiaChiThanhToan";
	}

}