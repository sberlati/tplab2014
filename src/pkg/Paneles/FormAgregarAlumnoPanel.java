package pkg.Paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FormAgregarAlumnoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public FormAgregarAlumnoPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 208, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAgregarEntidadAlumno = new JLabel("Agregar entidad alumno");
		lblAgregarEntidadAlumno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAgregarEntidadAlumno = new GridBagConstraints();
		gbc_lblAgregarEntidadAlumno.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarEntidadAlumno.gridx = 0;
		gbc_lblAgregarEntidadAlumno.gridy = 1;
		add(lblAgregarEntidadAlumno, gbc_lblAgregarEntidadAlumno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNDeDni = new JLabel("N\u00BA de DNI:");
		GridBagConstraints gbc_lblNDeDni = new GridBagConstraints();
		gbc_lblNDeDni.anchor = GridBagConstraints.EAST;
		gbc_lblNDeDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDeDni.gridx = 0;
		gbc_lblNDeDni.gridy = 5;
		add(lblNDeDni, gbc_lblNDeDni);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		GridBagConstraints gbc_lblAo = new GridBagConstraints();
		gbc_lblAo.anchor = GridBagConstraints.EAST;
		gbc_lblAo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAo.gridx = 0;
		gbc_lblAo.gridy = 6;
		add(lblAo, gbc_lblAo);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		add(comboBox, gbc_comboBox);
		
		JLabel lblDivisin = new JLabel("Divisi\u00F3n: ");
		GridBagConstraints gbc_lblDivisin = new GridBagConstraints();
		gbc_lblDivisin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDivisin.anchor = GridBagConstraints.EAST;
		gbc_lblDivisin.gridx = 0;
		gbc_lblDivisin.gridy = 7;
		add(lblDivisin, gbc_lblDivisin);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 7;
		add(comboBox_1, gbc_comboBox_1);
		
		JButton btnAgregarEntidadAlumno = new JButton("Agregar entidad alumno");
		GridBagConstraints gbc_btnAgregarEntidadAlumno = new GridBagConstraints();
		gbc_btnAgregarEntidadAlumno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregarEntidadAlumno.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarEntidadAlumno.gridx = 1;
		gbc_btnAgregarEntidadAlumno.gridy = 8;
		add(btnAgregarEntidadAlumno, gbc_btnAgregarEntidadAlumno);
		System.out.println("Formulario agregar alumno abierto.");

	}
}
