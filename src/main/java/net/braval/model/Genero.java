package net.braval.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="genero")
public class Genero {

	@Id
	@Column(name="gen_ID")	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(max=10,message="Valor maximo de 10")
	@Column(name="gen_NOM")
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
		return "Genero [id=" + id + ", nombre=" + nombre + "]";
	}
	
		
	
}
