package net.braval.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="use_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="use_nom")
	private String nombre;
	
	
	@Column(name="use_username")
	private String username;
	
	@Column(name="use_password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="use_id")
	private DetallesUsuario detallesUsuario;
	
	@OneToMany(mappedBy="usuario",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Pedido> pedidos;

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

	public DetallesUsuario getDetallesUsuario() {
		return detallesUsuario;
	}

	public void setDetallesUsuario(DetallesUsuario detallesUsuario) {
		this.detallesUsuario = detallesUsuario;
	}

	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", password=" + password
				+ ", detallesUsuario=" + detallesUsuario + "]";
	}

	public void agregarPedido(Pedido pedido) {
		
		pedidos=new ArrayList<>();
		pedidos.add(pedido);
		pedido.setUsuario(this);
		
	}
	
	

}
