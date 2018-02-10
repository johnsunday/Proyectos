package Swing;

import Swing.Frame.LoginFrame;
import Swing.HandlerGeneral;

public class HandlerLogin {


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