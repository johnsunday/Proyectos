package bo;

import java.util.List;


import Exceptions.MyDAOExcepcion;
import dao.EmpleadoDAO;
import entidades.Empleado;
import entidades.Tarea;
import implementation.EmpleadoDAOImpl;
import implementation.TareaDAOImpl;


public class EmpleadoBO {


	private EmpleadoDAO dao;
	private TareaDAOImpl daoTarea;

	
	public void altaEmpleado(Empleado p) throws MyDAOExcepcion {
		
		if (p.getSueldoHora() > 0) {
			//AGREGAR VALIDACION DE NEGOCIO
			dao.insertEmpleado(p);
		}
		else {
			
			throw new MyDAOExcepcion("El costo por hora del empleado debe ser mayor a 0");
		}
		
	}

	public void bajaEmpleado(Empleado p) throws MyDAOExcepcion {
		
	
		Empleado EmpleadoCompleto = dao.getEmpleadoById(p);
		//List<Tarea> tareasDeEmpleado = daoTarea.getTareaByEmpleadoId(EmpleadoCompleto);
		
		
		if (EmpleadoCompleto !=null)// && tareasDeEmpleado != null)
		dao.deleteEmpleadoById(p);
		else
			throw new MyDAOExcepcion("El Empleado no existe o tiene tareas asignadas.");
	}

	
	public void modificarEmpleado(Empleado EmpleadoToModify) throws MyDAOExcepcion {
			if (EmpleadoToModify.getSueldoHora() > 0) {
				//AGREGAR VALIDACION DE NEGOCIO
				dao.updateEmpleado(EmpleadoToModify);
			}
			else {
				
				throw new MyDAOExcepcion("El costo por hora del empleado debe ser mayor a 0");
			}
			
	}

	public List<Empleado> getEmpleados() throws MyDAOExcepcion {
		return dao.getAllEmpleados();
	}

	

	public void setDAO(EmpleadoDAO EmpleadoDAO) {
		this.dao = EmpleadoDAO;
	}

	
}
