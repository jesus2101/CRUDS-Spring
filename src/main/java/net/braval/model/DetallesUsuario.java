package net.braval.model;

import javax.persistence.*;

@Entity
@Table(name="detallesusuario")
public class DetallesUsuario {

	
	@Id
	@Column(name="detU_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="detU_direccion")
	private String direccion;
	
	
	@Column(name="detU_telefono")
	private String telefono;
	
	/*@OneToOne(mappedBy="detallesUsuario", cascade=CascadeType.ALL)
	private Usuario usuario;


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "DetallesUsuario [id=" + id + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
	
	
	
	
}
