package Swing;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import Exceptions.MyDAOExcepcion;
import Exceptions.MyFormatExcepcion;
import Swing.Frame.MiFrame;
import Swing.Panel.PanelAltaEmpleado;
import Swing.Panel.PanelBajaEmpleado;
import Swing.Panel.PanelModificarEmpleado;
import Swing.Panel.TablaEmpleadoPanel;
import bo.EmpleadoBO;
import dao.EmpleadoDAO;
import entidades.Empleado;
import implementation.EmpleadoDAOImpl;

public class HandlerEmpleado {

	private EmpleadoBO EmpleadoBO;
	private MiFrame frame;

	/**
	 * Se define el handler de empleado. Es el encargado de tener el codigo a
	 * ejecutar para cada uno de los action Listener. Es decir, cada accion del
	 * usuario, esta relacionada a uno o mas metodos del handler.
	 */
	
	public HandlerEmpleado() {
		EmpleadoBO = new EmpleadoBO();
		EmpleadoBO.setDAO(new EmpleadoDAOImpl());
	}

	public void mostrarAltaEmpleado() {
		frame.cambiarPanel(new PanelAltaEmpleado(this));
	}

	public void mostrarBajaEmpleado() {
		frame.cambiarPanel(new PanelBajaEmpleado(this));
	}

	public void verEmpleados() {
		try {
			frame.cambiarPanel(new TablaEmpleadoPanel(this, EmpleadoBO.getEmpleado()));
		} catch (MyDAOExcepcion e) {
			mostrarError(e.getMessage());
		}
	}

	public void altaEmpleado(Empleado p)  {

		try {
			EmpleadoBO.altaEmpleado(p);
			mostrarExito("Empleado agregado con exito.");
		} catch (MyDAOExcepcion e) {
			// TODO Auto-generated catch block
			mostrarError(e.getMessage());
		}

	}

	public void bajaEmpleado(Empleado p)  {
		
		try {
			EmpleadoBO.bajaEmpleado(p);
		mostrarExito("Empleado borrado con exito.");
		} catch (MyDAOExcepcion e){
			mostrarError(e.getMessage());
		}
	}

	public void mostrarEmpleados() throws MyDAOExcepcion {
		EmpleadoBO.getEmpleado();
	}

	public void editarEmpleados(Empleado p) throws MyDAOExcepcion {

		frame.cambiarPanel(new PanelModificarEmpleado(this, p));

	}

	public void modificarEmpleado(Empleado p) throws MyDAOExcepcion {
		EmpleadoBO.modificarEmpleado(p);
	}

	public void mostrarError(String m) {
		JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.ERROR_MESSAGE);

	}

	public void mostrarExito(String mensaje) {

		JOptionPane.showMessageDialog(null, mensaje);
		
	}

	public void init() {
		frame = new MiFrame(this);
		frame.setVisible(true);
	}

	public void cerrarPanel() {
		frame.cerrarPanel();
	}

}
