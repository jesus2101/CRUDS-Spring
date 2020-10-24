package net.braval.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="serie")
public class Serie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serie_id")
	private int id;
	
	
	
	@NotBlank
	@NotNull
	@Column(name="serie_nom")
	private String nombre;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	

}
