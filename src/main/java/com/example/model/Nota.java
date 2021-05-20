package com.example.model;


import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

import java.io.Serializable;

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

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String title;

	@Column
	private String description;




}
