package Swing.Panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exceptions.MyDAOExcepcion;
import Swing.HandlerGeneral;
import Swing.ProyectoTableModel;
import entidades.Empleado;
import entidades.Proyecto;
import entidades.Tarea;
import implementation.ProyectoDAOImpl;
import javafx.scene.paint.Color;

public class TablaProyectosPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tablaProyectos;
	private ProyectoTableModel modelo;
	private ProyectoDAOImpl pDAO = new ProyectoDAOImpl();
	private Proyecto proyecto;
	public List<Proyecto> proyectos;
	private JScrollPane scrollPaneParaTabla;
	private JButton botonEditar;
	private JButton botonEliminar;
	private JButton botonVerTarea;
	private JButton botonAgregar;
	private JButton botonCancelar;
	private JTextField nombreProyecto = new JTextField("Nombre", 6);
	private JTextField proyectoID = new JTextField("0", 2);
	private HandlerGeneral handler;
	
	private JList<String> listaTareas = new JList<String>() ;
	private JList<Integer> listaEmpleados = new JList<Integer>() ;

	
	
	
	/**
	 * Asi como se armaron los paneles para el AMB, aca armamos el panel que contendra el JTABLE. 
	 * Como todos los paneles, recibe el handler, pero ademas aca le enviamos el list de proyectos. 
	 */
	
	public TablaProyectosPanel(HandlerGeneral handler, List<Proyecto> proyectos) {
		//super();
		this.handler = handler;
		initUI(proyectos);
		
	}

	/**
	 * Aca en donde utilizamos el list de proyectos para pasarlo al TableModel.
	 */
	private void initUI(List<Proyecto> proyectos) {
		modelo = new ProyectoTableModel(proyectos);
		
		tablaProyectos = new JTable(modelo);
		
		scrollPaneParaTabla = new JScrollPane(tablaProyectos);
		this.add(scrollPaneParaTabla);
		JPanel rowListBox =new JPanel ();

		botonEditar = new JButton("Modificar.");
		botonVerTarea = new JButton("Ver Asignaciones");
		botonCancelar = new JButton("Cancelar");
		botonEliminar = new JButton("Eliminar");
		JLabel lblListBox = new JLabel ("Tareas Asignadas:");
		JLabel lblListBoxE = new JLabel ("Legajos Asignados:");
	  
	    
	    
		
		
		JPanel rowBotones = new JPanel();
		rowListBox.setLayout(new BoxLayout(rowListBox, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));
		rowBotones.add(Box.createHorizontalStrut(50));
		rowListBox.add(Box.createHorizontalStrut(10));
	
		rowBotones.add(botonEditar);
		rowListBox.add(lblListBox);
		rowListBox.add(Box.createHorizontalStrut(10));
		rowListBox.add(listaTareas);
		rowBotones.add(Box.createHorizontalStrut(10));

		rowListBox.add(Box.createHorizontalStrut(10));
		rowListBox.add(lblListBoxE);
		rowBotones.add(botonVerTarea);
		
		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonCancelar);
		
		rowListBox.add(Box.createHorizontalStrut(10));
		rowListBox.add(listaEmpleados);
		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonEliminar);
		

		DefaultListModel<String> modeloLista = new DefaultListModel();
		DefaultListModel<Integer> modeloListaE = new DefaultListModel();
		
		botonEditar.setEnabled(false);
		botonEliminar.setEnabled(false);
		botonVerTarea.setEnabled(false);
		

		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				handler.cerrarPanel();
				

			}

		});
		
		tablaProyectos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		            boolean selected = tablaProyectos.getSelectedRowCount() > 0;
		            botonEditar.setEnabled(selected);
		            botonEliminar.setEnabled(selected);
		        	botonVerTarea.setEnabled(selected);
		            modeloLista.clear();
		            modeloListaE.clear();
		            
		   
		    }

		
		});
		
		
    	
		
		botonVerTarea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Proyecto p =modelo.getProyecto(tablaProyectos.getSelectedRow());		
				
								
				try {
					List<Tarea> tareasProyecto =handler.getTareasByIdProyecto(p);
					
					
					
					for (int i =0 ; i<tareasProyecto.size() ; i++)
						
					{
						
						modeloLista.addElement(tareasProyecto.get(i).getDescripcion());
						modeloListaE.addElement(tareasProyecto.get(i).getEmpleadoid());
				
						
						
					}
					
				} catch (MyDAOExcepcion e) {
					
					handler.mostrarError(e.getMessage());
					
				}
				

			}

		});		
		
		
		listaTareas.setModel(modeloLista);
		listaEmpleados.setModel(modeloListaE);
		this.add(rowBotones);
		this.add(rowListBox);
		
		
		try {
			handler.mostrarProyectos();
		} catch (MyDAOExcepcion e) {
			handler.mostrarError(e.getMessage());
		}

		

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Proyecto p =modelo.getProyecto(tablaProyectos.getSelectedRow());
				int seleccion = JOptionPane.showOptionDialog( null,"¿Desea eliminar el Proyecto ID: " 
				+ p.getId() + ", Tema: " + p.getTema() + ", Presupuesto: " + p.getPresupuesto() +  ", Estado: " + p.getEstado() + " ?"  ,
						  "Confirma Eliminacion:",JOptionPane.YES_NO_OPTION,
						   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
						  new Object[] { "Si", "No"},null);
						      
						 if (seleccion == 0){
								handler.bajaProyecto(p);
								handler.verProyectos();
						 }
				

			}

		});

	

	
	botonEditar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Proyecto p =modelo.getProyecto(tablaProyectos.getSelectedRow());		
			
							
			try {
				handler.editarProyectos(p);
			} catch (MyDAOExcepcion e) {
				// TODO Agregar Algo
			}
			

		}

	});		
	
}
}
