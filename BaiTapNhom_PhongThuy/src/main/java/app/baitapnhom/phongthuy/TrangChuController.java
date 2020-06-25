package app.baitapnhom.phongthuy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
	
	@GetMapping("/trangchu")
	public String hienThiSanPham() {
		return "stores";
	}

}
