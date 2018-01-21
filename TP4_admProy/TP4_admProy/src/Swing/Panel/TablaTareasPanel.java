package Swing.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Exceptions.MyDAOExcepcion;
import Swing.EmpleadoTableModel;
import Swing.HandlerGeneral;
import Swing.ProyectoTableModel;
import Swing.TareaTableModel;
import entidades.Empleado;
import entidades.Proyecto;
import entidades.Tarea;
import implementation.EmpleadoDAOImpl;
import implementation.TareaDAOImpl;

public class TablaTareasPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tablaTareas;
	private TareaTableModel modelo;
	private JScrollPane scrollPaneParaTabla;
	private TareaDAOImpl pDAO = new TareaDAOImpl();
	private Empleado Empleado;
	private HandlerGeneral handler;

	public TablaTareasPanel(HandlerGeneral handler, List<Tarea> tareas) {
		this.handler = handler;
		initUI(tareas);
	}

	private void initUI(List<Tarea> tareas) {
		modelo = new TareaTableModel(tareas);

		tablaTareas = new JTable(modelo);

		scrollPaneParaTabla = new JScrollPane(tablaTareas);
		this.add(scrollPaneParaTabla);

		JButton botonEditar = new JButton("Modificar.");
		JButton botonCancelar = new JButton("Cancelar");
		JButton botonEliminar = new JButton("Eliminar");

		DefaultListModel modeloLista = new DefaultListModel();
		JList listaTareas = new JList(modeloLista);

		JScrollPane scrollPaneParaLista = new JScrollPane(listaTareas);

		this.add(scrollPaneParaLista);

		JPanel rowBotones = new JPanel();
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));
		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonEditar);
		rowBotones.add(Box.createHorizontalStrut(10));

		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonEliminar);

		rowBotones.add(Box.createHorizontalStrut(10));
		rowBotones.add(botonCancelar);

		rowBotones.add(Box.createHorizontalStrut(10));

		botonEditar.setEnabled(false);
		botonEliminar.setEnabled(false);

		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				handler.cerrarPanel();

			}

		});

		tablaTareas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				boolean selected = tablaTareas.getSelectedRowCount() > 0;
				botonEditar.setEnabled(selected);
				botonEliminar.setEnabled(selected);

				Tarea t = modelo.getTarea(tablaTareas.getSelectedRow());

				List<Tarea> tareas = handler.getTareabyId(t);

				DefaultListModel<Tarea> tareasmodel = new DefaultListModel<Tarea>();

				for (int i = 0; i < tareas.size(); i++)

				{

					tareasmodel.addElement(tareas.get(i));
				}

				listaTareas.setModel(tareasmodel);

			}
		});

		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Tarea t = modelo.getTarea(tablaTareas.getSelectedRow());

				handler.editarTarea(t);

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

				Tarea t = modelo.getTarea(tablaTareas.getSelectedRow());
				int seleccion = JOptionPane.showOptionDialog(null,
						"¿Desea eliminar la Tarea ID: " + t.getId() ,
						"Confirma Eliminacion:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null
																												// para
																												// icono
																												// por
																												// defecto.
						new Object[] { "Si", "No" }, null);

				if (seleccion == 0) {
					try {
						handler.bajaTarea(t);
					} catch (MyDAOExcepcion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// handler.mostrarExito("El proyecto " +p.getTema() +" ha sido eliminado.");
					handler.verProyectos();
				}

			}

		});

	}

}
