package Swing;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.Empleado;

/**
 * Armamos un table model. Es la plantilla desde la cual se ingresara un Jtable en el panel. 
 * Dentro de este modelo, estan los metodos necesarios para llenar y conocer los valores del JTable. 
 *
 */

public class EmpleadoTableModel extends AbstractTableModel{
	
	private List<Empleado> Empleados;
	
	private String[] columNames = {"legajo", "sueldoHora", "nombreCompleto"};
	
	private static final int LEGAJO= 0;
	private static final int SUELDOHORA = 1;
	private static final int NOMBRECOMPLETO = 2;
	
	
	
	public EmpleadoTableModel(List<Empleado> Empleados) {
		this.Empleados= Empleados;
	}


	/**
	 * Esta es la funcion que se utiliza para obtner los datos del objeto seleccionado en el
	 * JTable. 
	 * Se le pasa el index que es el resultado del metodo getSelectedRow.
	 */
	public Empleado getEmpleado(int index){
		return Empleados.get(index);
	}
	
	
	@Override
	public int getColumnCount() {
		return columNames.length;
	}

	@Override
	public int getRowCount() {
		return Empleados.size();
	}
	
	public String getColumnName(int col){
		return columNames[col]; 
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Empleado p= Empleados.get(rowIndex);
		switch(columnIndex){
		case LEGAJO: return p.getLegajo();
		case SUELDOHORA: return p.getSueldoHora();
		case NOMBRECOMPLETO : return p.getNombreCompleto();
		}
		return null;
	}

	
}

