package pkg.DAO;

import java.sql.*;
import java.util.ArrayList;

import pkg.Database.SQLConnector;
import pkg.Entidades.Preceptor;
import pkg.Utiles.ErrorDialog;

public class UsuarioDAO {
	SQLConnector conector = new SQLConnector();
	
	public String obtenerPassword(String nombre) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call login_get_password(?,?)}");
			proc.registerOutParameter(1, java.sql.Types.VARCHAR);
			proc.setString(2, nombre);
			proc.execute();
			
			return proc.getString(1);
			
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return null;
		}
	}
	
	public void rellenarUsuario(Preceptor usuario) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call user_get_info(?,?,?,?,?,?)}");
			proc.setString(1,usuario.getNombre());
			proc.registerOutParameter(2, java.sql.Types.INTEGER); //Id de usuario
			proc.registerOutParameter(3, java.sql.Types.INTEGER); //Id de preceptor
			proc.registerOutParameter(4, java.sql.Types.INTEGER); //nivel de acceso
			proc.registerOutParameter(5, java.sql.Types.DATE);	  //ultimo acceso
			proc.registerOutParameter(6, java.sql.Types.VARCHAR); //email
			
			usuario.setId(proc.getInt(2));
			usuario.setIdPreceptor(proc.getInt(3));
			usuario.setNivelAcceso(proc.getInt(4));
			usuario.setUltimoAcceso(proc.getDate(5));
			usuario.setEmail(proc.getString(6));
			
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
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
			new ErrorDialog("Excepción SQL", e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean usuarioExiste(String nombre) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call login_check_userExist(?,?)}");
			proc.registerOutParameter(1, java.sql.Types.INTEGER);
			proc.setString(2, nombre);
			proc.execute();
			
			if(proc.getInt(1) > 0) {
				return true;
			}else{
				return false;
			}
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Preceptor> obtenerPreceptores() {
		try {
			ArrayList<Preceptor> usuarios = new ArrayList<Preceptor>();
			CallableStatement proc = this.conector.getConnection().prepareCall("{call users_get_preceptores}");
			ResultSet resultado = proc.executeQuery();
			while(resultado.next()) {
				usuarios.add(new Preceptor(resultado.getInt("id_usuario"),resultado.getString("nombre_usuario"), resultado.getInt("id_preceptor"),
										 resultado.getInt("nivel_acceso"), resultado.getDate("ult_acceso"), resultado.getString("email")));
			}
			return usuarios;
		}catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return null;
		}
	}
	
	public void modificarUsuario(Preceptor usuario) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call login_check_userExist(?,?)}");
			proc.registerOutParameter(1, java.sql.Types.INTEGER);
			proc.setString(2, usuario.getNombre());
			proc.execute();
			
			if(proc.getInt(1) < 1) {
				new ErrorDialog("Error de coincidencia", "El usuario que se quiere modificar no existe en la base de datos (UsuarioDAO.java - 107).");
			}else{
				CallableStatement _proc = this.conector.getConnection().prepareCall("{call user_modificar(?,?,?,?,?)}");
				_proc.setInt(1, usuario.getId());
				_proc.setString(2, usuario.getNombre());
				_proc.setInt(3, usuario.getNivelAcceso());
				_proc.setDate(4, usuario.getUltimoAcceso());
				_proc.setString(5, usuario.getEmail());
				
				_proc.execute();
			}
		}catch (SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
		}
	}
	
	public void modificarPassword(Preceptor master, Preceptor usuario, String nuevaContrasena) {
		if(master.getNivelAcceso() >= 2) {
			try {
				CallableStatement proc = this.conector.getConnection().prepareCall("{call user_modificar_password(?,?)}");
				proc.setInt(1, usuario.getId());
				proc.setString(2, nuevaContrasena);
				
				proc.execute();	
			}catch(SQLException e){
				new ErrorDialog("Excepción SQL", e.getMessage());
			}
		}else{
			new ErrorDialog("Error de permisos", "El usuario de esta sesión no tiene permisos suficientes para ejecutar esta acción (UsuarioDAO.java).");
		}
	}
	
	public void eliminarUsuario(Preceptor master, Preceptor usuario) {
		if(master.getNivelAcceso() >= 2) {
			try {
				CallableStatement proc = this.conector.getConnection().prepareCall("{call usuario_delete(?)}");
				proc.setInt(1, usuario.getId());
				proc.execute();
			} catch(SQLException e) {
				new ErrorDialog("Excepción SQL", e.getMessage());
			}
		}else{
			new ErrorDialog("Error de permisos", "El usuario de esta sesión no tiene permisos suficientes para ejecutar esta acción (UsuarioDAO.java).");
		}
	}
	
	public void suspenderUsuario(Preceptor master, Preceptor usuario) {
		if(master.getNivelAcceso() >= 2) {
			try {
				CallableStatement proc = this.conector.getConnection().prepareCall("{call user_suspender(?)}");
				proc.setInt(1, usuario.getId());
				proc.execute();
			} catch(SQLException e) {
				new ErrorDialog("Excepción SQL", e.getMessage());
			}
		}else{
			new ErrorDialog("Error de permisos", "El usuario de esta sesión no tiene permisos suficientes para ejecutar esta acción (UsuarioDAO.java).");
		}
	}
	
	public void quitarSuspension(Preceptor master, Preceptor usuario) {
		if(master.getNivelAcceso() >= 2) {
			try {
				CallableStatement proc = this.conector.getConnection().prepareCall("{call user_quitar_suspension(?)}");
				proc.setInt(1, usuario.getId());
				proc.execute();
			}catch(SQLException e) {
				new ErrorDialog("Excepción SQL", e.getMessage());
			}
		}else{
			new ErrorDialog("Error de permisos", "El usuario de esta sesión no tiene permisos suficientes para ejecutar esta acción (UsuarioDAO.java).");
		}
	}
	
}
