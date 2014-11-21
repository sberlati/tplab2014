package pkg.Entidades;

public class Alumno {
	private int		 id;
	private String	 nombre;
	private String	 apellido;
	private int		 dni;
	private int		 idDivision;
	private int 	 idAno;
	
	public Alumno(int id, String nombre, String apellido, int dni, int idDivision, int idAno) {
		this.id			 = id;
		this.nombre		 = nombre;
		this.setApellido(apellido);
		this.setDni(dni);
		this.setIdDivision(idDivision);
		this.setIdAno(idAno);
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
	
	public int getIdDivision() {
		return this.idDivision;
	}
	
	public int getIdAno() {
		return this.idAno;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
	}

	public void setIdAno(int idAno) {
		this.idAno = idAno;
	}
	
	
}
 