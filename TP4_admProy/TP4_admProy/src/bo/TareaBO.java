package bo;

import java.util.List;

import Exceptions.MyDAOExcepcion;
import dao.ProyectoDAO;
import dao.TareaDAO;
import entidades.Proyecto;
import entidades.Tarea;

public class TareaBO {

	private TareaDAO dao;

	public void altaTarea(Tarea t) throws MyDAOExcepcion {

		dao.insertTarea(t);

	}

	public void bajaTarea(Tarea t) throws MyDAOExcepcion {

		dao.deleteTareaById(t);

	}

	public void modificarProyecto(Tarea t) throws MyDAOExcepcion {

		dao.updateTarea(t);

	}

	public List<Tarea> getTareas() throws MyDAOExcepcion {
		return dao.getAllTareas();
	
	}
	
	public List<Tarea> getTareasByIdProyecto(Proyecto p) throws MyDAOExcepcion {
		
		return dao.getTareaByProyectoId(p);
	
	}
	
	

	public void setDAO(TareaDAO tareaDAO) {
		this.dao = tareaDAO;
	}

}
