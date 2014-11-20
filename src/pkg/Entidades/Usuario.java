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
		this.id				 = id;
		this.nombre			 = nombre;
		this.idPreceptor 	 = idPreceptor;
		this.nivelAcceso	 = nivelAcceso;
		this.ultimoAcceso	 = ultimoAcceso;
		this.email			 = email;
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
	
	/* TODO: Metodos de la entidad */
	public void actualizarUltimoAcceso() {
		
	}
}
