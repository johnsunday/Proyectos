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
 * Implementando al interfaz DAO, definimos todos los metodos necesarios para
 * hacer el AMBC de la entidad proyecto.
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
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				throw new MyDAOExcepcion("El proyecto que desea borrar no existe");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
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
				p.setEstado(rs.getString("Estado"));
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

	public void insertProyecto(Proyecto p) throws MyDAOExcepcion {
		String sql = "INSERT INTO proyecto (tema, presupuesto, estado) VALUES (?, ?, ?)";
		Connection c = DBManager.getInstance().connect();

		try {
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1, p.getTema());
			s.setInt(2, p.getPresupuesto());
			s.setString(3, p.getEstado());
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
		String sql = "UPDATE PROYECTO SET tema = ? , presupuesto = ? , estado = ? where id=?";
		Connection c = DBManager.getInstance().connect();

		try {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, p.getTema());
			ps.setInt(2, p.getPresupuesto());
			ps.setString(3, p.getEstado());
			ps.setInt(4, p.getId());
			ps.execute();
			c.commit();

		} catch (SQLException e) {
			try {
				e.printStackTrace();
				c.rollback();
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

	public Proyecto getProyectoById(Proyecto p) throws MyDAOExcepcion {
		String sql = "SELECT * FROM PROYECTO where id = " + p.getId();
		Connection c = DBManager.getInstance().connect();
		try {
			Proyecto proyecto = new Proyecto();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {

				proyecto.setId(rs.getInt("id"));
				proyecto.setTema(rs.getString("tema"));
				proyecto.setEstado(rs.getString("estado"));

				return proyecto;
			}
		} catch (SQLException e) {
			throw new MyDAOExcepcion("Hubo un error en la busqueda");
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return null;
	}

	public List<Proyecto> getAllProyectosByEstado(String estado) throws MyDAOExcepcion {
		List<Proyecto> resultado = new ArrayList<Proyecto>();

		String sql = "SELECT * FROM proyecto where estado = '" + estado + "'";
		Connection c = DBManager.getInstance().connect();

		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Proyecto p = new Proyecto();
				p.setId(rs.getInt("id"));
				p.setTema(rs.getString("Tema"));
				p.setPresupuesto(rs.getInt("Presupuesto"));
				p.setEstado(rs.getString("Estado"));
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

}