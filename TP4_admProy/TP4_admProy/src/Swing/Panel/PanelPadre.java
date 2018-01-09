import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Swing.HandlerProyecto;

public abstract class PanelPadre extends JPanel {
	
	public HandlerProyecto handler;
	public JButton aceptarBT;
	public JButton volverBT;
	public JTextField codigoTF;
	public JTextField pasilloTF;
	public JTextField estanteTF;
	public JTextField marcaTF;
	public JTextField stockTF;
	public JTextField descripcionTF;
	public JCheckBox esOriginalCB;
	public JTextField userTF;
	public JTextField passTF;
	public JTextField emailTF;
	public JTextField fechaTF;
	public JButton limpiarBT;
	
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
	
	public void createTextfieldRow(String label, JTextField textfield, Box vertical) {
		JLabel campo1 = new JLabel(label);
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(textfield);
		vertical.add(horizontal);
	}
	
	public void createCheckBoxRow(String label, JCheckBox cb, Box vertical) {
		JLabel campo1 = new JLabel(label);
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(cb);
		vertical.add(horizontal);
	}
	
	public void createButtonsRow(Box vertical, JButton boton) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(horizontal.createHorizontalGlue());
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(boton);
		vertical.add(horizontal);
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
	
	abstract public void limpiarCampos();
	
}