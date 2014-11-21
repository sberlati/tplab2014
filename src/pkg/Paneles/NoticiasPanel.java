package pkg.Paneles;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import pkg.DAO.NoticiaDAO;
import pkg.Entidades.Noticia;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class NoticiasPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NoticiasPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("AKAKAKAKAKAKALSASLSKSDJFSDJKF");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		NoticiaDAO ndao = new NoticiaDAO();
		int actualY = 0;
		
		for(Noticia n : ndao.listarNoticias()) {
			actualY++;
			JLabel lblNewLabel = new JLabel(new String(valueOf(n.getFechaEmision())));
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			add(lblNewLabel_1, gbc_lblNewLabel_1);
			
		}
	}

}
