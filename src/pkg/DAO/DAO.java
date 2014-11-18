package pkg.DAO;

import java.sql.Connection;

public class DAO {
	private Connection conexion;
	
	public Connection getConnection() {
		return this.conexion;
	}
	
	public DAO(Connection conexion) {
		this.conexion = conexion;
	}

}
