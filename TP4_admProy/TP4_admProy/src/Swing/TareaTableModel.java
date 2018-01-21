package Swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Proyecto;
import entidades.Tarea;

public class TareaTableModel  extends AbstractTableModel{
	
private List<Tarea> tareas;
	
	private String[] columNames = {"ID", "Desc", "Hrs Asig.","Estado", "ID.Proyecto", "Leg.Empleado"};
	
	private static final int ID = 0;
	private static final int Descripción = 1;
	private static final int HorasAsig = 2;
	private static final int Estado = 3;
	private static final int ProyectoAsig = 4;
	private static final int EmpleadoAsig = 5;
	
	public TareaTableModel(List<Tarea> tareas) {
		this.tareas= tareas;
	}

	
	@Override
	public int getColumnCount() {
		return columNames.length;	
	}
	@Override
	public int getRowCount() {
		return tareas.size();
	}
	
	public String getColumnName(int col){
		return columNames[col]; 
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tarea t= tareas.get(rowIndex);
		switch(columnIndex){
		case ID: return t.getId();
		case Descripción: return t.getDescripcion();
		case HorasAsig : return t.getHoras();
		case Estado: return t.getEstado();
		case ProyectoAsig: return t.getProyectoid();
		case EmpleadoAsig: return t.getEmpleadoid();
		
		}
		return null;
	}


	public Tarea getTarea(int index){
		return tareas.get(index);
	}
		

}
