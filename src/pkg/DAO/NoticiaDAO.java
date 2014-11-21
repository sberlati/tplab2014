/*
                  |ZZzzz
                 |
                 |
    |ZZzzz      /^\            |ZZzzz			
    |          |~~~|           |
    |        |^^^^^^^|        / \
   /^\       |[]+    |       |~~~|
|^^^^^^^|    |    +[]|       |   |										Aprobame.
|    +[]|/\/\/\/\^/\/\/\/\/|^^^^^^^|
|+[]+   |~~~~~~~~~~~~~~~~~~|    +[]|
|       |  []   /^\   []   |+[]+   |
|   +[]+|  []  || ||  []   |   +[]+|
|[]+    |      || ||       |[]+    |
|_______|------------------|_______|
 
 */

package pkg.DAO;

import java.sql.*;
import java.util.ArrayList;

import pkg.Database.SQLConnector;
import pkg.Entidades.Noticia;

public class NoticiaDAO {
	SQLConnector conector = new SQLConnector();
	
	public ArrayList<Noticia> listarNoticias() {
		try {
			ArrayList<Noticia> noticias = new ArrayList<Noticia>();
			CallableStatement proc = this.conector.getConnection().prepareCall("{call noticia_get_noticias(?,?,?)}");
			proc.registerOutParameter(1, java.sql.Types.INTEGER);
			proc.registerOutParameter(2, java.sql.Types.VARCHAR);
			proc.registerOutParameter(3, java.sql.Types.DATE);
			ResultSet resultado = proc.executeQuery();
			
			while(resultado.next()) {
				noticias.add(new Noticia(resultado.getInt(1), resultado.getString(2), resultado.getDate(3)));
			}
			
			return noticias;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
			return false;
		}
	}
}
