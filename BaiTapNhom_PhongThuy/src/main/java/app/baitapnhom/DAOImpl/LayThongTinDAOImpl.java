package app.baitapnhom.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.baitapnhom.dao.LayThongTinDAO;
import app.baitapnhom.entities.LoaiSanPham;
import app.baitapnhom.entities.NhaCungCap;
import app.baitapnhom.entities.NuocSanXuat;

@Repository
public class LayThongTinDAOImpl implements LayThongTinDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public NhaCungCap getNhaCUngCap(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(NhaCungCap.class, id);
	}

	@Override
	public LoaiSanPham getLoaiPham(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(LoaiSanPham.class, id);
		
	}

	@Override
	public NuocSanXuat getNuocSanXuat(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(NuocSanXuat.class, id);
		
	}

}
