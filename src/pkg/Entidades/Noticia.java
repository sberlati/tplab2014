package pkg.Entidades;

public class Noticia {
	private int id;
	private String contenido;
	private String fechaEmision;
	
	public Noticia( int id, String contenido, String fechaEmision) {
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
	
	public String getFechaEmision() {
		return this.fechaEmision;
	}
	
	/* TODO: Métodos de la entidad */
}
