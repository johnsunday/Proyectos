package bo;

import java.util.List;

import exceptions.MyDAOExcepcion;
import dao.ProyectoDAO;
import dao.TareaDAO;
import entidades.Proyecto;
import entidades.Tarea;

public class TareaBO {

	private TareaDAO dao;

	public void altaTarea(Tarea t) throws MyDAOExcepcion {
		
		if (t.getHoras()>0)

		dao.insertTarea(t);
		
		
		else
			
			
			throw new MyDAOExcepcion ("La Cantidad de Horas asignadas debe ser mayor que 0");

	}
	

	public void bajaTarea(Tarea t) throws MyDAOExcepcion {

		dao.deleteTareaById(t);

	}

	public void modificarTarea(Tarea t) throws MyDAOExcepcion {

		
		
		if (t.getHoras()>0)

			dao.updateTarea(t);
			
			else
				
				throw new MyDAOExcepcion ("La Cantidad de Horas asignadas debe ser mayor que 0");

		}
	

	public List<Tarea> getAllTareas() throws MyDAOExcepcion {
		return dao.getAllTareas();
	
	}
	
	public List<Tarea> getTareasByIdProyecto(Proyecto p) throws MyDAOExcepcion {
		
		return dao.getTareaByProyectoId(p);
	
	}
	
	

	public void setDAO(TareaDAO tareaDAO) {
		this.dao = tareaDAO;
	}

}
