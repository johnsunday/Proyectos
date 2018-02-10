package bo;

import java.util.List;


import exceptions.MyDAOExcepcion;
import dao.EmpleadoDAO;
import entidades.Empleado;


public class EmpleadoBO {


	private EmpleadoDAO dao;

	
	
	public void altaEmpleado(Empleado empleadoAlta) throws MyDAOExcepcion {
		
		if (empleadoAlta.getSueldoHora() > 0) {
			dao.insertEmpleado(empleadoAlta);
		}
		else {
			
			throw new MyDAOExcepcion("El costo por hora del empleado debe ser mayor a 0");
		}
		
	}

	public void bajaEmpleado(Empleado empleadoBaja) throws MyDAOExcepcion {
		
	
		Empleado empleadoCompleto = dao.getEmpleadoById(empleadoBaja);
		if (empleadoCompleto !=null)
		dao.deleteEmpleadoById(empleadoBaja);
		else
			throw new MyDAOExcepcion("El Empleado no existe o tiene tareas asignadas.");
	}

	
	public void modificarEmpleado(Empleado empleadoToModify) throws MyDAOExcepcion {
			if (empleadoToModify.getSueldoHora() > 0) {
				dao.updateEmpleado(empleadoToModify);
			}
			else {
				
				throw new MyDAOExcepcion("El costo por hora del empleado debe ser mayor a 0");
			}
			
	}

	public List<Empleado> getEmpleados() throws MyDAOExcepcion {
		return dao.getAllEmpleados();
	}

	

	public void setDAO(EmpleadoDAO empleadoDAO) {
		this.dao = empleadoDAO;
	}

	
}
