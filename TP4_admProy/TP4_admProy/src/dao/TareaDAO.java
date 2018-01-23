package dao;

import java.util.List;

import exceptions.MyDAOExcepcion;

import java.util.Collection;

import entidades.Tarea;
import entidades.Empleado;
import entidades.Proyecto;

/**
 * Definimos la interface DAO, desde aca hacemos la implementacion para establecer con lenguaje SQL 
 * como vamos a impactar en la DB.
 *
 */
public interface TareaDAO {

	public void insertTarea(Tarea t) throws MyDAOExcepcion;
	public void deleteTareaById(Tarea t) throws MyDAOExcepcion;
	public void updateTarea(Tarea t) throws MyDAOExcepcion;
	public List<Tarea> getAllTareas() throws MyDAOExcepcion;	
	public Tarea getTareaByid (Tarea t) throws MyDAOExcepcion;
	public List<Tarea> getTareaByEmpleadoId(Empleado e) throws MyDAOExcepcion;
	public List<Tarea> getTareaByProyectoId(Proyecto p) throws MyDAOExcepcion;
}

