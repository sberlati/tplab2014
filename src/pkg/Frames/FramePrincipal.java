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
	private SQLConnector conector = new SQLConnector("SERDATOS","Quinto3",1433);
	
	public SQLConnector getConnector() {
		return this.conector;
	}
	
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
	
	public FramePrincipal() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 367);
		setContentPane(new LoginPanel(this));
	}
}
