package net.braval.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="banda")
public class Banda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_banda")
	private int id;
	
	@Size(max=15,message="Tamaño maximo de 15 caracteres")
	@Column(name="nombre_banda")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="gen_ID")
	private Genero genero;

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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Banda [id=" + id + ", nombre=" + nombre + ", genero=" + genero + "]";
	}
	
	

}
