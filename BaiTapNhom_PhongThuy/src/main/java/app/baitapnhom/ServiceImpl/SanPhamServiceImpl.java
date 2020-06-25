package app.baitapnhom.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.baitapnhom.dao.SanPhamDAO;
import app.baitapnhom.entities.SanPham;
import app.baitapnhom.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamDAO spDAO;
	
	@Override
	@Transactional
	public List<SanPham> getTatCaSanPham() {
		List<SanPham> listSanPham = spDAO.getTatCaSanPham();
		return listSanPham;
	}

	@Override
	@Transactional
	public boolean themSanPham(SanPham sp) {
		boolean check = spDAO.themSanPham(sp);
		return check;
	}

}
