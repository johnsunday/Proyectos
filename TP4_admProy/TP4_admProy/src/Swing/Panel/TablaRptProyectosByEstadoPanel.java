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
import javax.swing.JComboBox;
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
import entidades.Proyecto;
import entidades.Tarea;
import implementation.ProyectoDAOImpl;
import javafx.scene.paint.Color;

public class TablaRptProyectosByEstadoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tablaProyectos;
	private ProyectoTableModel modelo;
	private ProyectoDAOImpl pDAO = new ProyectoDAOImpl();
	private Proyecto proyecto;
	public List<Proyecto> proyectos;
	private JScrollPane scrollPaneParaTabla;
	
	private JTextField nombreProyecto = new JTextField("Nombre", 6);
	private JTextField proyectoID = new JTextField("0", 2);
	
	private JButton btnVolver = new JButton("Volver");
	private JButton btnConsultar = new JButton("Consultar");
	
	private HandlerGeneral handler;

	private String[] estadosProyecto = new String[]
			{ "Iniciado", "En proceso", "Cancelado", "Finalizado" };
	
	private JComboBox<String> estadosCombo = new JComboBox<>(estadosProyecto);

	
	public TablaRptProyectosByEstadoPanel(HandlerGeneral handler, List<Proyecto> proyectos) {
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
			
		JPanel rowBotones = new JPanel();
		
		rowBotones.add(btnConsultar);
		rowBotones.add(btnVolver);
		
		JPanel rowEstadoCombo = new JPanel();
		rowEstadoCombo.add(estadosCombo);
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.cerrarPanel();
				
			}
		});
		
		btnConsultar.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String estadoABuscar;
				estadoABuscar = estadosCombo.getSelectedItem().toString();
				handler.verProyectosByEstado(estadoABuscar);
			}
		});
		
		this.add(rowEstadoCombo);
		this.add(rowBotones);
		
	}

}
