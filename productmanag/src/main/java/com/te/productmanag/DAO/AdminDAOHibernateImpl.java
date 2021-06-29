package com.te.productmanag.DAO;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.te.productmanag.beans.Admin;
import com.te.productmanag.beans.Product;

@Repository
public class AdminDAOHibernateImpl implements AdminDAO{

	@Override
	public Admin validate(int id, String pwd) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringDB");
		EntityManager manager = factory.createEntityManager();
		Admin ad = manager.find(Admin.class, id);
		
	 
			if(ad.getPassword().equals(pwd)) {
			return ad;
			}
			
			else {
				return null;
			}
	}

	@Override
	public List<Product> getAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringDB");
		EntityManager manager = factory.createEntityManager();
		String s="from Product";
		Query q=manager.createQuery(s);
		List<Product> l=q.getResultList();
		
		return l;
	}

	@Override
	public boolean addProd(Product prod) {
		boolean isAdded=false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringDB");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction et=manager.getTransaction();
		
		if(prod!=null) {
		et.begin();
		manager.persist(prod);
		et.commit();
		isAdded=true;
		
		}
		return isAdded;
		}

	@Override
	public boolean delete(int id) {
		boolean isDeleted=false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringDB");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction et=manager.getTransaction();
		
		if(id>0) {
		et.begin();
		Product p=manager.find(Product.class, id);
		manager.remove(p);
		et.commit();
		isDeleted=true;
		
		}
		return isDeleted;
	}
		

}
