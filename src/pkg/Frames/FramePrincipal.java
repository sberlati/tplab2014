package pkg.Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkg.Paneles.*;

import java.awt.Dimension;
import java.sql.*;

import pkg.Database.*;

public class FramePrincipal extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private SQLConnector conector = new SQLConnector("SERDATOS", "Quinto3", 1433);
	
	public FramePrincipal() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 367);
		setContentPane(new LoginPanel(this));
		Connection conexion = this.conector.getConnection();
		Statement consulta = conexion.createStatement();
		ResultSet respuesta = consulta.executeQuery("SELECT * FROM usuarios");
	}
}
