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

import Exceptions.MyDAOExcepcion;
import Exceptions.MyFormatExcepcion;
import Swing.HandlerGeneral;
import entidades.Empleado;

/**
 * Definimos el layout para el panel necesario al dar de alta un empleado. Cada
 * vez que necesitamos mostrar un panel para el alta de proyectos, directamente
 * llamamos a esta clase. En su contructor, el panel espera un handler, que
 * proviene desde el form.
 *
 */

public class PanelAltaEmpleado extends PanelPadre {

	private static final long serialVersionUID = 1L;

	private JButton botonAceptar;
	private JButton botonCancelar;
	
	private JLabel lblTitulo;
	private JLabel lblNombreCompleto;
	private JLabel lblSueldoHora;

	private JTextField txtNombreCompleto;
	private JTextField txtSueldoHora;

	private HandlerGeneral handler;

	public PanelAltaEmpleado(HandlerGeneral handler) {
		this.handler = handler;
		initUI();
	}

	private void initUI() {

		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");
		
		lblTitulo = new JLabel("Alta de empleados");
		
		lblNombreCompleto = new JLabel("Nombre Completo:");
		lblSueldoHora = new JLabel("Sueldo por hora:");
		
		txtNombreCompleto = new JTextField("");
		txtSueldoHora = new JTextField("");
		
		txtNombreCompleto.setMaximumSize(new Dimension(450, 30));
		txtSueldoHora.setMaximumSize(new Dimension(450, 30));

		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		
		JPanel rowTitulo = new JPanel();
		JPanel rowNombreCompleto = new JPanel();
		JPanel rowSueldoHora = new JPanel();
		JPanel rowBotones = new JPanel();

		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowNombreCompleto.setLayout(new BoxLayout(rowNombreCompleto, BoxLayout.X_AXIS));

		rowNombreCompleto.setLayout(new BoxLayout(rowNombreCompleto, BoxLayout.X_AXIS));
		rowSueldoHora.setLayout(new BoxLayout(rowSueldoHora, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));

		rowTitulo.add(Box.createHorizontalStrut(10));
		rowNombreCompleto.add(Box.createHorizontalStrut(10));
		rowSueldoHora.add(Box.createHorizontalStrut(10));
		
		rowBotones.add(Box.createHorizontalStrut(10));

		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));

		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		rowNombreCompleto.add(lblNombreCompleto);
		rowSueldoHora.add(lblSueldoHora);
		
		rowBotones.add(botonAceptar);

		rowNombreCompleto.add(Box.createHorizontalStrut(10));
		rowSueldoHora.add(Box.createHorizontalStrut(10));
		
		rowBotones.add(Box.createHorizontalStrut(10));

		rowNombreCompleto.add(txtNombreCompleto);
		rowSueldoHora.add(txtSueldoHora);
		
		rowBotones.add(botonCancelar);

		rowNombreCompleto.add(Box.createHorizontalStrut(10));
		rowSueldoHora.add(Box.createHorizontalStrut(10));
		
		rowBotones.add(Box.createHorizontalStrut(10));

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (validarCampo(txtNombreCompleto) || validarCampo(txtSueldoHora))

					handler.mostrarError("Por favor complete todos los campos.");

				else {
					int sueldoHora =1;						
					sueldoHora = Integer.parseInt(txtSueldoHora.getText());
					
					Empleado emp = new Empleado(sueldoHora, txtNombreCompleto.getText());

					handler.altaEmpleado(emp);
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
		this.add(rowNombreCompleto);
		this.add(rowSueldoHora);
		this.add(rowBotones);

	}

}