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
import entidades.Proyecto;

/**
 * Definimos el layout para el panel necesario al dar de alta un proyecto. Cada
 * vez que necesitamos mostrar un panel para el alta de proyectos, directamente
 * llamamos a esta clase. En su contructor, el panel espera un handler, que
 * proviene desde el form.
 *
 */

public class PanelAltaProyecto extends PanelPadre {

	private static final long serialVersionUID = 1L;

	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel lblTema;
	private JLabel lblTitulo;
	private JLabel lblPresupuesto;
	private JTextField txtTema;
	private JTextField txtPresupuesto;

	private HandlerGeneral handler;

	public PanelAltaProyecto(HandlerGeneral handler) {
		this.handler = handler;
		initUI();
	}

	private void initUI() {

		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");
		lblTitulo = new JLabel("Alta de Proyectos");
		lblTema = new JLabel("Tema :");
		lblPresupuesto = new JLabel("Presupuesto:");
		txtTema = new JTextField("");
		txtPresupuesto = new JTextField("");

		txtTema.setMaximumSize(new Dimension(450, 30));
		txtPresupuesto.setMaximumSize(new Dimension(450, 30));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel rowTitulo = new JPanel();
		JPanel rowTema = new JPanel();
		JPanel rowPresupuesto = new JPanel();
		JPanel rowBotones = new JPanel();

		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowTema.setLayout(new BoxLayout(rowTema, BoxLayout.X_AXIS));
		rowPresupuesto.setLayout(new BoxLayout(rowPresupuesto, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));

		rowTitulo.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));

		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		rowTema.add(lblTema);
		rowPresupuesto.add(lblPresupuesto);
		rowBotones.add(botonAceptar);

		rowTema.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		rowTema.add(txtTema);
		rowPresupuesto.add(txtPresupuesto);
		rowBotones.add(botonCancelar);

		rowTema.add(Box.createHorizontalStrut(10));
		rowPresupuesto.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (validarCampo(txtTema) || validarCampo(txtPresupuesto))

					handler.mostrarError("Por favor complete todos los campos.");

				else {

					int presupuesto = 0;

					if (validarNumero(txtPresupuesto.getText(), "Presupuesto")) {

						presupuesto = Integer.parseInt(txtPresupuesto.getText());

						Proyecto p = new Proyecto(txtTema.getText(), presupuesto, "Iniciado");

						handler.altaProyecto(p);

						
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
		this.add(rowTema);
		this.add(rowPresupuesto);
		this.add(rowBotones);

	}

}