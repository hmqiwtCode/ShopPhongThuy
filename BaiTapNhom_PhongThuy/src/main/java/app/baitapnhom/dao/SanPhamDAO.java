package app.baitapnhom.dao;

import java.util.List;

import app.baitapnhom.entities.SanPham;

public interface SanPhamDAO {
	public List<SanPham> getTatCaSanPham();
	public boolean themSanPham(SanPham sp);
	public SanPham getSanPhamByID(int id);
	

}
