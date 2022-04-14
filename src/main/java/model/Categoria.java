package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tb_categorias")
public class Categoria {
	@Id
	private int idcategoria;
	private String descripcion;
	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idcategoria + ", descripcion=" + descripcion + "]";
	}

	public int getIdCategoria() {
		return idcategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idcategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria(int idCategoria, String descripcion) {
		super();
		this.idcategoria = idCategoria;
		this.descripcion = descripcion;
	}
	
	public Categoria() {
		
	}
}
