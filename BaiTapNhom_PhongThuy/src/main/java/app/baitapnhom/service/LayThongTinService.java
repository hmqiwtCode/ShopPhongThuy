package app.baitapnhom.service;

import app.baitapnhom.entities.LoaiSanPham;
import app.baitapnhom.entities.NhaCungCap;
import app.baitapnhom.entities.NuocSanXuat;

public interface LayThongTinService {
	public NhaCungCap getNhaCUngCap(String id);
	public LoaiSanPham getLoaiPham(String id);
	public NuocSanXuat getNuocSanXuat(String id);

}
