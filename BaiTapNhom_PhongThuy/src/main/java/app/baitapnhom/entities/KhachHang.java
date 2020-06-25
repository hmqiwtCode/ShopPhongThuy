package app.baitapnhom.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "khachhang")
public class KhachHang implements Serializable {
	@Id
	private String makh;
	private String tenkh;
	private String sdt;
	private String email;
	private String gioitinh;
	private LocalDate ngaysinh;
	@Column(name = "authority")
	private String quyen;
	@OneToMany(cascade = CascadeType.ALL)
	@CollectionTable(
			
			)
	private List<DiaChi> listdiachi;
	
	@OneToMany(mappedBy = "kh",fetch = FetchType.EAGER)
	private List<HoaDon> listhoadon;
	
	public KhachHang() {
		super();
	}
	

	public KhachHang(String makh, String tenkh, String sdt, String email, String gioitinh, LocalDate ngaysinh,
			String quyen) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.sdt = sdt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.quyen = quyen;
	}


	public KhachHang(String tenkh, String sdt, String email, String gioitinh, LocalDate ngaysinh, String quyen) {
		super();
		this.tenkh = tenkh;
		this.sdt = sdt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.quyen = quyen;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public LocalDate getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public List<DiaChi> getListdiachi() {
		return listdiachi;
	}

	public void setListdiachi(List<DiaChi> listdiachi) {
		this.listdiachi = listdiachi;
	}
	
	
	
	public List<HoaDon> getListhoadon() {
		return listhoadon;
	}

	public void setListhoadon(List<HoaDon> listhoadon) {
		this.listhoadon = listhoadon;
	}

	@Override
	public String toString() {
		return "KhachHang [makh=" + makh + ", tenkh=" + tenkh + ", sdt=" + sdt + ", email=" + email + ", gioitinh="
				+ gioitinh + ", ngaysinh=" + ngaysinh + ", quyen=" + quyen + ", listdiachi=" + listdiachi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((makh == null) ? 0 : makh.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (makh == null) {
			if (other.makh != null)
				return false;
		} else if (!makh.equals(other.makh))
			return false;
		return true;
	}
	
	
	

}
