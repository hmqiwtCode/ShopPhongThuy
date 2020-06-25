package app.baitapnhom.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.baitapnhom.dao.LayThongTinDAO;
import app.baitapnhom.entities.LoaiSanPham;
import app.baitapnhom.entities.NhaCungCap;
import app.baitapnhom.entities.NuocSanXuat;
import app.baitapnhom.service.LayThongTinService;

@Service
public class LayThongTinServiceImpl implements LayThongTinService{
	
	@Autowired
	private LayThongTinDAO dao;

	@Override
	@Transactional
	public NhaCungCap getNhaCUngCap(String id) {
		return dao.getNhaCUngCap(id);
	}

	@Override
	@Transactional
	public LoaiSanPham getLoaiPham(String id) {
		return dao.getLoaiPham(id);
	}

	@Override
	@Transactional
	public NuocSanXuat getNuocSanXuat(String id) {
		return dao.getNuocSanXuat(id);
	}

}
