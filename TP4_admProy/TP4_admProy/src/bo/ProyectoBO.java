package bo;

import java.util.List;

import Exceptions.MyDAOExcepcion;
import dao.ProyectoDAO;
import entidades.Proyecto;
import implementation.ProyectoDAOImpl;

/**
 * Se crean el business object, es el encargado de tener la logica de negocio.
 * Desde el BO, se contacta con el DAO.
 *
 */

public class ProyectoBO {

	private ProyectoDAO dao;

	public void altaProyecto(Proyecto p) throws MyDAOExcepcion {
		dao.insertProyecto(p);
	}
	
	public void bajaProyecto(Proyecto p) throws MyDAOExcepcion {
			dao.deleteProyectoById(p);	
	}
	
	public void modificarProyecto(Proyecto p)throws MyDAOExcepcion{
		dao.updateProyecto(p);
	}

	public List<Proyecto> getProyectos() throws MyDAOExcepcion{
		return dao.getAllProyectos();
	}

	public Proyecto getProyectoPorId(Proyecto p) throws MyDAOExcepcion{
		return dao.getProyectoById(p);
	}
	
	public void setDAO(ProyectoDAO proyectoDAO) {
		this.dao = proyectoDAO;
	}
	
}
