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
import Swing.HandlerProyecto;
import entidades.Proyecto;


/**
 * Definimos el layout para el panel necesario al dar de baja un proyecto. 
 * Cada vez que necesitamos mostrar un panel para la baja de proyectos, directamente llamamos a esta clase.
 * En su contructor, el panel espera un handler, que proviene desde el form. 
 *
 */
public class PanelBajaProyecto extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel lblId;
	private JLabel lblTema;
	private JLabel lblTitulo;
	private JTextField txtId;
	private JTextField txtTema;

	private HandlerProyecto handler;

	public PanelBajaProyecto(HandlerProyecto handler) {
		this.handler = handler;
		initUI();
	}

	private void initUI() {

		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");
		lblTitulo = new JLabel("Baja de Proyectos");
		lblId = new JLabel(" Id.  :");
		lblTema = new JLabel("Tema :");
		txtId = new JTextField("");
		txtTema = new JTextField("");

		txtId.setMaximumSize(new Dimension(450, 30));
		txtTema.setMaximumSize(new Dimension(450, 30));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel rowTitulo = new JPanel();
		JPanel rowID = new JPanel();
		JPanel rowTema = new JPanel();
		JPanel rowBotones = new JPanel();

		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowID.setLayout(new BoxLayout(rowID, BoxLayout.X_AXIS));
		rowTema.setLayout(new BoxLayout(rowTema, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));

		rowTitulo.add(Box.createHorizontalStrut(10));
		rowID.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));

		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		rowID.add(lblId);
		rowTema.add(lblTema);
		rowBotones.add(botonAceptar);

		rowID.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		rowID.add(txtId);
		rowTema.add(txtTema);
		rowBotones.add(botonCancelar);

		rowID.add(Box.createHorizontalStrut(10));
		rowTema.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Proyecto p = handler.validarProyecto(txtId.getText(), null, null);
					try {
						
						handler.bajaProyecto(p);
						handler.mostrarExito("El proyecto ha sido eliminado");
						
					} catch (MyDAOExcepcion e) {
					
						handler.mostrarError(e.getMessage());
					} 
				} catch (MyFormatExcepcion e1){
					handler.mostrarError(e1.getMessage());
					
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
		this.add(rowID);
		//this.add(rowTema);
		this.add(rowBotones);
		// this.add(botonAceptar);
		// this.add(botonCancelar);

	}

}