package com.example.model;


import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="nota")
@Data
public class Nota implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3670248508018192566L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String description;



}
