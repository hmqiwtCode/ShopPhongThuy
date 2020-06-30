package app.baitapnhom.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.baitapnhom.dao.SanPhamDAO;
import app.baitapnhom.entities.SanPham;

@Repository
public class SanPhamDAOImpl implements SanPhamDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SanPham> getTatCaSanPham() {
		List<SanPham> listSanPham = new ArrayList<SanPham>();
		Session session = sessionFactory.getCurrentSession();
		listSanPham = session.createNativeQuery("select * from sanpham", SanPham.class).getResultList();
		return listSanPham;
	}

	@Override
	public boolean themSanPham(SanPham sp) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(sp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public SanPham getSanPhamByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(SanPham.class, id);
	}

	
	

}
