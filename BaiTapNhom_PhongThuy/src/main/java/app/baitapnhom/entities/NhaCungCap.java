package app.baitapnhom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Nationalized;

@SuppressWarnings("serial")
@Entity
public class NhaCungCap implements Serializable{
	@Id
	private String mancc;
	@Nationalized
	private String tenncc;
	
	@OneToMany(mappedBy = "nhacc")
	private List<SanPham> listsp;
	public NhaCungCap(String mancc, String tenncc) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
	}
	public NhaCungCap(String tenncc) {
		super();
		this.tenncc = tenncc;
	}
	public NhaCungCap() {
		super();
	}
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	@Override
	public String toString() {
		return "NhaCungCap [mancc=" + mancc + ", tenncc=" + tenncc + "]";
	}
	
	
}
