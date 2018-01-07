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

	public void modificarProyecto(Proyecto proyectoToModify) throws MyDAOExcepcion {

		boolean checkpoint = true;

		try {

			if (dao.validateProyecto(proyectoToModify))

				System.out.println("Hola");
		}

		catch (MyDAOExcepcion e) {

			checkpoint = false;
			System.out.println("Hola2");

		}

		if (checkpoint == true) {
			System.out.println("Hola3");

			dao.updateProyecto(proyectoToModify);
		}
	}

	public List<Proyecto> getProyectos() throws MyDAOExcepcion {
		return dao.getAllProyectos();
	}

	public boolean validateIfExistsProyecto(Proyecto p) throws MyDAOExcepcion {
				return dao.validateProyecto(p);
	}
	
	public boolean validateBussinessProyecto (Proyecto p) throws MyDAOExcepcion {
		
		
		
			if (Proyecto.id == null) {

				try {
					Proyecto p = new Proyecto(tema, Integer.parseInt(presupuesto));
					return p;
				}

				catch (Exception f) {

					throw new MyFormatExcepcion("El valor de uno o varios campos es incorrecto. ");
				}
			} else if (id != null){
				try {
					Proyecto p = new Proyecto(Integer.parseInt(id));
					return p;
				}

				catch (Exception f1) {

					throw new MyFormatExcepcion("El valor de uno o varios campos es incorrecto.");
				}
			}
			return null;
		}
		*/

	
}
	public void setDAO(ProyectoDAO proyectoDAO) {
		this.dao = proyectoDAO;
	}


	}
}
