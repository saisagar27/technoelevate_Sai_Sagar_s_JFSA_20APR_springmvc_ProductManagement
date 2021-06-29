package com.te.productmanag.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Product implements Serializable{
	@Id
	@Column
	private int pid;
	
	@Column
	private String pname;
	
	@Column
	private Date mfgDate;
	
	@Column
	private Date expDate;
	
	@Column
	private int price;

}
