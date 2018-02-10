package Swing.Panel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Swing.HandlerGeneral;


public abstract class PanelPadre extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public HandlerGeneral handler;
	
	public boolean validarNumero(String numbers, String campo) {
		boolean isNumber = false;
		try {
			Integer.parseInt(numbers);
			isNumber= true;
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El campo  "+campo + " no es un numerico entero.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return isNumber;
	}
	
	
	
	
	
	public boolean validarCampo(JTextField campo){
		return campo.getText().isEmpty();
		
	}
	
}