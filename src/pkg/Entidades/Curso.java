package pkg.Entidades;

public class Curso {
	private int idDivision;
	private int idAno;
	private int numAno;
	private int numDivision;
	public Curso(int idDivision, int idAno, int numAno, int numDivision) {
		this.idDivision = idDivision;
		this.idAno = idAno;
		this.numAno = numAno;
		this.numDivision = numDivision;
	}
	
	public int getNumAno() {
		return this.numAno;
	}
	
	public int getNumDivision() {
		return this.numDivision;
	}
	
	public int getIdDivision() {
		return this.idDivision;
	}
	
	public int getIdAno() {
		return this.idAno;
	}
	
	public String getAsCadena() {
		return getNumAno() + "° " + getNumDivision();
	}
}
