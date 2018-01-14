package Swing;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import Exceptions.MyDAOExcepcion;
import Exceptions.MyFormatExcepcion;
import Swing.Frame.MiFrame;

//imports de proyecto 
import Swing.Panel.PanelAltaProyecto;
import Swing.Panel.PanelBajaProyecto;
import Swing.Panel.PanelModificarProyecto;
import Swing.Panel.TablaProyectosPanel;
import bo.ProyectoBO;
import dao.ProyectoDAO;
import entidades.Proyecto;
import implementation.ProyectoDAOImpl;

//imports de Empleado
import Swing.Panel.PanelAltaEmpleado;
import Swing.Panel.PanelBajaEmpleado;
import Swing.Panel.PanelModificarEmpleado;
import Swing.Panel.TablaEmpleadosPanel;
import bo.EmpleadoBO;
import dao.EmpleadoDAO;
import entidades.Empleado;
import implementation.EmpleadoDAOImpl;




public class HandlerGeneral {
	// PROYECTO VARS.
	private ProyectoBO proyectoBO;

	// EMPLEADO VARS.
	private EmpleadoBO EmpleadoBO;

	
	private MiFrame frame;
	
	/**
	 * Se define el handler de proyectos. Es el encargado de tener el codigo a
	 * ejecutar para cada uno de los action Listener. Es decir, cada accion del
	 * usuario, esta relacionada a uno o mas metodos del handler.
	 */
	public HandlerGeneral() {
		proyectoBO = new ProyectoBO();
		proyectoBO.setDAO(new ProyectoDAOImpl());
		EmpleadoBO = new EmpleadoBO();
		EmpleadoBO.setDAO(new EmpleadoDAOImpl());

	}

	public void mostrarAltaProyecto() {
		frame.cambiarPanel(new PanelAltaProyecto(this));
	}

	public void mostrarBajaProyecto() {
		frame.cambiarPanel(new PanelBajaProyecto(this));
	}

	public void verProyectos() {
		try {
			frame.cambiarPanel(new TablaProyectosPanel(this, proyectoBO.getProyectos()));
		} catch (MyDAOExcepcion e) {
			mostrarError(e.getMessage());
		}
	}

	public void altaProyecto(Proyecto p)  {

		try {
			proyectoBO.altaProyecto(p);
			mostrarExito("Proyecto agregado con exito.");
		} catch (MyDAOExcepcion e) {
			// TODO Auto-generated catch block
			mostrarError(e.getMessage());
		}

	}

	public void bajaProyecto(Proyecto p)  {
		
		try {
		proyectoBO.bajaProyecto(p);
		mostrarExito("Proyecto borrado con exito.");
		} catch (MyDAOExcepcion e){
			mostrarError(e.getMessage());
		}
		
	}

	public void mostrarProyectos() throws MyDAOExcepcion {
		proyectoBO.getProyectos();
	}

	public void editarProyectos(Proyecto p) throws MyDAOExcepcion {

		frame.cambiarPanel(new PanelModificarProyecto(this, p));

	}

	public void modificarProyecto(Proyecto p) throws MyDAOExcepcion {
		proyectoBO.modificarProyecto(p);
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
	

// ADD HANDLER DE EMPLEADO // 

	public void mostrarAltaEmpleado() {
		frame.cambiarPanel(new PanelAltaEmpleado(this));
	}

	public void mostrarBajaEmpleado() {
		frame.cambiarPanel(new PanelBajaEmpleado(this));
	}

	public void verEmpleados() {
		try {
			frame.cambiarPanel(new TablaEmpleadosPanel(this, EmpleadoBO.getEmpleados()));
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
		EmpleadoBO.getEmpleados();
	}

	public void editarEmpleados(Empleado p) throws MyDAOExcepcion {

		frame.cambiarPanel(new PanelModificarEmpleado(this, p));

	}

	public void modificarEmpleado(Empleado p) throws MyDAOExcepcion {
		EmpleadoBO.modificarEmpleado(p);
	}




}
