package com.te.productmanag.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.te.productmanag.DAO.AdminDAO;
import com.te.productmanag.beans.Admin;
import com.te.productmanag.beans.Product;

import java.util.*;




public interface AdminService {
	public Admin validate(int id,String pwd);
	
	public List<Product> getAll();
	
	public boolean addProd(Product prod);
	
	public boolean delete(int id);
	
	
	

}
