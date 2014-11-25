package pkg.Paneles;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import pkg.DAO.NoticiaDAO;
import pkg.Entidades.Noticia;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextPane;

public class NoticiasPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private NoticiaDAO ndao = new NoticiaDAO();
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public NoticiasPanel() {
		this.setBackground(new Color(176, 196, 222));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	
		cargarNoticias();
	}
	
	private void cargarNoticias() {
		int actualY = 0;
		if(ndao.listarNoticias() == null)
		{
			System.out.println("La consulta no devolvió resultados. No hay noticias para mostrar. (NoticiasPanel.java)");
		}else{
			for(Noticia n : ndao.listarNoticias()) {
				actualY++;
				
				//Label con la fecha de emisión
				JLabel labelFecha = new JLabel(df.format(n.getFechaEmision()));
				labelFecha.setFont(new Font("Calibri", Font.PLAIN, 14));
				GridBagConstraints gbc_labelFecha = new GridBagConstraints();
				gbc_labelFecha.insets = new Insets(0, 0, 5, 0);
				gbc_labelFecha.gridx = 1;
				gbc_labelFecha.gridy = actualY;
				add(labelFecha, gbc_labelFecha);
				
				//Label con el contenido de la noticia
				actualY++;
				JLabel labelContenido = new JLabel(n.getContenido());
				labelContenido.setFont(new Font("Calibri", Font.PLAIN, 14));
				GridBagConstraints gbc_labelContenido = new GridBagConstraints();
				gbc_labelContenido.insets = new Insets(0, 0, 5, 0);
				gbc_labelContenido.gridx = 1;
				gbc_labelContenido.gridy = actualY;
				
			}
		}
	}

}
