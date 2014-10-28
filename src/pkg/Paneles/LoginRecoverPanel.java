package pkg.Paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import pkg.Frames.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginRecoverPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	public LoginRecoverPanel(FramePrincipal owner) {
		setLayout(null);
		setSize(431, 245);

		JLabel lblRecuperarInformacin = new JLabel("Recuperar informaci\u00F3n");
		lblRecuperarInformacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecuperarInformacin.setBounds(10, 10, 200, 50);
		add(lblRecuperarInformacin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 410, 5);
		add(separator);
		
		JLabel lblIngresaTu = new JLabel("1. Ingresa tu nombre y apellido");
		lblIngresaTu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngresaTu.setBounds(10, 71, 246, 38);
		add(lblIngresaTu);
		
		textField = new JTextField();
		textField.setBounds(76, 115, 150, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 106, 68, 38);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 138, 68, 38);
		add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 146, 150, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(332, 175, 89, 23);
		add(btnNewButton);
		
		/** Volver al login **/
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPanel lp = new LoginPanel(owner);
				owner.setContentPane(lp);
				owner.setSize(lp.getSize());
			}
		});
		btnSalir.setBounds(10, 175, 89, 23);
		add(btnSalir);

	}
}
