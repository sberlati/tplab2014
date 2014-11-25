package pkg.DAO;

import java.sql.*;
import java.util.ArrayList;

import pkg.Database.SQLConnector;
import pkg.Entidades.Curso;
import pkg.Utiles.ErrorDialog;

public class CursoDAO {
	private SQLConnector conector = new SQLConnector();
	
	public ArrayList<Curso> obtenerCursos() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call cursos_cargar}");
			ResultSet resultado = proc.executeQuery();
		
			while(resultado.next()) {
				cursos.add(new Curso(resultado.getInt("id_division"), resultado.getInt("id_ano"), resultado.getInt("num_ano"), resultado.getInt("num_division")));
			}
			
		}catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
		}
		return cursos;
	}
}

