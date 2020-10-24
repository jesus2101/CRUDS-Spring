package net.braval.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="personaje")
public class Personaje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="per_id")	
	private int id;
	
	
	@Size(max=20,message="Maximo 20 caracteres")
	@Column(name="per_nom")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="emp_id")	
	private Empresa empresa;

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", empresa=" + empresa + "]";
	}
	
	
	

}
