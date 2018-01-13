package Swing.Panel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Swing.HandlerGeneral;
import Swing.HandlerEmpleado;

import javafx.scene.control.ComboBox;

public abstract class PanelPadre extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HandlerGeneral handler;
	public HandlerEmpleado handlerEmpleado;
	
	
	public boolean validarNumero(String numbers, String campo) {
		boolean isNumber = false;
		try {
			Integer.parseInt(numbers);
			isNumber= true;
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ERROR al ingresar el "+campo.toUpperCase(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return isNumber;
	}
	
	
	public boolean validarFloat(String numbers, String campo) {
		boolean isFloat = false;
		try {
			Float.parseFloat(numbers);
			isFloat= true;
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ERROR al ingresar el "+campo.toUpperCase(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return isFloat;
	}
	
	public boolean validarCampo(JTextField campo){
		return campo.getText().isEmpty();
		
		
		
		
	
	}
	
}