package pkg.Paneles;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;

public class FormAgregarPreceptorPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public FormAgregarPreceptorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{187, 398, 33, 0};
		gridBagLayout.rowHeights = new int[]{30, 20, 14, 20, 20, 148, 0, 0, 0, 0, 64, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAgregarEntidadPreceptor = new JLabel("Agregar entidad preceptor");
		lblAgregarEntidadPreceptor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAgregarEntidadPreceptor = new GridBagConstraints();
		gbc_lblAgregarEntidadPreceptor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAgregarEntidadPreceptor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarEntidadPreceptor.gridwidth = 2;
		gbc_lblAgregarEntidadPreceptor.gridx = 0;
		gbc_lblAgregarEntidadPreceptor.gridy = 1;
		add(lblAgregarEntidadPreceptor, gbc_lblAgregarEntidadPreceptor);
		
		JLabel lblInformacinDelPreceptor = new JLabel("Informaci\u00F3n del preceptor");
		lblInformacinDelPreceptor.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblInformacinDelPreceptor = new GridBagConstraints();
		gbc_lblInformacinDelPreceptor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacinDelPreceptor.gridx = 1;
		gbc_lblInformacinDelPreceptor.gridy = 2;
		add(lblInformacinDelPreceptor, gbc_lblInformacinDelPreceptor);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 4;
		add(lblApellido, gbc_lblApellido);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCursosACargo = new JLabel("Cursos a cargo:");
		GridBagConstraints gbc_lblCursosACargo = new GridBagConstraints();
		gbc_lblCursosACargo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblCursosACargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursosACargo.gridx = 0;
		gbc_lblCursosACargo.gridy = 5;
		add(lblCursosACargo, gbc_lblCursosACargo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(120,120);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(60, 11, 118, 113);
		panel.add(list);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBounds(187, 28, 77, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("<<");
		button.setBounds(188, 87, 77, 23);
		panel.add(button);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setBounds(288, 12, 118, 113);
		panel.add(list_1);
		
		JLabel lblInformacinComoUsuario = new JLabel("Informaci\u00F3n como usuario");
		lblInformacinComoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblInformacinComoUsuario = new GridBagConstraints();
		gbc_lblInformacinComoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformacinComoUsuario.gridx = 1;
		gbc_lblInformacinComoUsuario.gridy = 6;
		add(lblInformacinComoUsuario, gbc_lblInformacinComoUsuario);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
		gbc_lblNombreDeUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeUsuario.gridx = 0;
		gbc_lblNombreDeUsuario.gridy = 7;
		add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 7;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 8;
		add(lblContrasea, gbc_lblContrasea);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 8;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDireccinDeCorreo = new JLabel("Direcci\u00F3n de correo electr\u00F3nico:");
		GridBagConstraints gbc_lblDireccinDeCorreo = new GridBagConstraints();
		gbc_lblDireccinDeCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblDireccinDeCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccinDeCorreo.gridx = 0;
		gbc_lblDireccinDeCorreo.gridy = 9;
		add(lblDireccinDeCorreo, gbc_lblDireccinDeCorreo);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 9;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNivelDeAcceso = new JLabel("Nivel de acceso:");
		GridBagConstraints gbc_lblNivelDeAcceso = new GridBagConstraints();
		gbc_lblNivelDeAcceso.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelDeAcceso.gridx = 0;
		gbc_lblNivelDeAcceso.gridy = 10;
		add(lblNivelDeAcceso, gbc_lblNivelDeAcceso);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 10;
		add(panel_1, gbc_panel_1);
		
		JCheckBox chckbxTomarListaAdministrar = new JCheckBox("Tomar lista, administrar alumnos");
		panel_1.add(chckbxTomarListaAdministrar);
		
		JCheckBox chckbxAdministrarPreceptoresCursos = new JCheckBox("Administrar preceptores, cursos y a\u00F1os (SUPERUSER)");
		panel_1.add(chckbxAdministrarPreceptoresCursos);
		
		JButton btnAgregarEntidadPreceptor = new JButton("Agregar entidad preceptor");
		GridBagConstraints gbc_btnAgregarEntidadPreceptor = new GridBagConstraints();
		gbc_btnAgregarEntidadPreceptor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregarEntidadPreceptor.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarEntidadPreceptor.gridx = 1;
		gbc_btnAgregarEntidadPreceptor.gridy = 11;
		add(btnAgregarEntidadPreceptor, gbc_btnAgregarEntidadPreceptor);
		System.out.println("Formulario agregar preceptor abierto.");
	}
}
