package pkg.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioDAO extends DAO {
	private String nombre;
	private String password;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public UsuarioDAO(Connection conexion, String nombre, String password) {
		super(conexion);
		this.nombre = nombre;
		this.password = password;
	}
	
	public void iniciarSesion() {
		try {
			CallableStatement cblogin = super.getConnection().prepareCall("");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean usuarioExiste(String nombre) {
		try {
			CallableStatement cbuserExists = super.getConnection().prepareCall("{call login_check_userExists(?, ?)}");
			cbuserExists.registerOutParameter(1, java.sql.Types.INTEGER);
			cbuserExists.setString(1, nombre);
			cbuserExists.execute();
			
			if(cbuserExists.getInt(1) > 0) {
				return true;
			}else{
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
}
