package app.baitapnhom.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable {
	@Id
	@Column(name = "manv", nullable = false)
	private String manv;
	@Column(name = "tennv", nullable = false)
	private String tennv;
	@Column(name = "sdt", nullable = false)
	private String sdt;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "gioitinh", nullable = false)
	private String gioitinh;
	@Column(name = "ngaysinh", nullable = false)
	private LocalDate ngaysinh;
	@OneToOne(cascade = CascadeType.ALL)
	private DiaChi diachi;
	@ElementCollection
	@CollectionTable(name = "authorites", joinColumns = @JoinColumn(name = "manv"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"manv", "authority" }))
	@Column(name = "authority", nullable = false)
	private List<String> quyen;

	@OneToMany(mappedBy = "nv", fetch = FetchType.EAGER) // con cho nay nua mappedBy
	private List<HoaDon> listhd;

	public NhanVien(String manv, String tennv, String sdt, String email, String gioitinh, LocalDate ngaysinh) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.sdt = sdt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}

	public NhanVien() {
		super();
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
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

	public DiaChi getDiachi() {
		return diachi;
	}

	public void setDiachi(DiaChi diachi) {
		this.diachi = diachi;
	}

	public List<String> getQuyen() {
		return quyen;
	}

	public void setQuyen(List<String> quyen) {
		this.quyen = quyen;
	}

	public List<HoaDon> getListhd() {
		return listhd;
	}

	public void setListhd(List<HoaDon> listhd) {
		this.listhd = listhd;
	}

	@Override
	public String toString() {
		return "NhanVien [manv=" + manv + ", tennv=" + tennv + ", sdt=" + sdt + ", email=" + email + ", gioitinh="
				+ gioitinh + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", quyen=" + quyen + ", listhd=" + listhd
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manv == null) ? 0 : manv.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (manv == null) {
			if (other.manv != null)
				return false;
		} else if (!manv.equals(other.manv))
			return false;
		return true;
	}

}
