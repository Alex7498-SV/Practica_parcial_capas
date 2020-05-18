package com.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_contribuyente;
	
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(referencedColumnName = "c_importancia", name = "c_importancia")
	private Importancia c_importancia;
	
	@Column(name="s_nombre")
	@Size(message = "El nombre no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String Nombre;
	
	@Column(name="s_apellido")
	@Size(message = "El apellido no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String Apellido;
	
	@Column(name="s_nit")
	@Size(message = "El nit no debe de tener mas de 14 caracteres",max=14)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fecha;
	
	public Contribuyente() {}
	
	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public Importancia getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Importancia c_importancia) {
		this.c_importancia = c_importancia;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
}
