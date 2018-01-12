package basics;

import Exceptions.MyDAOExcepcion;
import Swing.HandlerProyecto;
import dao.ProyectoDAO;
import implementation.ProyectoDAOImpl;

public class Main {

	public static void main(String[] args) {

		/**
		 * Creamos el table manager, esto no es necesario en todas las corridas, dado que solo ejecuta el create table para
		 * la tabla proyectos
		 * Creamos el handler y ejecutamos el init.
		 *
		 */

		TableManager tmproyecto = new TableManager();
		tmproyecto.createProyectoTable();

		TableManager tmtarea = new TableManager();
		tmtarea.createTareaTable();

		TableManager tmempleado= new TableManager();
		tmempleado.createEmpleadoTable();


		HandlerProyecto handler = new HandlerProyecto();
		handler.init();

	}

}
