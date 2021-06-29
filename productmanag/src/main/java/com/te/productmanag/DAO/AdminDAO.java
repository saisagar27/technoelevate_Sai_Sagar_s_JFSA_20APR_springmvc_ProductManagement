package com.te.productmanag.DAO;

import java.util.List;

import com.te.productmanag.beans.Admin;
import com.te.productmanag.beans.Product;

public interface AdminDAO {
	
	public Admin validate(int id,String pwd);
	
	public List<Product> getAll();
	
	public boolean addProd(Product prod);
	
	public boolean delete(int id);

}
