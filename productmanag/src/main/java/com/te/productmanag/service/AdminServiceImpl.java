package com.te.productmanag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmanag.DAO.AdminDAO;
import com.te.productmanag.beans.Admin;
import com.te.productmanag.beans.Product;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO dao;
	
	@Override
	public Admin validate(int id, String pwd) {
		if(id<=0)
		return null;
		
		else
			return dao.validate(id, pwd);
	}

	@Override
	public List<Product> getAll() {
		
		return dao.getAll();
	}

	@Override
	public boolean addProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.addProd(prod);
	}

	@Override
	public boolean delete(int id) {
		if(id>0)
		return dao.delete(id);
		else
			return false;
	}

}
