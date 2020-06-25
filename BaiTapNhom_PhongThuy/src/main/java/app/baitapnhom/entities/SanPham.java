package app.baitapnhom.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable{
	@Id
	private int masp;
	private String tensp;
	private int soluongton;
	private double gianhap;
	private double giaban;
	private String urlhinh;
	
	@ManyToOne
	@JoinColumn(name = "nuocsx")
	private NuocSanXuat nuocsx;
	
	@ManyToOne
	@JoinColumn(name = "loaisp")
	private LoaiSanPham loaisp;
	
	@ManyToOne
	@JoinColumn(name = "nhacc")
	private NhaCungCap nhacc;

	public SanPham(String tensp, int soluongton, double gianhap, double giaban, String urlhinh) {
		super();
		this.tensp = tensp;
		this.soluongton = soluongton;
		this.gianhap = gianhap;
		this.giaban = giaban;
		this.urlhinh = urlhinh;
	}

	public SanPham(int masp, String tensp, int soluongton, double gianhap, double giaban, String urlhinh) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.soluongton = soluongton;
		this.gianhap = gianhap;
		this.giaban = giaban;
		this.urlhinh = urlhinh;
	}

	public SanPham() {
		super();
	}

	public int getMasp() {
		return masp;
	}

	public void setMasp(int masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getSoluongton() {
		return soluongton;
	}

	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}

	public double getGianhap() {
		return gianhap;
	}

	public void setGianhap(double gianhap) {
		this.gianhap = gianhap;
	}

	public double getGiaban() {
		return giaban;
	}

	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}

	public String getUrlhinh() {
		return urlhinh;
	}

	public void setUrlhinh(String urlhinh) {
		this.urlhinh = urlhinh;
	}

	public NuocSanXuat getNuocsx() {
		return nuocsx;
	}

	public void setNuocsx(NuocSanXuat nuocsx) {
		this.nuocsx = nuocsx;
	}

	public LoaiSanPham getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(LoaiSanPham loaisp) {
		this.loaisp = loaisp;
	}

	public NhaCungCap getNhacc() {
		return nhacc;
	}

	public void setNhacc(NhaCungCap nhacc) {
		this.nhacc = nhacc;
	}

	@Override
	public String toString() {
		return "SanPham [masp=" + masp + ", tensp=" + tensp + ", soluongton=" + soluongton + ", gianhap=" + gianhap
				+ ", giaban=" + giaban + ", urlhinh=" + urlhinh + ", nuocsx=" + nuocsx + ", loaisp=" + loaisp
				+ ", nhacc=" + nhacc + "]";
	}
	

	
}
