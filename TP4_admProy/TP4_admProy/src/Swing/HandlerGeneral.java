package Swing;

import javax.swing.JOptionPane;
import java.util.List;
import exceptions.MyDAOExcepcion;
import Swing.Frame.MiFrame;
//imports de proyecto 
import Swing.Panel.PanelAltaProyecto;
import Swing.Panel.PanelAltaTarea;
import Swing.Panel.PanelBajaProyecto;
import Swing.Panel.PanelBajaTarea;
import Swing.Panel.PanelModificarProyecto;
import Swing.Panel.PanelModificarTarea;
import Swing.Panel.TablaProyectosPanel;
import Swing.Panel.TablaRptProyectosByEstadoPanel;
import Swing.Panel.TablaTareasPanel;
import bo.ProyectoBO;
import entidades.Proyecto;
import entidades.Tarea;
import implementation.ProyectoDAOImpl;
import implementation.TareaDAOImpl;
//imports de Empleado
import Swing.Panel.PanelAltaEmpleado;
import Swing.Panel.PanelBajaEmpleado;
import Swing.Panel.PanelModificarEmpleado;
import Swing.Panel.TablaEmpleadosPanel;
import bo.EmpleadoBO;
import bo.TareaBO;
import entidades.Empleado;
import implementation.EmpleadoDAOImpl;

public class HandlerGeneral {
	// PROYECTO VARS.
	private ProyectoBO proyectoBO;

	// EMPLEADO VARS.
	private EmpleadoBO empleadoBO;

	// TAREA VARS.

	private TareaBO tareaBO;

	// LOGIN.

	private MiFrame frame;

	/**
	 * Se define el handler de proyectos. Es el encargado de tener el codigo a
	 * ejecutar para cada uno de los action Listener. Es decir, cada accion del
	 * usuario, esta relacionada a uno o mas metodos del handler.
	 */
	public HandlerGeneral() {
		proyectoBO = new ProyectoBO();
		proyectoBO.setDAO(new ProyectoDAOImpl());
		empleadoBO = new EmpleadoBO();
		empleadoBO.setDAO(new EmpleadoDAOImpl());
		tareaBO = new TareaBO();
		tareaBO.setDAO(new TareaDAOImpl());

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

	public void altaProyecto(Proyecto p) {

		try {
			proyectoBO.altaProyecto(p);
			mostrarExito("Proyecto agregado con exito.");
		} catch (MyDAOExcepcion e) {
			// TODO Auto-generated catch block
			mostrarError(e.getMessage());
		}

	}

	public void bajaProyecto(Proyecto p) {

		try {
			proyectoBO.bajaProyecto(p);
			mostrarExito("Proyecto borrado con exito.");
		} catch (MyDAOExcepcion e) {
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

	public List<Tarea> getTareasByIdProyecto(Proyecto p) throws MyDAOExcepcion {

		return tareaBO.getTareasByIdProyecto(p);

	}

	public List<Proyecto> getAllProyectoByEstado(String estado) throws MyDAOExcepcion {

		List<Proyecto> proyectos = proyectoBO.getAllProyectoByEstado(estado);
		return proyectos;

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
			frame.cambiarPanel(new TablaEmpleadosPanel(this, empleadoBO.getEmpleados()));
		} catch (MyDAOExcepcion e) {
			mostrarError(e.getMessage());
		}
	}

	public void altaEmpleado(Empleado p) {

		try {
			empleadoBO.altaEmpleado(p);
			mostrarExito("Empleado agregado con exito.");
		} catch (MyDAOExcepcion e) {
			// TODO Auto-generated catch block
			mostrarError(e.getMessage());
		}

	}

	public void bajaEmpleado(Empleado p) {
		try {
			empleadoBO.bajaEmpleado(p);
			mostrarExito("Empleado borrado con exito.");
		} catch (MyDAOExcepcion e) {
			mostrarError(e.getMessage());
		}
	}

	public void mostrarEmpleados() throws MyDAOExcepcion {
		empleadoBO.getEmpleados();
	}

	public void editarEmpleados(Empleado p) throws MyDAOExcepcion {

		frame.cambiarPanel(new PanelModificarEmpleado(this, p));

	}

	public void modificarEmpleado(Empleado p) throws MyDAOExcepcion {
		empleadoBO.modificarEmpleado(p);
	}

	public void altaTarea(Tarea t) throws MyDAOExcepcion {

		tareaBO.altaTarea(t);

	}

	public void mostrarAltaTarea() {
		frame.cambiarPanel(new PanelAltaTarea(this));
	}

	public void mostrarBajaTarea() {
		frame.cambiarPanel(new PanelBajaTarea(this));
	}

	public List<Empleado> getAllEmpleados() throws MyDAOExcepcion {
		return empleadoBO.getEmpleados();

	}

	public void bajaTarea(Tarea t) throws MyDAOExcepcion {

		tareaBO.bajaTarea(t);

	}

	public void editarTarea(Tarea t) throws MyDAOExcepcion {
		
		frame.cambiarPanel(new PanelModificarTarea(this, t));

	}

	public List<Tarea> getTareabyId(Tarea t) {
		return null;
	}

	public void verTareas() {
		try {
			frame.cambiarPanel(new TablaTareasPanel(this, tareaBO.getAllTareas()));
		} catch (MyDAOExcepcion e) {
			mostrarError(e.getMessage());
		}
	}

	public void mostrarTareas() throws MyDAOExcepcion {

		tareaBO.getAllTareas();

	}
	
	public void modificarTarea(Tarea t) throws MyDAOExcepcion {
		tareaBO.modificarTarea(t);
	}
	

	public void verProyectosByEstado(String estado) {
		try {
			frame.cambiarPanel(new TablaRptProyectosByEstadoPanel(this, proyectoBO.getAllProyectoByEstado(estado)));
		} catch (MyDAOExcepcion e) {
			mostrarError(e.getMessage());
		}
	}

}
