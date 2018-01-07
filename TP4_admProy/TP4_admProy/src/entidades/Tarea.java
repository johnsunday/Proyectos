package entidades;

public class Tarea {
	
	
	private int id;
	private String descripcion;
	private int horas;

	

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", horas=" + horas + "]";
	}

	public Tarea(int id, String descripcion, int horas) {
		this.id = id;
		this.descripcion = descripcion;
		this.horas = horas;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
}