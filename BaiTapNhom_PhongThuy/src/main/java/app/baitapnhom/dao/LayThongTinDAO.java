package app.baitapnhom.dao;

import app.baitapnhom.entities.KhachHang;
import app.baitapnhom.entities.LoaiSanPham;
import app.baitapnhom.entities.NhaCungCap;
import app.baitapnhom.entities.NuocSanXuat;

public interface LayThongTinDAO {
	public NhaCungCap getNhaCUngCap(String id);
	public LoaiSanPham getLoaiPham(String id);
	public NuocSanXuat getNuocSanXuat(String id);

}
