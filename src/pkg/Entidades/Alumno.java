package pkg.Entidades;

public class Alumno {
	private int		 id;
	private String	 nombre;
	private String	 apellido;
	private int		 dni;
	
	public Alumno(int id, String nombre, String apellido, int dni) {
		this.id			 = id;
		this.nombre		 =	 nombre;
		this.apellido	 = apellido;
		this.dni		 = dni;
	}
	
	/* Encapsulamiento */
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	/* TODO: Métodos de la entidad */
	
	public int obtenerFaltas() {
		return 0;
	}
}
