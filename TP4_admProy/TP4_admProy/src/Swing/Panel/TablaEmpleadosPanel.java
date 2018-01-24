package Swing.Panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exceptions.MyDAOExcepcion;
import Swing.HandlerGeneral;
import Swing.EmpleadoTableModel;
import entidades.Empleado;
import implementation.EmpleadoDAOImpl;
import javafx.scene.paint.Color;

public class TablaEmpleadosPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tablaEmpleados;
	private EmpleadoTableModel modelo;
	private EmpleadoDAOImpl pDAO = new EmpleadoDAOImpl();
	private Empleado Empleado;
	public List<Empleado> Empleados;
	private JScrollPane scrollPaneParaTabla;
	private JButton botonEditar;
	private JButton botonEliminar;
	private JButton botonAgregar;
	private JButton botonCancelar;
	
	private JTextField legajo = new JTextField("legjao", 6);
	private JTextField nombreCompleto = new JTextField("nombreCompleto", 2);
	private JTextField sueldoHora = new JTextField("sueldoPorHora", 3);
	
	private HandlerGeneral handler;

	
	/**
	 * Asi como se armaron los paneles para el AMB, aca armamos el panel que contendra el JTABLE. 
	 * Como todos los paneles, recibe el handler, pero ademas aca le enviamos el list de Empleados. 
	 */
	
	public TablaEmpleadosPanel(HandlerGeneral handler, List<Empleado> Empleados) {
		//super();
		this.handler = handler;
		initUI(Empleados);
		
	}

	/**
	 * Aca en donde utilizamos el list de Empleados para pasarlo al TableModel.
	 */
	private void initUI(List<Empleado> Empleados) {
		modelo = new EmpleadoTableModel(Empleados);
		
		tablaEmpleados = new JTable(modelo);
		
		scrollPaneParaTabla = new JScrollPane(tablaEmpleados);
		this.add(scrollPaneParaTabla);

		botonEditar = new JButton("Editar");
		botonCancelar = new JButton("Cancelar");
		botonEliminar = new JButton("Eliminar");
		
		
		JPanel rowBotones = new JPanel();
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));
		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonEditar);
		rowBotones.add(Box.createHorizontalStrut(10));

		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonEliminar);
		
		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonCancelar);
		
		botonEditar.setEnabled(false);
		botonEliminar.setEnabled(false);


		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				handler.cerrarPanel();
				

			}

		});
		
		tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		            boolean selected = tablaEmpleados.getSelectedRowCount() > 0;
		            botonEditar.setEnabled(selected);
		            botonEliminar.setEnabled(selected);
		   
		    }
		});
		
		
		
		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Empleado p =modelo.getEmpleado(tablaEmpleados.getSelectedRow());		
				
								
				try {
					handler.editarEmpleados(p);
				} catch (MyDAOExcepcion e) {
					// TODO Auto-generated catch block
				}
				

			}

		});		
		this.add(rowBotones);
		
		try {
			handler.mostrarEmpleados();
		} catch (MyDAOExcepcion e) {
			// TODO Auto-generated catch block
		}

		

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Empleado p =modelo.getEmpleado(tablaEmpleados.getSelectedRow());
				int seleccion = JOptionPane.showOptionDialog( null,"¿Desea eliminar el Empleado con legajo: " 
				+ p.getLegajo()+ ", Nombre completo: " + p.getNombreCompleto() + ", Sueldo por hora: " + p.getSueldoHora()+" ?"  ,
						  "Confirma Eliminacion:",JOptionPane.YES_NO_OPTION,
						   JOptionPane.QUESTION_MESSAGE,null,
						  new Object[] { "Si", "No"},null);
						      
						 if (seleccion == 0){
								handler.bajaEmpleado(p);
								handler.verEmpleados();
						 }
				

			}

		});

		
	}

}
