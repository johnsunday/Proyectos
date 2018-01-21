package Swing.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import Swing.HandlerGeneral;
import Swing.HandlerLogin;
import entidades.Empleado;
import Swing.Panel.PanelLogin;

/**
 * Se define un formulario para contener todos los paneles.
 * La estructura del layout es: Form -> Jpanel -> Objetos del panel (Btns, txtBox, etc.)
 * Tambien esta definido el JmenuBar. Estructura: JMenuBAr -> JMenu->  JMenuItem
 * 
 *
 */
public class loginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private HandlerLogin handler;
	private PanelLogin panelLogin;
	
	
	public loginFrame(HandlerLogin handlerLogin) {
		super("Login");
		this.handler = new HandlerLogin();
		initUI();
	}
	
	public void cerrarPanel() {
		
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
		this.setVisible(false);

	}
	
	private void initUI(){
		panelLogin = new PanelLogin(handler);
		this.getContentPane().add(panelLogin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
	}
	
}
