package Swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import exceptions.MyDAOExcepcion;
import exceptions.MyFormatExcepcion;
import Swing.Frame.LoginFrame;
import Swing.Frame.MiFrame;
import Swing.HandlerGeneral;

public class HandlerLogin {

	private MiFrame miFrame;

	public LoginFrame frame;

	public HandlerLogin() {

	}

	public void init() {
		frame = new LoginFrame(this);
		frame.setVisible(true);
	}

	public void cerrarPanelLogin() {
		frame.dispose();
		HandlerGeneral handler = new HandlerGeneral();
		handler.init();
	}
}