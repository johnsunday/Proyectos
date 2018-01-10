package dao;

import java.util.List;

import Exceptions.MyDAOExcepcion;

import java.util.Collection;

import entidades.Proyecto;

/**
 * Definimos la interface DAO, desde aca hacemos la implementacion para establecer con lenguaje SQL 
 * como vamos a impactar en la DB.
 *
 */
public interface ProyectoDAO {

	public void insertProyecto(Proyecto p) throws MyDAOExcepcion;
	public void deleteProyectoById(Proyecto p) throws MyDAOExcepcion;
	public void updateProyecto(Proyecto p) throws MyDAOExcepcion;
	public Proyecto getProyectoById (Proyecto p) throws MyDAOExcepcion;
	public List<Proyecto>  getAllProyectos() throws MyDAOExcepcion;	

}

