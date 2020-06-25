package app.baitapnhom.service;

import java.util.List;

import app.baitapnhom.entities.SanPham;

public interface SanPhamService {
	public List<SanPham> getTatCaSanPham();
	public boolean themSanPham(SanPham sp);

}
