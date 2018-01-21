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
import Swing.HandlerGeneral;
import entidades.Empleado;
import entidades.Tarea;

public class PanelBajaTarea extends PanelPadre {

	private HandlerGeneral handler;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel lblTitulo;
	private JLabel lblId;
	private JTextField txtId;

	
	
	public PanelBajaTarea(HandlerGeneral handler) {
		this.handler = handler;
		initUI();
	}
	

	private void initUI() {
		
		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");
		lblTitulo = new JLabel("Baja de Tareas");
		lblId = new JLabel(" ID  :");
		txtId = new JTextField ("");
		
		txtId.setMaximumSize(new Dimension(450, 30));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		

		JPanel rowTitulo = new JPanel();
		JPanel rowId = new JPanel();
		JPanel rowBotones = new JPanel();

		
		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowId.setLayout(new BoxLayout(rowId, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));

		
		rowTitulo.add(Box.createHorizontalStrut(10));
		rowId.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));

		lblTitulo.setForeground(Color.LIGHT_GRAY);

		
		rowTitulo.add(lblTitulo);
		rowId.add(lblId);
		rowBotones.add(botonAceptar);

		rowTitulo.add(Box.createHorizontalStrut(10));
		rowId.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		rowId.add(txtId);
		rowBotones.add(botonCancelar);
		rowTitulo.add(Box.createHorizontalStrut(10));
		rowId.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (validarCampo(txtId))
					
				{
					handler.mostrarError("Por favor complete todos los campos.");
					
				}
				
				else
					
					if (validarNumero(txtId.getText(), "id")) {
						
						int id=1;
						
						id = Integer.parseInt(txtId.getText());

						Tarea t = new Tarea (id);

						try {
							handler.bajaTarea(t);
							handler.mostrarExito("Tarea dada de baja correctamente");
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
		this.add(rowId);
		this.add(rowBotones);
		

	}

}