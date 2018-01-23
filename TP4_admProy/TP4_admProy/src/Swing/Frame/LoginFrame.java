package Swing.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private HandlerLogin handler;
	private PanelLogin panelLogin;
	
	
	public LoginFrame(HandlerLogin handlerLogin) {
		super("Login");
		this.handler = handlerLogin;
		initUI();
	}
	
	public void cerrarPanel() {
		
		this.dispose();

	}
	
	private void initUI(){
		panelLogin = new PanelLogin(handler);
		this.getContentPane().add(panelLogin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
}
