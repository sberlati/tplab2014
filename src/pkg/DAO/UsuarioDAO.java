package pkg.DAO;

import java.sql.*;

import pkg.Database.SQLConnector;
import pkg.Entidades.Usuario;

public class UsuarioDAO {
	SQLConnector conector = new SQLConnector();
	
	public String obtenerPassword(String nombre) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call login_get_password(?,?)}");
			proc.registerOutParameter(1, java.sql.Types.VARCHAR);
			proc.setString(2, nombre);
			
			ResultSet resultado = proc.executeQuery();
			if(resultado.next()) {
				return resultado.getString("clave_acceso");
			}else{
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
	
	public Usuario generarUsuario(String nombre) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call user_get_info(?,?,?,?,?,?)}");
			proc.setString(1, nombre);
			proc.registerOutParameter(2, java.sql.Types.INTEGER); //Id de usuario
			proc.registerOutParameter(3, java.sql.Types.INTEGER); //Id de preceptor
			proc.registerOutParameter(4, java.sql.Types.INTEGER); //nivel de acceso
			proc.registerOutParameter(5, java.sql.Types.DATE);	  //ultimo acceso
			proc.registerOutParameter(6, java.sql.Types.VARCHAR); //email
			
			ResultSet resultado = proc.executeQuery();
			Usuario retorno = new Usuario(resultado.getInt(2), nombre, resultado.getInt(3), resultado.getInt(4), resultado.getDate(5), resultado.getString(6));
			return retorno;
		} catch(SQLException e) {
			return null;
		}
	}
	
	public boolean registrarUsuario(int id_preceptor, String nombre, String password, int nivelAcceso, String email) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call user_register(?,?,?,?,?,?)}");
			proc.setInt(1, id_preceptor);
			proc.setString(2, nombre);
			proc.setString(3, password);
			proc.setInt(4, nivelAcceso);
			proc.setString(5, email);
			
			proc.execute();
		} catch(SQLException e) {
			return false;
		}
		return true;
	}
	
	
}
