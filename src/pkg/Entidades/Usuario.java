package pkg.Entidades;

public class Usuario {
	private int		 id;
	private String	 nombre;
	private int		 nivelAcceso;
	private String	 ultimoAcceso;
	private String	 email;
	
	public Usuario(int id, String nombre, int nivelAcceso, String ultimoAcceso, String email) {
		this.id				 = id;
		this.nombre			 = nombre;
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
	
	public int getNivelAcceso() {
		return this.nivelAcceso;
	}
	
	public String getUltimoAcceso() {
		return this.ultimoAcceso;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	/* TODO: Metodos de la entidad */
	public void actualizarUltimoAcceso() {
		
	}
}
