package pkg.Paneles;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.ScrollPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Component;

import javax.swing.Box;

import pkg.DAO.CursoDAO;
import pkg.Entidades.Curso;
import pkg.Entidades.Preceptor;
import pkg.Frames.FramePrincipal;

import java.awt.Dimension;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class PrincipalPanel extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public PrincipalPanel(FramePrincipal owner, Preceptor usuario) {
		setLayout(null);
		setSize(800,588);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 780, 92);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(176, 196, 222));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenidoaAnnimo = new JLabel("Bienvenido/a, " + usuario.getNombre());
		lblBienvenidoaAnnimo.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblBienvenidoaAnnimo.setBounds(10, 11, 267, 42);
		panel.add(lblBienvenidoaAnnimo);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPanel lp = new LoginPanel(owner);
				owner.setContentPane(lp);
				owner.setSize(lp.getSize());
			}
		});
		btnCerrarSesin.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		btnCerrarSesin.setSelectedIcon(null);
		btnCerrarSesin.setBounds(638, 7, 132, 42);
		panel.add(btnCerrarSesin);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 127, 780, 427);
		add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("P\u00E1g. Principal", new ImageIcon(PrincipalPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(10, 11, 319, 202);
		panel_3.setBackground(new Color(176, 196, 222));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTomarLista = new JLabel("Tomar lista");
		lblTomarLista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTomarLista.setBounds(10, 11, 299, 45);
		panel_3.add(lblTomarLista);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 299, 17);
		panel_3.add(separator);
		
		JLabel lblLosCursosQue = new JLabel("Selecciona un curso para tomar lista:");
		lblLosCursosQue.setBounds(10, 67, 299, 17);
		panel_3.add(lblLosCursosQue);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 96, 299, 22);
		panel_3.add(comboBox);
		
		JButton btnTomarLista = new JButton("Tomar lista");
		btnTomarLista.setBounds(183, 129, 126, 23);
		panel_3.add(btnTomarLista);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(10, 224, 319, 163);
		panel_4.setBackground(new Color(176, 196, 222));
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.setBackground(new Color(176, 196, 222));
		panel_5.setBounds(339, 11, 426, 376);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNotasDelDa = new JLabel("Noticias");
		lblNotasDelDa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNotasDelDa.setBounds(10, 11, 305, 45);
		panel_5.add(lblNotasDelDa);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 54, 406, 17);
		panel_5.add(separator_1);
				
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(176, 196, 222));
		panel_13.setBounds(10, 61, 406, 304);
		panel_5.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		panel_13.add(new NoticiasPanel());
		
		JButton btnRefrescar = new JButton("Actualizar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_13.add(new NoticiasPanel());
			}
		});
		btnRefrescar.setBounds(325, 20, 91, 23);
		panel_5.add(btnRefrescar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Control de ausencias", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.setBackground(new Color(176, 196, 222));
		panel_6.setBounds(10, 11, 755, 45);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblSeleccionaUnCurso = new JLabel("Selecciona un curso:");
		lblSeleccionaUnCurso.setBounds(10, 11, 127, 14);
		panel_6.add(lblSeleccionaUnCurso);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(135, 7, 256, 22);
		CursoDAO cdao = new CursoDAO();
		
		for(Curso c : cdao.obtenerCursos()) {
			comboBox_1.addItem(c.getAsCadena());
		}
		panel_6.add(comboBox_1);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(403, 7, 91, 23);
		panel_6.add(btnCargar);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setBounds(10, 111, 755, 276);
		DefaultTableModel dtm = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "Faltas"}, 0);
		table.setModel(dtm);
		panel_2.add(table);
		
		//Carga el JTable
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(176, 196, 222));
		panel_7.setToolTipText("");
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(10, 79, 755, 33);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 755, 33);
		panel_7.add(menuBar);
		
		JMenu mnTurnos = new JMenu("Turnos");
		menuBar.add(mnTurnos);
		
		JMenuItem mntmTeora = new JMenuItem("Teor\u00EDa");
		mnTurnos.add(mntmTeora);
		
		JMenuItem mntmTaller = new JMenuItem("Taller");
		mnTurnos.add(mntmTaller);
		
		JMenu mnFiltros = new JMenu("Filtros");
		menuBar.add(mnFiltros);
		
		JMenu mnNewMenu = new JMenu("Ordenar por ...");
		mnFiltros.add(mnNewMenu);
		
		JMenuItem mntmApellidoaz = new JMenuItem("Apellido (A-Z)");
		mnNewMenu.add(mntmApellidoaz);
		
		JMenuItem mntmMayorCantidadDe = new JMenuItem("Mayor cantidad de faltas");
		mnNewMenu.add(mntmMayorCantidadDe);
		
		JMenuItem mntmMenorCantidadDe = new JMenuItem("Menor cantidad de faltas");
		mnNewMenu.add(mntmMenorCantidadDe);
		
		JDateChooser dateChooser = new JDateChooser();
		menuBar.add(dateChooser);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		tabbedPane.addTab("Control de preceptores", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_9.setBackground(new Color(176, 196, 222));
		panel_9.setBounds(10, 11, 347, 105);
		panel_8.add(panel_9);
		
		JLabel lblSeleccionaUnPreceptor = new JLabel("Selecciona un preceptor:");
		lblSeleccionaUnPreceptor.setBounds(10, 11, 321, 14);
		panel_9.add(lblSeleccionaUnPreceptor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 36, 321, 22);
		panel_9.add(comboBox_2);
		
		JButton btnCargar_1 = new JButton("Mostrar");
		btnCargar_1.setBounds(240, 69, 91, 23);
		panel_9.add(btnCargar_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_10.setBackground(new Color(176, 196, 222));
		panel_10.setBounds(367, 11, 398, 105);
		panel_8.add(panel_10);
		
		JLabel lblAcciones = new JLabel("Acciones");
		lblAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAcciones.setBounds(10, 11, 378, 39);
		panel_10.add(lblAcciones);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setEnabled(false);
		btnDarDeBaja.setBounds(10, 48, 102, 23);
		panel_10.add(btnDarDeBaja);
		
		JButton btnSuspender = new JButton("Suspender");
		btnSuspender.setEnabled(false);
		btnSuspender.setBounds(114, 48, 102, 23);
		panel_10.add(btnSuspender);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_11.setBackground(new Color(176, 196, 222));
		panel_11.setBounds(10, 127, 347, 260);
		panel_8.add(panel_11);
		
		JLabel lblBambiDaniel = new JLabel("Bambi, Daniel");
		lblBambiDaniel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBambiDaniel.setBounds(10, 11, 378, 39);
		panel_11.add(lblBambiDaniel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 54, 111, 14);
		panel_11.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(10, 71, 111, 14);
		panel_11.add(lblApellido);
		
		JLabel lblNivelDeAcceso = new JLabel("Nivel de acceso:");
		lblNivelDeAcceso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivelDeAcceso.setBounds(10, 106, 111, 14);
		panel_11.add(lblNivelDeAcceso);
		
		JLabel lblDireccinDeEmail = new JLabel("Direcci\u00F3n de e-mail:");
		lblDireccinDeEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccinDeEmail.setBounds(10, 131, 111, 14);
		panel_11.add(lblDireccinDeEmail);
		
		JLabel lblltimoAcceso = new JLabel("\u00DAltimo acceso:");
		lblltimoAcceso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblltimoAcceso.setBounds(10, 165, 111, 14);
		panel_11.add(lblltimoAcceso);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_12.setBackground(new Color(176, 196, 222));
		panel_12.setBounds(367, 127, 398, 260);
		panel_8.add(panel_12);
		
		JLabel lblModificar = new JLabel("Modificar");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModificar.setBounds(10, 11, 378, 39);
		panel_12.add(lblModificar);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		tabbedPane.addTab("Agregar alumno", null, panel_14, null);
		panel_14.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_16.setBackground(new Color(176, 196, 222));
		panel_16.setBounds(10, 11, 755, 175);
		panel_14.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel lblAgregarAlumnoAl = new JLabel("Agregar alumno al sistema");
		lblAgregarAlumnoAl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarAlumnoAl.setBounds(10, 11, 246, 36);
		panel_16.add(lblAgregarAlumnoAl);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(10, 62, 46, 14);
		panel_16.add(lblNombre_1);
		
		textField = new JTextField();
		textField.setBounds(54, 59, 161, 20);
		panel_16.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellido_1 = new JLabel("Apellido:");
		lblApellido_1.setBounds(236, 62, 56, 14);
		panel_16.add(lblApellido_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 59, 146, 20);
		panel_16.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00BA de DNI: ");
		lblN.setBounds(10, 87, 87, 14);
		panel_16.add(lblN);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 84, 151, 20);
		panel_16.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAgregarAlumno = new JButton("Agregar alumno");
		btnAgregarAlumno.setBounds(236, 116, 195, 23);
		panel_16.add(btnAgregarAlumno);
		
		JLabel lblAoYDivisin = new JLabel("A\u00F1o y divisi\u00F3n:");
		lblAoYDivisin.setBounds(225, 87, 80, 14);
		panel_16.add(lblAoYDivisin);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(309, 84, 122, 20);
		panel_16.add(comboBox_4);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		tabbedPane.addTab("Agregar preceptor/usuario", null, panel_15, null);
		panel_15.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_17.setBackground(new Color(176, 196, 222));
		panel_17.setBounds(10, 11, 448, 222);
		panel_15.add(panel_17);
		
		JLabel lblAgregarPreceptorusuarioAl = new JLabel("Agregar preceptor/usuario al sistema");
		lblAgregarPreceptorusuarioAl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgregarPreceptorusuarioAl.setBounds(10, 11, 377, 36);
		panel_17.add(lblAgregarPreceptorusuarioAl);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(10, 62, 46, 14);
		panel_17.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 58, 161, 20);
		panel_17.add(textField_3);
		
		JLabel label_3 = new JLabel("Apellido:");
		label_3.setBounds(236, 62, 56, 14);
		panel_17.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(285, 59, 146, 20);
		panel_17.add(textField_4);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(85, 90, 118, 113);
		panel_17.add(list);
		
		JButton button = new JButton(">>");
		button.setBounds(212, 107, 77, 23);
		panel_17.add(button);
		
		JButton button_1 = new JButton("<<");
		button_1.setBounds(213, 166, 77, 23);
		panel_17.add(button_1);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setBounds(313, 91, 118, 113);
		panel_17.add(list_1);
		
		JLabel lblCursosnA = new JLabel("<html>Cursos <br> a cargo:</html>");
		lblCursosnA.setHorizontalAlignment(SwingConstants.LEFT);
		lblCursosnA.setBounds(10, 92, 64, 81);
		panel_17.add(lblCursosnA);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_18.setBackground(new Color(176, 196, 222));
		panel_18.setBounds(10, 244, 448, 140);
		panel_15.add(panel_18);
		
		JLabel lblDatosParaGenerar = new JLabel("Datos para generar usuario");
		lblDatosParaGenerar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosParaGenerar.setBounds(10, 11, 377, 36);
		panel_18.add(lblDatosParaGenerar);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setBounds(10, 48, 134, 14);
		panel_18.add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(10, 73, 134, 14);
		panel_18.add(lblContrasea);
		
		JLabel lblDireccinDeEmail_1 = new JLabel("Direcci\u00F3n de e-mail:");
		lblDireccinDeEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccinDeEmail_1.setBounds(10, 98, 134, 14);
		panel_18.add(lblDireccinDeEmail_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(154, 45, 284, 20);
		panel_18.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(154, 70, 284, 20);
		panel_18.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(154, 95, 284, 20);
		panel_18.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_19.setBackground(new Color(176, 196, 222));
		panel_19.setBounds(468, 11, 297, 222);
		panel_15.add(panel_19);
		
		JLabel lblNivelDeAcceso_1 = new JLabel("Nivel de acceso");
		lblNivelDeAcceso_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNivelDeAcceso_1.setBounds(10, 11, 377, 36);
		panel_19.add(lblNivelDeAcceso_1);
		
		JLabel lblNivel = new JLabel("<html>\r\nNivel 1: <br>\r\nControl de ausencias, agregar alumnos.<br><br>\r\nNivel 2: <br>\r\nControl de ausencias, control de alumnos, control de preceptores.<br>\r\n</html>");
		lblNivel.setBounds(10, 47, 277, 87);
		panel_19.add(lblNivel);
		
		JLabel lblSeleccionaUnNivel = new JLabel("Selecciona un nivel:");
		lblSeleccionaUnNivel.setBounds(10, 194, 131, 14);
		panel_19.add(lblSeleccionaUnNivel);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(151, 191, 93, 20);
		panel_19.add(comboBox_3);
		
		JPanel panel_20 = new JPanel();
		panel_20.setLayout(null);
		panel_20.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_20.setBackground(new Color(176, 196, 222));
		panel_20.setBounds(468, 244, 297, 140);
		panel_15.add(panel_20);
		
		JLabel lblTodoListo = new JLabel("Todo listo...");
		lblTodoListo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTodoListo.setBounds(10, 11, 377, 36);
		panel_20.add(lblTodoListo);
		
		JButton btnAgregarAlSistema = new JButton("Agregar al sistema");
		btnAgregarAlSistema.setBounds(10, 106, 277, 23);
		panel_20.add(btnAgregarAlSistema);
	
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
}
