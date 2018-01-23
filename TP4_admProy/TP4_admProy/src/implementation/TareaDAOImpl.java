package implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exceptions.MyDAOExcepcion;
import basics.DBManager;
import dao.TareaDAO;
import entidades.Empleado;
import entidades.Proyecto;
import entidades.Tarea;

public class TareaDAOImpl implements TareaDAO{

	public void deleteTareaById(Tarea t) throws MyDAOExcepcion {
		String sql = "DELETE FROM tarea WHERE id = ? ";// + p.getId()+ "'";
		Connection c = DBManager.getInstance().connect();

		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, t.getId());
			int res = ps.executeUpdate();

			if (res == 0) {
				throw new MyDAOExcepcion("La tarea que desea borrar no existe");
				
			}

			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				throw new MyDAOExcepcion("La tarea que desea borrar no existe");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}

	public List<Tarea> getAllTareas() throws MyDAOExcepcion {
		List<Tarea> resultado = new ArrayList<Tarea>();

		String sql = "SELECT * FROM tarea";
		Connection c = DBManager.getInstance().connect();

		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Tarea t = new Tarea();
				t.setDescripcion(rs.getString("Descripcion"));
				t.setId(rs.getInt("Id"));
				t.setHoras(rs.getInt("horas"));
				t.setEmpleadoid(rs.getInt("empleado"));
				t.setEstado(rs.getString("estado"));
				t.setProyectoid(rs.getInt("proyecto"));
				
				resultado.add(t);
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

	

	public void insertTarea(Tarea t) throws MyDAOExcepcion {
		String sql = "INSERT INTO tarea (descripcion, proyecto, horas, empleado, estado) VALUES (?, ?, ?, ?, ?)";
		
		Connection c = DBManager.getInstance().connect();

		try {
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1, t.getDescripcion());
			s.setInt(2, t.getProyectoid());
			s.setInt(3, t.getHoras());
			s.setInt(4, t.getEmpleadoid());
			s.setString(5, t.getEstado());
			
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
	public void updateTarea(Tarea t) throws MyDAOExcepcion {
		String sql = "UPDATE tarea SET descripcion=?, proyecto=?, horas=?, empleado=?, estado =? where id= ? ";
		
		Connection c = DBManager.getInstance().connect();

		try {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, t.getDescripcion());
			ps.setInt(2, t.getProyectoid());
			ps.setInt(3, t.getHoras());
			ps.setInt(4, t.getEmpleadoid());
			ps.setString(5, t.getEstado());
			ps.setInt(6, t.getId());
			ps.executeUpdate();

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


	@Override
	public Tarea getTareaByid(Tarea t) throws MyDAOExcepcion {
		String sql = "SELECT * FROM TAREA where id = " + t.getId();
		Connection c = DBManager.getInstance().connect();
		try {
			Tarea tarea = new Tarea();
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				
				t.setId(rs.getInt("id"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoras(rs.getInt("hora"));
				t.setEstado(rs.getString("estado"));
				t.setProyectoid(rs.getInt("proyecto"));
				t.setEmpleadoid(rs.getInt("empleado"));
				
				return t;
			}				
		} catch (SQLException e) {
				throw new MyDAOExcepcion("Hubo un error en la busqueda");
			}finally {
				try {c.close();}
				catch(SQLException e1){}}
		return null;
		
	}

	
	public List<Tarea> getTareaByEmpleadoId(Empleado emp) throws MyDAOExcepcion {
		List<Tarea> resultado = new ArrayList<Tarea>();
		String sql = "Select * FROM tarea WHERE empleado=" +  emp.getLegajo();
		Connection c = DBManager.getInstance().connect();
		try {
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoras(rs.getInt("hora"));
				t.setEstado(rs.getString("estado"));
				t.setProyectoid(rs.getInt("proyecto"));
				t.setEmpleadoid(rs.getInt("empleado"));
				
				resultado.add(t);
			}				
		} catch (SQLException e) {
				throw new MyDAOExcepcion("Hubo un error en la busqueda");
			}finally {
				try {c.close();}
				catch(SQLException e1){}}
		return resultado;
	}
	
	public List<Tarea> getTareaByProyectoId(Proyecto p) throws MyDAOExcepcion {
		List<Tarea> resultado = new ArrayList<Tarea>();
		String sql = "Select * FROM tarea WHERE proyecto="+  p.getId();
		Connection c = DBManager.getInstance().connect();
		try {
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoras(rs.getInt("horas"));
				t.setEstado(rs.getString("estado"));
				t.setProyectoid(rs.getInt("proyecto"));
				t.setEmpleadoid(rs.getInt("empleado"));
				
				resultado.add(t);
			}				
		} catch (SQLException e) {
				throw new MyDAOExcepcion("Hubo un error en la busqueda" + e.getMessage());
			}finally {
				try {c.close();}
				catch(SQLException e1){}}
		return resultado;
	}
	
	
	
	
	

}
