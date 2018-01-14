package Swing;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.Proyecto;

/**
 * Armamos un table model. Es la plantilla desde la cual se ingresara un Jtable en el panel. 
 * Dentro de este modelo, estan los metodos necesarios para llenar y conocer los valores del JTable. 
 *
 */

public class ProyectoTableModel extends AbstractTableModel{
	
	private List<Proyecto> proyectos;
	
	private String[] columNames = {"ID", "Tema", "Presupuesto","Estado"};
	
	private static final int ID = 0;
	private static final int TEMA = 1;
	private static final int PRESUPUESTO = 2;
	private static final int ESTADO = 3;
			
	
	public ProyectoTableModel(List<Proyecto> proyectos) {
		this.proyectos= proyectos;
	}


	/**
	 * Esta es la funcion que se utiliza para obtner los datos del objeto seleccionado en el
	 * JTable. 
	 * Se le pasa el index que es el resultado del metodo getSelectedRow.
	 */
	public Proyecto getProyecto(int index){
		return proyectos.get(index);
	}
	
	
	@Override
	public int getColumnCount() {
		return columNames.length;
	}

	@Override
	public int getRowCount() {
		return proyectos.size();
	}
	
	public String getColumnName(int col){
		return columNames[col]; 
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Proyecto p= proyectos.get(rowIndex);
		switch(columnIndex){
		case ID: return p.getId();
		case TEMA: return p.getTema();
		case PRESUPUESTO : return p.getPresupuesto();
		case ESTADO: return p.getEstado();
		}
		return null;
	}
	
	
	
	
	
}

