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

		if (p.getPresupuesto() > 0) {
			// AGREGAR VALIDACION DE NEGOCIO
			dao.insertProyecto(p);
		} else {

			throw new MyDAOExcepcion("El presupuesto del proyecto debe ser mayor a 0");
		}

	}

	public void bajaProyecto(Proyecto p) throws MyDAOExcepcion {

		Proyecto proyectoCompleto = dao.getProyectoById(p);

		if (proyectoCompleto != null && "Iniciado".equals(proyectoCompleto.getEstado()))

			dao.deleteProyectoById(p);

		else

			throw new MyDAOExcepcion("El Proyecto no existe o tiene un estado invalido");

	}

	public void modificarProyecto(Proyecto proyectoToModify) throws MyDAOExcepcion {

		if (proyectoToModify.getPresupuesto() > 0) {

			dao.updateProyecto(proyectoToModify);

		} else {

			throw new MyDAOExcepcion("El presupuesto del proyecto debe ser mayor a 0");
		}

	}

	public List<Proyecto> getProyectos() throws MyDAOExcepcion {
		return dao.getAllProyectos();
	}

	public void setDAO(ProyectoDAO proyectoDAO) {
		this.dao = proyectoDAO;
	}

}
