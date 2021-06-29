package com.te.productmanag.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.productmanag.DAO.AdminDAO;
import com.te.productmanag.beans.Admin;
import com.te.productmanag.beans.Product;
import com.te.productmanag.service.AdminService;

@Controller
public class AdminController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("init Binder");
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private AdminService service;
	
	
	@GetMapping("/login")
	public String getLogin() {
		return "prodLogin";
	}
	
	@PostMapping("/login")
	public String validate(int id,String pwd,HttpServletRequest req,ModelMap map) {
		Admin ad=service.validate(id, pwd);
		if(ad!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("loggedIn", ad);
			map.addAttribute("name", ad.getName());
			return "loginHome";
		}
		else {
			map.addAttribute("err", "Wrong Credentials");
			return "prodLogin";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "prodLogin";
	}
	
	@GetMapping("/getall")
	public String getAllProducts(@SessionAttribute(name = "loggedIn",required = false)Admin ad,ModelMap map) {
		if(ad!=null) {
		List<Product> l=service.getAll();
		if(l!=null) {
			map.addAttribute("infos", l);
		}
		else {
			map.addAttribute("err", "Data Not Present");
		}
		return "loginHome";
		}
		else {
			map.addAttribute("errMsg", "Please Login First");
			return "prodLogin";
		}
			
	}
	@GetMapping("/addProduct")
	public String addProduct(@SessionAttribute(name = "loggedIn",required = false)Admin a,ModelMap map) {
		if(a!=null) {
			return "addProduct";
		}
		else {
			map.addAttribute("errMsg", "Please login First");
			
			return "prodLogin";
		}
	}
	
	
	
	@PostMapping("/add")
	public String addProd(Product prod,@SessionAttribute(name = "loggedIn",required = false)Admin ad,ModelMap map) {
		if(ad!=null) {
			if(service.addProd(prod)) {
				map.addAttribute("msg", "Successfully Inserted!!");
			}
			else {
				map.addAttribute("msg", "Failed to Insert!!");
			}
			return "addProduct";
		}
		else {
			map.addAttribute("errMsg","Please Login");
			return "prodLogin";
		}
	}
	@GetMapping("/delete")
	public String delete(@SessionAttribute(name = "loggedIn",required = false)Admin ad,ModelMap map) {
		if(ad!=null) {
		return "deleteProduct";
	}
		else {
			map.addAttribute("errMsg", "Login First");
			return "prodLogin";
		}
}
	@GetMapping("/del")
	public String doDelete(@SessionAttribute(name = "loggedIn",required = false)Admin ad,ModelMap map,int pid) {
		if(ad!=null) {
				if(service.delete(pid)) {
					map.addAttribute("msg", "Product deleted Successfully of id "+pid);
				}
				else {
					map.addAttribute("msg", "Colud not find product  of id "+pid);
				}
			}
	
	return "deleteProduct";
	}	
}


