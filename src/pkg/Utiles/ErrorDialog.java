package pkg.Utiles;

import javax.swing.JOptionPane;

public class ErrorDialog {
	public ErrorDialog(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}
