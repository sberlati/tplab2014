package pkg.Paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
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
import java.awt.Dimension;

public class PrincipalPanel extends JPanel {

	public PrincipalPanel() {
		setSize(800,600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 780, 92);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(176, 196, 222));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenidoaAnnimo = new JLabel("Bienvenido/a, An\u00F3nimo");
		lblBienvenidoaAnnimo.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblBienvenidoaAnnimo.setBounds(10, 11, 267, 42);
		panel.add(lblBienvenidoaAnnimo);
		
		JLabel lblTultimaFecha = new JLabel("Tu \u00FAltima fecha de acceso fue el 27/10/2014.");
		lblTultimaFecha.setBounds(10, 53, 248, 14);
		panel.add(lblTultimaFecha);
		
		JLabel label = new JLabel("13:24 - 27/10/2014");
		label.setBounds(527, 11, 101, 14);
		panel.add(label);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		btnCerrarSesin.setSelectedIcon(null);
		btnCerrarSesin.setBounds(662, 7, 108, 23);
		panel.add(btnCerrarSesin);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 127, 780, 462);
		add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
	}
}
