package com.te.productmanag.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Admin implements Serializable{
	
@Id
@Column
private int id;

@Column
private String name;

@Column
private String password;
}
