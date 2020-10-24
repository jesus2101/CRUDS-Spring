package net.braval.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="animal")
public class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ani_ID")
	public int id;
	
	@Size(max=10, message="Valores maximos aceptados 10")
	@Column(name="ani_NOM")
	public String nombre;

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
		return "Animal [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
