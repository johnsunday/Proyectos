package Swing.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exceptions.MyDAOExcepcion;
import Swing.HandlerGeneral;
import entidades.Proyecto;

/**
 * Definimos el layout para el panel necesario para la modif de un proyecto.
 * Cada vez que necesitamos mostrar un panel para la modif de proyectos,
 * directamente llamamos a esta clase. En su contructor, el panel espera un
 * handler, y una instancia de proyecto, desde el cual se tomaran los datos para
 * su modificacion.
 *
 */
public class PanelModificarProyecto extends PanelPadre {

	private static final long serialVersionUID = 1L;

	private JButton botonAceptar;
	private JButton botonCancelar;
	// private JLabel lblId;
	private JLabel lblTema;
	private Proyecto p;
	private JLabel lblTitulo;
	private JLabel lblPresupuesto;
	private JLabel lblEstado;
	private JTextField txtId;
	private JTextField txtTema;
	private JTextField txtPresupuesto;
	private String[] estadosProyecto = new String[]
			{ "Iniciado.", "En proceso.", "Cancelado.", "Finalizado." };
	
	JComboBox<String> estadosCombo = new JComboBox<>(estadosProyecto);

	private HandlerGeneral handler;

	public PanelModificarProyecto(HandlerGeneral handler, Proyecto p) {
		this.handler = handler;
		this.p = p;
		initUI();
	}

	private void initUI() {

		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");
		lblTitulo = new JLabel("Modificacion de Proyectos");
		// lblId = new JLabel(" Id. :");
		lblTema = new JLabel("Tema :");
		lblPresupuesto = new JLabel("Presupuesto:");
		lblEstado = new JLabel("Estado: ");
		// txtId = new JTextField("");
		txtTema = new JTextField("");
		txtPresupuesto = new JTextField("");

		// txtId.setMaximumSize(new Dimension(450, 30));
		txtTema.setMaximumSize(new Dimension(450, 30));
		txtPresupuesto.setMaximumSize(new Dimension(450, 30));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel rowTitulo = new JPanel();
		// JPanel rowID = new JPanel();
		JPanel rowTema = new JPanel();
		JPanel rowPresupuesto = new JPanel();
		JPanel rowEstado = new JPanel();
		JPanel rowBotones = new JPanel();

		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		// rowID.setLayout(new BoxLayout(rowID, BoxLayout.X_AXIS));
		rowTema.setLayout(new BoxLayout(rowTema, BoxLayout.X_AXIS));
		rowPresupuesto.setLayout(new BoxLayout(rowPresupuesto, BoxLayout.X_AXIS));
		rowPresupuesto.setLayout(new BoxLayout(rowPresupuesto, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));

		rowTitulo.add(Box.createHorizontalStrut(10));
		// rowID.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));
		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		// rowID.add(lblId);
		rowTema.add(lblTema);
		rowPresupuesto.add(lblPresupuesto);
		rowEstado.add(lblEstado);
		rowBotones.add(botonAceptar);

		// rowID.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		rowEstado.add(Box.createHorizontalStrut(10));

		// rowID.add(txtId);
		rowTema.add(txtTema);
		rowPresupuesto.add(txtPresupuesto);
		rowEstado.add(estadosCombo);
		rowBotones.add(botonCancelar);

		// rowID.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		rowEstado.add(Box.createHorizontalStrut(10));

		//SETEO
		txtTema.setText(p.getTema());
		
		txtPresupuesto.setText(String.valueOf(p.getPresupuesto()));
		estadosCombo.setSelectedItem(p.getEstado());

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (validarCampo(txtTema) || validarCampo(txtPresupuesto))

					handler.mostrarError("Por favor complete todos los campos.");
				else {

					Proyecto proyectoToModify = new Proyecto(
							txtTema.getText(),
							Integer.parseInt(txtPresupuesto.getText()),
							estadosCombo.getSelectedItem().toString()
							);
					proyectoToModify.setId(p.getId());

					try {
						handler.modificarProyecto(proyectoToModify);
						handler.mostrarExito("El Proyecto " + p.getTema() + " fue modificado.");
						handler.verProyectos();
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
		// this.add(rowID);
		this.add(rowTema);
		this.add(rowEstado);
		this.add(rowPresupuesto);
		this.add(rowBotones);
		// this.add(botonAceptar);
		// this.add(botonCancelar);

	}

}