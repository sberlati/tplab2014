package pkg.Paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import pkg.Database.SQLConnector;
import pkg.Frames.*;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPanel extends JPanel  {
	
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private FramePrincipal parent;
	
	public LoginPanel(FramePrincipal owner) {
		this.parent = owner;
		setLayout(null);
		setSize(260, 363);
		JLabel lblIniciarSesin = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesin.setBounds(47, 11, 153, 36);
		lblIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		add(lblIniciarSesin);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(20, 58, 144, 14);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNombreDeUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(20, 83, 213, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(20, 119, 113, 14);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(20, 144, 213, 20);
		add(txtPassword);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CallableStatement cblogin = owner.getConnector().getConnection().prepareCall("{call login_rowcount(?, ?, ?)}");
					cblogin.registerOutParameter(1, java.sql.Types.INTEGER);
					cblogin.setString(2, txtUsuario.getText());
					cblogin.setString(3, new String(txtPassword.getPassword()));
					cblogin.execute();
					
					if(cblogin.getInt(1) < 1) {
						
					}
					
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
			}
		});
		btnConectar.setBounds(144, 175, 89, 23);
		add(btnConectar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 261, 14);
		add(separator);
		
		/** Ir al panel de recuperación **/
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(20, 244, 221, 68);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblolvidasteInformacinPara = new JLabel("\u00BFOlvidaste informaci\u00F3n para entrar?");
		lblolvidasteInformacinPara.setBounds(10, 11, 198, 14);
		panel.add(lblolvidasteInformacinPara);
		lblolvidasteInformacinPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JButton btnClickAqu = new JButton("Click aqu\u00ED");
		btnClickAqu.setBounds(59, 36, 89, 23);
		panel.add(btnClickAqu);
		btnClickAqu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginRecoverPanel recoverpanel = new LoginRecoverPanel(owner);
				owner.setContentPane(recoverpanel);
				owner.setSize(recoverpanel.getSize());
			}
		});

	}
}
