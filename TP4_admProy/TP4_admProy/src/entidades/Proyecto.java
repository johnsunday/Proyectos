package entidades;

import javax.print.DocFlavor.CHAR_ARRAY;

/**
 * Definimos el objeto proyecto con sus getters y setters, toString y const.
 *
 */

public class Proyecto {

	private int id;  
	private String tema;
	private int presupuesto;
	private String estado;
	
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Proyecto(String tema, int presupuesto) {
		super();
		this.tema = tema;
		this.presupuesto = presupuesto;
	}
	
	
	public Proyecto(int id) {
		this.id = id;
		}
	
	
	public Proyecto() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}
