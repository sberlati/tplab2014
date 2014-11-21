package pkg.Entidades;

import java.sql.Date;

public class Usuario {
	private int		 id;
	private int 	 idPreceptor;
	private String	 nombre;
	private int		 nivelAcceso;
	private Date	 ultimoAcceso;
	private String	 email;
	
	public Usuario(int id, String nombre, int idPreceptor,int nivelAcceso, Date ultimoAcceso, String email) {
		this.setId(id);
		this.setNombre(nombre);
		this.setIdPreceptor(idPreceptor);
		this.setNivelAcceso(nivelAcceso);
		this.setUltimoAcceso(ultimoAcceso);
		this.setEmail(email);
	}
	
	/* Encapsulamiento */
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getIdPreceptor() {
		return this.idPreceptor;
	}
	
	public int getNivelAcceso() {
		return this.nivelAcceso;
	}
	
	public Date getUltimoAcceso() {
		return this.ultimoAcceso;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdPreceptor(int idPreceptor) {
		this.idPreceptor = idPreceptor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNivelAcceso(int nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
