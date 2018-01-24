package Swing.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Swing.HandlerGeneral;
import entidades.Empleado;
import entidades.Proyecto;
import entidades.Tarea;
import exceptions.MyDAOExcepcion;

public class PanelModificarTarea extends PanelPadre {

	private Tarea t;
	private String[] estadosTarea = new String[] { "Iniciada", "En proceso", "Cancelada", "Finalizada" };

	private JComboBox<String> tareaCombo = new JComboBox<>(estadosTarea);
	private JComboBox<Integer> proyectosCombo = new JComboBox<>();
	private JComboBox<Integer> empleadosCombo = new JComboBox<>();

	public PanelModificarTarea(HandlerGeneral handler, Tarea t) {
		this.handler = handler;
		this.t = t;
		initUI();
	}

	private void initUI() {

		JButton botonAceptar = new JButton("Aceptar");
		JButton botonCancelar = new JButton("Cancelar");
		JLabel lblTitulo = new JLabel("Modificacion de Tareas");
		JLabel lblDescripcion = new JLabel("Descripcion :");
		JLabel lblHoras = new JLabel("Horas Asignadas:");
		JLabel lblEstado = new JLabel("Estado: ");
		JTextField txtDescripcion = new JTextField("");
		JTextField txtHoras = new JTextField("");
		JLabel lblProyectoAsig = new JLabel("Proyecto Asig: ");
		JLabel lblEmpleadoAsig = new JLabel("Empleado Asig: ");

		txtDescripcion.setMaximumSize(new Dimension(450, 30));
		txtHoras.setMaximumSize(new Dimension(450, 30));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel rowTitulo = new JPanel();
		JPanel rowDescripcion = new JPanel();
		JPanel rowHoras = new JPanel();
		JPanel rowEstado = new JPanel();
		JPanel rowProyectoId = new JPanel();
		JPanel rowEmpleadoId = new JPanel();
		
		JPanel rowBotones = new JPanel();

		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowDescripcion.setLayout(new BoxLayout(rowDescripcion, BoxLayout.X_AXIS));
		rowHoras.setLayout(new BoxLayout(rowHoras, BoxLayout.X_AXIS));
		rowEstado.setLayout(new BoxLayout(rowEstado, BoxLayout.X_AXIS));
		rowProyectoId.setLayout(new BoxLayout(rowProyectoId, BoxLayout.X_AXIS));
		rowEmpleadoId.setLayout(new BoxLayout(rowEmpleadoId, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));

		rowTitulo.add(Box.createHorizontalStrut(10));
		rowDescripcion.add(Box.createHorizontalStrut(10));
		rowHoras.add(Box.createHorizontalStrut(10));
		rowEstado.add(Box.createHorizontalStrut(10));
		rowProyectoId.add(Box.createHorizontalStrut(10));
		rowEmpleadoId.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));
		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		rowDescripcion.add(lblDescripcion);
		rowHoras.add(lblHoras);
		rowEstado.add(lblEstado);
		rowProyectoId.add(lblProyectoAsig);
		rowEmpleadoId.add(lblEmpleadoAsig);
		rowBotones.add(botonAceptar);

		rowDescripcion.add(Box.createHorizontalStrut(10));
		rowHoras.add(Box.createHorizontalStrut(10));
		rowEstado.add(Box.createHorizontalStrut(10));
		rowProyectoId.add(Box.createHorizontalStrut(10));
		rowEmpleadoId.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		try {

			List<Proyecto> proyectosExistentes = handler.getAllProyectoByEstado("Iniciado");

			for (int i = 0; i < proyectosExistentes.size(); i++)

			{
				proyectosCombo.addItem(new Integer(proyectosExistentes.get(i).getId()));

			}

		} catch (MyDAOExcepcion e)

		{
			handler.mostrarError(e.getMessage());

		}

		try {

			List<Empleado> empleadosExistentes = handler.getAllEmpleados();

			for (int j = 0; j < empleadosExistentes.size(); j++)

			{
				empleadosCombo.addItem(new Integer(empleadosExistentes.get(j).getLegajo()));

			}
			

			

		} catch (MyDAOExcepcion e)

		{
			handler.mostrarError(e.getMessage());

		}
		rowDescripcion.add(txtDescripcion);
		rowHoras.add(txtHoras);
		rowEstado.add(tareaCombo);
		rowProyectoId.add(proyectosCombo);
		rowEmpleadoId.add(empleadosCombo);
		rowBotones.add(botonCancelar);

		rowDescripcion.add(Box.createHorizontalStrut(10));
		rowHoras.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		rowEstado.add(Box.createHorizontalStrut(10));

		// SETEO
		txtDescripcion.setText(t.getDescripcion());

		txtHoras.setText(String.valueOf(t.getHoras()));
		tareaCombo.setSelectedItem(t.getEstado());

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (validarCampo(txtDescripcion) || validarCampo(txtHoras))

					handler.mostrarError("Por favor complete todos los campos.");
				else {

					Tarea tareaToModify =new Tarea(txtDescripcion.getText(), 
							Integer.parseInt(txtHoras.getText()),
							tareaCombo.getSelectedItem().toString()
							,
							Integer.parseInt(proyectosCombo.getSelectedItem().toString()),
							Integer.parseInt(empleadosCombo.getSelectedItem().toString()));
					tareaToModify.setId(t.getId());

					try {
						handler.mostrarExito(tareaToModify.getEstado());
						handler.modificarTarea(tareaToModify);
						handler.mostrarExito("La Tarea " + t.getDescripcion() + " fue modificada.");
						handler.verTareas();
					} catch (MyDAOExcepcion e) {
						handler.mostrarError(e.getMessage());
					}
				}

			}

		});

		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				handler.cerrarPanel();

			}

		});

		this.add(rowTitulo);
		this.add(rowDescripcion);
		this.add(rowHoras);
		this.add(rowEstado);
		this.add(rowProyectoId);
		this.add(rowEmpleadoId);
		this.add(rowBotones);

	}

}
