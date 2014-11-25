package pkg.Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLConnector {
	private String hostname	= "SEBA-PC";
	private String database	= "asistencias";
	private int    port		= 1433;
	private boolean integratedSecurity = false;
	private Connection conexion;
	
	private String getHostname() {
		return this.hostname;
	}
	
	private String getDatabase() {
		return this.database;
	}
	
	private int getPort() {
		return this.port;
	}
	
	private boolean getIntegratedSecurity() {
		return this.integratedSecurity;
	}
	
	private String getConnectionString() { 
		return "jdbc:sqlserver://" + getHostname() + ":" + getPort() + ";databaseName=" + getDatabase() + ";integratedSecurity=" + getIntegratedSecurity();
	}
	
	public Connection getConnection() {
		try {
			if(!getIntegratedSecurity())
				this.conexion = DriverManager.getConnection(this.getConnectionString(),"Admin", "pelotas");
			else
				this.conexion = DriverManager.getConnection(this.getConnectionString());
			
			if(this.conexion != null)
				System.out.println("Conexión con la base de datos establecida.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al conectar a la base de datos. Traza: " + e.getMessage());
		}
	
		
		return this.conexion;
	}
}
