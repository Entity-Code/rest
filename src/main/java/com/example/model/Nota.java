package com.example.model;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

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
