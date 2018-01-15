package Swing.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Swing.HandlerGeneral;
import entidades.Empleado;
import entidades.Tarea;

public class PanelAltaTarea extends PanelPadre {

	private static final long serialVersionUID = 1L;

	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel lblTitulo;
	private JLabel lblDescripcion;
	private JLabel lblAsignadoHoras;
	private JLabel lblProyectoAsig;
	private JLabel lblEmpleadoAsig;
	private JTextField txtDescripcion;
	private JTextField txtAsignadoHoras;
	private JTextField txtProyectoAsig;
	private JTextField txtEmpleadoAsig;

	private HandlerGeneral handler;

	public PanelAltaTarea(HandlerGeneral handler) {
		this.handler = handler;
		initUI();
	}

	private void initUI() {

		lblTitulo = new JLabel("Alta de Tareas");
		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");

		lblDescripcion = new JLabel("Descripcion");
		lblAsignadoHoras = new JLabel("Horas Asignadas");
		lblProyectoAsig = new JLabel("Proyecto Asignado");
		lblEmpleadoAsig = new JLabel ("Empleado Asignado");
		
		txtDescripcion = new JTextField ("");
		txtAsignadoHoras = new JTextField ("");
		txtProyectoAsig = new JTextField ("");
		txtEmpleadoAsig = new JTextField ("");
		
		
		txtDescripcion.setMaximumSize(new Dimension(450, 30));
		txtAsignadoHoras.setMaximumSize(new Dimension(450, 30));
		txtProyectoAsig.setMaximumSize(new Dimension(450, 30));
		txtEmpleadoAsig.setMaximumSize(new Dimension(450, 30));

		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		
		JPanel rowTitulo = new JPanel();
		JPanel rowDescripcion = new JPanel();
		JPanel rowAsignadoHoras =  new JPanel();
		JPanel rowProyectoAsig = new JPanel();
		JPanel rowEmpleadoAsig = new JPanel();
		JPanel rowBotones = new JPanel();

		
		
		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowDescripcion.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowAsignadoHoras.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowProyectoAsig.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowEmpleadoAsig.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		
		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));
		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		rowDescripcion.add(lblDescripcion);
		rowAsignadoHoras.add(lblAsignadoHoras);
		rowProyectoAsig.add(lblProyectoAsig);
		rowEmpleadoAsig.add(lblEmpleadoAsig);
		rowBotones.add(botonAceptar);

		rowDescripcion.add(Box.createHorizontalStrut(10));
		rowAsignadoHoras.add(Box.createHorizontalStrut(10));
		rowProyectoAsig.add(Box.createHorizontalStrut(10));
		rowEmpleadoAsig.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		
		rowDescripcion.add(txtDescripcion);
		rowAsignadoHoras.add(txtAsignadoHoras);
		rowProyectoAsig.add(txtProyectoAsig);
		rowEmpleadoAsig.add(txtEmpleadoAsig);
		rowBotones.add(botonCancelar);
		
		
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (validarCampo(txtDescripcion) || validarCampo(txtAsignadoHoras) || validarCampo(txtProyectoAsig) || validarCampo(txtEmpleadoAsig))

					handler.mostrarError("Por favor complete todos los campos.");

				else {
					int asignadoHoras =1;
					
					if (validarNumero(txtAsignadoHoras.getText(), "asignadoHoras"))
					asignadoHoras = Integer.parseInt(txtAsignadoHoras.getText());
					
					
					Tarea t = new Tarea(txtDescripcion.getText(),asignadoHoras,1,1);
					handler.altaTarea(t);
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
		this.add(rowAsignadoHoras);
		this.add(rowProyectoAsig);
		this.add(rowEmpleadoAsig);
		this.add(rowBotones);
		
		

	}

}