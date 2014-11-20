package pkg.Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLConnector {
	private String hostname	= "SERDATOS";
	private String database	= "Quinto3";
	private int    port		= 1433;
	
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
	
	public SQLConnector(/*String hostname, String database, int port*/) {
		/*this.hostname = hostname;
		this.database = database;
		this.port 	  = port;*/
	}
	
	private String getConnectionString() {
		return "jdbc:sqlserver://" + getHostname() + ":"+ getPort() +";databaseName="+ getDatabase() +";integratedSecurity=true";
	}
	
	public Connection getConnection() {
		try {
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
