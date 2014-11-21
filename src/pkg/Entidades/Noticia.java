package pkg.Entidades;

import java.sql.Date;

public class Noticia {
	private int id;
	private String contenido;
	private Date fechaEmision;
	
	public Noticia( int id, String contenido, Date fechaEmision) {
		this.id				 = id;
		this.contenido		 = contenido;
		this.fechaEmision	 = fechaEmision;
	}
	
	/* Encapsulamiento */
	public int getId() {
		return this.id;
	}
	
	public String getContenido() {
		return this.contenido;
	}
	
	public Date getFechaEmision() {
		return this.fechaEmision;
	}
	
	/* TODO: Métodos de la entidad */
}
