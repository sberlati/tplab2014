package pkg.DAO;

import java.sql.*;
import java.util.ArrayList;

import pkg.Database.SQLConnector;
import pkg.Entidades.Noticia;
import pkg.Utiles.ErrorDialog;

public class NoticiaDAO {
	private SQLConnector conector = new SQLConnector();
	
	public ArrayList<Noticia> listarNoticias() {
		try {
			CallableStatement procA = this.conector.getConnection().prepareCall("{call noticias_existentes(?)}");
			procA.registerOutParameter(1, java.sql.Types.INTEGER);
			procA.execute();
			
			if(procA.getInt(1) > 0) {
				ArrayList<Noticia> noticias = new ArrayList<Noticia>();
				CallableStatement proc = this.conector.getConnection().prepareCall("{call noticia_get_noticias}");

				ResultSet resultado = proc.executeQuery();
				
				while(resultado.next()) {
					noticias.add(new Noticia(resultado.getInt(1), resultado.getString(2), resultado.getDate(3)));
				}
				
				return noticias;
			}else{
				return null;
			}
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return null;
		}
	}
	
	public boolean agregarNoticia(Noticia noticia) {
		try {
			CallableStatement proc = this.conector.getConnection().prepareCall("{call noticia_agregar(?,?)}");
			proc.setString(1, noticia.getContenido());
			proc.setDate(2, noticia.getFechaEmision());
			proc.execute();
			
			return true;
		} catch(SQLException e) {
			new ErrorDialog("Excepción SQL", e.getMessage());
			return false;
		}
	}
}
