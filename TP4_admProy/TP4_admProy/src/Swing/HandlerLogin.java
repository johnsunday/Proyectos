package Swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import Exceptions.MyDAOExcepcion;
import Exceptions.MyFormatExcepcion;
import Swing.Frame.loginFrame;
import Swing.Frame.MiFrame;
import Swing.HandlerGeneral;

public class HandlerLogin {

	private MiFrame miFrame;

	public loginFrame frame;

	public HandlerLogin() {

	}

	public void init() {
		frame = new loginFrame(this);
		frame.setVisible(true);
	}

	public void cerrarPanelLogin() {
		frame.cerrarPanel();
		
		HandlerGeneral handler = new HandlerGeneral();
		handler.init();
	}
}