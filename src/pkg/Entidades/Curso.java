package pkg.Entidades;

public class Curso {
	private int idDivision;
	private int idAno;
	
	public Curso(int idDivision, int idAno) {
		this.idDivision = idDivision;
		this.idAno = idAno;
	}
	
	public int getIdDivision() {
		return this.idDivision;
	}
	
	public int getIdAno() {
		return this.idAno;
	}
}
