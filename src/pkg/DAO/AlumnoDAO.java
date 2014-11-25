package pkg.DAO;

import java.sql.*;
import java.util.ArrayList;

import pkg.Database.SQLConnector;
import pkg.Entidades.Alumno;
import pkg.Entidades.Curso;
import pkg.Utiles.ErrorDialog;


public class AlumnoDAO {
	private SQLConnector conector = new SQLConnector();
	
	public int obtenerFaltas(Alumno alumno) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call alumno_get_faltas(?,?)}");
			proc.setInt(1, alumno.getId());
			proc.registerOutParameter(2, java.sql.Types.INTEGER);
			proc.execute();
			
			return proc.getInt(2);
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return 0;
		}
	}
	
	public boolean registrarAlumno(Alumno alumno) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call alumno_register(?,?,?,?,?)}");
			proc.setInt(1, alumno.getIdDivision());
			proc.setInt(2, alumno.getIdAno());
			proc.setString(3, alumno.getNombre());
			proc.setString(4, alumno.getApellido());
			proc.setInt(5, alumno.getDni());
			
			return true;
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return false;
		}
	}
	
	public void rellenarAlumno(Alumno alumno) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call alumno_get_info(?,?,?,?,?,?)}");
			proc.registerOutParameter(1, java.sql.Types.INTEGER);//IdAlumno
			proc.registerOutParameter(2, java.sql.Types.VARCHAR);//apellido
			proc.registerOutParameter(3, java.sql.Types.INTEGER);//dni
			proc.registerOutParameter(4, java.sql.Types.INTEGER);//IdDivision
			proc.registerOutParameter(5, java.sql.Types.INTEGER);//IdAno
			proc.setString(6, alumno.getNombre());
			proc.execute();
			
			alumno.setId(proc.getInt(1));
			alumno.setApellido(proc.getString(2));
			alumno.setDni(proc.getInt(3));
			alumno.setIdDivision(proc.getInt(4));
			alumno.setIdAno(proc.getInt(5));
			
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
		}
	}
	
	public ArrayList<Alumno> obtenerAlumnosPorCurso(Curso curso) {
		try {
			ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
			CallableStatement proc = this.conector.getConnection().prepareCall("{call alumno_por_curso(?,?)}");
			proc.setInt(1, curso.getIdAno());
			proc.setInt(2, curso.getIdDivision());
			
			ResultSet resultado = proc.executeQuery();
			
			while(resultado.next()) {
				alumnos.add(new Alumno(resultado.getInt("id_alumno"), resultado.getString("nombre"), resultado.getString("apellido"),resultado.getInt("dni"), 
									   resultado.getInt("id_division"), resultado.getInt("id_ano")));
			}
			
			return alumnos;
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return null;
		}
	}
	
	/*
	 * Valores del parámetro 'ordenamiento' son iguales a los de SQL:
	 * - "ASC" Ordena de forma ascendiente
	 * - "DESC" Ordena de forma descendiente
	 */
	public ArrayList<Alumno> obtenerAlumnosPorFaltas(String ordenamiento) {
		try {
			ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
			CallableStatement proc;
			ResultSet resultado;
			switch(ordenamiento.toUpperCase()) {
			case "ASC":
				proc = this.conector.getConnection().prepareCall("{call alumno_by_faltas_menor}");
				resultado = proc.executeQuery();
				
				while(resultado.next()) {
					alumnos.add(new Alumno(resultado.getInt("id_alumno"), resultado.getString("nombre"), resultado.getString("apellido"),resultado.getInt("dni"), 
							   resultado.getInt("id_division"), resultado.getInt("id_ano")));
				}
				break;
				
			case "DESC":
				proc = this.conector.getConnection().prepareCall("{call alumno_by_faltas_mayor}");
				resultado = proc.executeQuery();
				
				while(resultado.next()) {
					alumnos.add(new Alumno(resultado.getInt("id_alumno"), resultado.getString("nombre"), resultado.getString("apellido"),resultado.getInt("dni"), 
							   resultado.getInt("id_division"), resultado.getInt("id_ano")));
				}
				break;
			}
			
			return alumnos;
		}catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return null;
		}
	}
}
