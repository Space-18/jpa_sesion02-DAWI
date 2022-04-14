package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_proveedor")
public class Proveedor {
	@Id
	private int idprovedor;
	private String nombre_rs;
	private String telefono;
	private String email;
	
	public Proveedor(int idprovedor, String nombre_rs, String telefono, String email) {
		super();
		this.idprovedor = idprovedor;
		this.nombre_rs = nombre_rs;
		this.telefono = telefono;
		this.email = email;
	}

	public Proveedor() {
		super();
	}

	@Override
	public String toString() {
		return "Proveedor [idprovedor=" + idprovedor + ", nombre_rs=" + nombre_rs + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}

	public int getIdprovedor() {
		return idprovedor;
	}

	public void setIdprovedor(int idprovedor) {
		this.idprovedor = idprovedor;
	}

	public String getNombre_rs() {
		return nombre_rs;
	}

	public void setNombre_rs(String nombre_rs) {
		this.nombre_rs = nombre_rs;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
