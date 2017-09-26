package implementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exceptions.MyDAOExcepcion;
import basics.DBManager;
import dao.ProyectoDAO;
import entidades.Proyecto;

/**
 * Implementando al interfaz DAO, definimos todos los metodos necesarios para hacer el AMBC de la entidad proyecto. 
 * 
 */
public class ProyectoDAOImpl implements ProyectoDAO {

	public void deleteProyectoById(Proyecto p) throws MyDAOExcepcion {
		String sql = "DELETE FROM proyecto WHERE id = ? ";// + p.getId()+ "'";
		Connection c = DBManager.getInstance().connect();
	
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, p.getId());
			int res = ps.executeUpdate();
			
			if (res == 0) {
				throw new MyDAOExcepcion("El proyecto que desea borrar no existe");
			}

			c.commit();
		} catch (Exception e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (Exception e1) 
			{
				throw new MyDAOExcepcion("El proyecto que desea borrar no existe");
			}
		} finally {
			try {
				c.close();
			} catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
		
		}
			
	}
	

	public List<Proyecto> getAllProyectos() throws MyDAOExcepcion {
		List<Proyecto> resultado = new ArrayList<Proyecto>();

		String sql = "SELECT * FROM proyecto";
		Connection c = DBManager.getInstance().connect();

		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
	
			
			while (rs.next()) {
				Proyecto p = new Proyecto();
				p.setId(rs.getInt("id"));
				p.setTema(rs.getString("Tema"));
				p.setPresupuesto(rs.getInt("Presupuesto"));
				resultado.add(p);
			}

		} catch (SQLException e) {
			try {
				e.printStackTrace();
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new MyDAOExcepcion("Hubo un problema en la busqueda, por favor revise.");
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return resultado;
	}

	public Proyecto getProyectoById(Proyecto p) throws MyDAOExcepcion {
		String sql = "SELECT * FROM proyecto WHERE id= " + p.getId();
		Connection c = DBManager.getInstance().connect();

		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			p.setId(rs.getInt("id"));
			p.setTema(rs.getString("Tema"));
			p.setPresupuesto(rs.getInt("Presupuesto"));
			
			if (rs.next()) {
				throw new MyDAOExcepcion("No hay valores.");
			}
	
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyDAOExcepcion("Hubo un problema en la busqueda, por favor revise.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return p;
	}


	public void insertProyecto (Proyecto p) throws MyDAOExcepcion {
		String sql = "INSERT INTO proyecto (tema, presupuesto) VALUES (?, ?)";	
		Connection c = DBManager.getInstance().connect();
		
		try {
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1, p.getTema());
			s.setInt(2, p.getPresupuesto());
			s.execute();
			c.commit();
			
		
			
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new MyDAOExcepcion("Hubo un problema en la insercion, por favor revise.");	   
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateProyecto(Proyecto p) throws MyDAOExcepcion {
		String sql = "UPDATE proyecto SET tema= '"+ p.getTema() +"'"+", "+ "presupuesto=" + p.getPresupuesto() + " WHERE id ="+ p.getId();	
		Connection c = DBManager.getInstance().connect();
		
		try {
			Statement s = c.createStatement();
			s.executeQuery(sql);
			c.commit();

		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyDAOExcepcion("Hubo un problema en la actualizacion, por favor revise.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}

}
