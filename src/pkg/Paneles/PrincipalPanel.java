package pkg.Paneles;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
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

import pkg.Entidades.Usuario;
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

import java.awt.SystemColor;
import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;

public class PrincipalPanel extends JPanel {
	private JTable table;

	public PrincipalPanel(FramePrincipal owner, Usuario usuario) {
		setLayout(null);
		setSize(800,600);
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
		
		JLabel lblTultimaFecha = new JLabel("Tu \u00FAltima fecha de acceso fue el " + usuario.getUltimoAcceso() + ".");
		lblTultimaFecha.setBounds(10, 53, 352, 14);
		panel.add(lblTultimaFecha);
		
		JLabel label = new JLabel("13:24 - 27/10/2014");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(376, 11, 252, 14);
		panel.add(label);
		
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
		
		JButton btnRefrescar = new JButton("Actualizar");
		btnRefrescar.setBounds(325, 20, 91, 23);
		panel_5.add(btnRefrescar);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(176, 196, 222));
		panel_13.setBounds(10, 61, 406, 304);
		panel_5.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		
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
		panel_6.add(comboBox_1);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(403, 7, 91, 23);
		panel_6.add(btnCargar);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setBounds(10, 111, 755, 276);
		panel_2.add(table);
		
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
		
		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);
		
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
