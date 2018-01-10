package dao;

import java.util.List;

import Exceptions.MyDAOExcepcion;
import entidades.Empleado;

/**
 * Definimos la interface DAO, desde aca hacemos la implementacion para establecer con lenguaje SQL 
 * como vamos a impactar en la DB.
 *
 */
public interface EmpleadoDAO {

	public void insertEmpleado(Empleado e) throws MyDAOExcepcion;
	public void deleteEmpleadoById(Empleado e) throws MyDAOExcepcion;
	public void updateEmpleado(Empleado e) throws MyDAOExcepcion;
	public List<Empleado>  getAllEmpleados() throws MyDAOExcepcion;	
	public Empleado getEmpleadoById(Empleado e) throws MyDAOExcepcion;	
}

