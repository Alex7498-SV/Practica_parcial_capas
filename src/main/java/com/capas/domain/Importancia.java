package com.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema="public", name="importancia")
public class Importancia {

	@Id
	@Column(name="c_importancia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_importancia;
	
	@Column(name="s_importancia")
	private String importancia;
	

	public Importancia() {}
	
	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	
}
