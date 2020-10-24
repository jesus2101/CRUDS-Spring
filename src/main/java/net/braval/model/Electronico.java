package net.braval.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="electronico")
public class Electronico {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(max=10,message="Maximo 10 caracteres")
	@Column(name="nombre")
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
		return "Electronico [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
