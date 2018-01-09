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

import Exceptions.MyDAOExcepcion;
import Swing.HandlerProyecto;
import Swing.ProyectoTableModel;
import entidades.Proyecto;
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
	private JButton botonAgregar;
	private JButton botonCancelar;
	private JTextField nombreProyecto = new JTextField("Nombre", 6);
	private JTextField proyectoID = new JTextField("0", 2);
	private HandlerProyecto handler;

	
	/**
	 * Asi como se armaron los paneles para el AMB, aca armamos el panel que contendra el JTABLE. 
	 * Como todos los paneles, recibe el handler, pero ademas aca le enviamos el list de proyectos. 
	 */
	
	public TablaProyectosPanel(HandlerProyecto handler, List<Proyecto> proyectos) {
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
		
		tablaProyectos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		            boolean selected = tablaProyectos.getSelectedRowCount() > 0;
		            botonEditar.setEnabled(selected);
		            botonEliminar.setEnabled(selected);
		   
		    }
		});
		
		
		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Proyecto p =modelo.getProyecto(tablaProyectos.getSelectedRow());		
				
								
				try {
					handler.editarProyectos(p);
				} catch (MyDAOExcepcion e) {
					// TODO Auto-generated catch block
				}
				

			}

		});		
		this.add(rowBotones);
		
		try {
			handler.mostrarProyectos();
		} catch (MyDAOExcepcion e) {
			// TODO Auto-generated catch block
		}

		

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Proyecto p =modelo.getProyecto(tablaProyectos.getSelectedRow());
				try {
					
					int seleccion = JOptionPane.showOptionDialog( null,"¿Desea eliminar el Proyecto ID: " 
					+ p.getId() + ", Tema: " + p.getTema() + ", Presupuesto: " + p.getPresupuesto()+" ?"  ,
							  "Confirma Eliminacion:",JOptionPane.YES_NO_OPTION,
							   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
							  new Object[] { "Si", "No"},null);
							      
							 if (seleccion == 0){
									handler.bajaProyecto(p);
									handler.mostrarExito("El proyecto " +p.getTema() +" ha sido eliminado.");
									handler.verProyectos();
							 }

				} catch (MyDAOExcepcion e) {
					handler.mostrarError(e.getMessage());
				}
				

			}

		});

		
	}

}
