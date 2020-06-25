package app.baitapnhom.phongthuy;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.baitapnhom.entities.KhachHang;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login";
	}
	
	@GetMapping("/dangky")
	public String dangKyTaiKhoan(Model model) {
		KhachHang khachhang = new KhachHang();
		model.addAttribute("khachhang", khachhang);
		return "register";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		
		return "login";
	}
	
	@PostMapping("/taikhoandangky")
	public String dangkytaikhoan(@ModelAttribute("khachhang") KhachHang kh) {
		System.out.println(kh.getMakh());
		System.out.println(kh.getGioitinh());
		return "redirect:/test";
	}
	
	
	
}
