package pkg.DAO;

import java.sql.*;

import pkg.Database.SQLConnector;
import pkg.Entidades.Alumno;


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
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
		}
	}
}
