package basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createProyectoTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "CREATE TABLE proyecto ( id INTEGER IDENTITY, tema VARCHAR(100), presupuesto INT)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	
	public void createUserTable() {

		Connection c = DBManager.getInstance().connect();
			
		String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, user VARCHAR(256), email VARCHAR(256), pass VARCHAR(10))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	

	public void dropProyectoTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "DROP TABLE proyecto";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public void dropUserTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "DROP TABLE usuarios";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}


	
//// Nuevas tablas ////
	///EMPLEADOS /// 
	public void createEmpleadoTable() {

		Connection c = DBManager.getInstance().connect();
			
		String sql = "CREATE TABLE empleado (legajo INTEGER IDENTITY, nombreCompleto VARCHAR(255), sueldoHora INT)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	public void dropEmpleadoTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "DROP TABLE empleado";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}


	/// TAREAS /// 
	public void createTareaTable() {

		Connection c = DBManager.getInstance().connect();
			
		String sql = "CREATE TABLE tarea (id INTEGER IDENTITY, descripcion VARCHAR(255), proyecto INT, estado VARCHAR(20))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	public void dropEmpleadoTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "DROP TABLE tarea";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}


}
