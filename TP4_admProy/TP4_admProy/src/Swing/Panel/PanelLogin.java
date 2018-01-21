package Swing.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exceptions.MyDAOExcepcion;
import Exceptions.MyFormatExcepcion;
import Swing.HandlerLogin;

public class PanelLogin extends PanelPadre {

	private static final long serialVersionUID = 1L;

	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton botonIngresar;
	private JButton botonCancelar;
	private HandlerLogin handler;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	
	public PanelLogin(HandlerLogin handler) {
		this.handler = handler;
		initUI();
	}

	private void initUI() {
		this.setSize(500, 500);

		botonIngresar = new JButton("Ingresar");
		botonCancelar = new JButton("Cancelar");
		
		lblTitulo = new JLabel("Login");
		
		lblUsuario= new JLabel("Usuario:");
		lblContraseña = new JLabel("Contraseña:");
		
		txtUsuario= new JTextField("");
		txtContraseña = new JTextField("");
		
		txtUsuario.setMaximumSize(new Dimension(450, 30));
		txtContraseña.setMaximumSize(new Dimension(450, 30));

		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		
		JPanel rowTitulo = new JPanel();
		JPanel rowUsuario= new JPanel();
		JPanel rowContraseña = new JPanel();
		JPanel rowBotones = new JPanel();

		rowTitulo.setLayout(new BoxLayout(rowTitulo, BoxLayout.X_AXIS));
		rowUsuario.setLayout(new BoxLayout(rowUsuario, BoxLayout.X_AXIS));
		rowContraseña.setLayout(new BoxLayout(rowContraseña, BoxLayout.X_AXIS));
		rowBotones.setLayout(new BoxLayout(rowBotones, BoxLayout.X_AXIS));
		
		rowTitulo.add(Box.createHorizontalStrut(10));
		rowUsuario.add(Box.createHorizontalStrut(10));
		rowContraseña.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		lblTitulo.setFont((new Font("Arial", Font.BOLD, 17)));
		lblTitulo.setForeground(Color.LIGHT_GRAY);

		rowTitulo.add(lblTitulo);
		rowUsuario.add(lblUsuario);
		rowContraseña.add(lblContraseña);
		
		rowBotones.add(botonIngresar);

		rowUsuario.add(Box.createHorizontalStrut(10));
		rowContraseña.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));
		
		rowUsuario.add(txtUsuario);
		rowContraseña.add(txtContraseña);
		rowBotones.add(botonCancelar);

		rowUsuario.add(Box.createHorizontalStrut(10));
		rowContraseña.add(Box.createHorizontalStrut(10));
		rowBotones.add(Box.createHorizontalStrut(10));

		botonIngresar.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    if(txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty())
			      JOptionPane.showMessageDialog(null,"Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			    else{
			      if(	"root".equals(txtUsuario.getText()) && "w2e3r4t5".equals(txtContraseña.getText())){ 
			    	 
			    	  handler.cerrarPanelLogin();
			    	
			      }
			      else
			        JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
			      
			      }
			    }
			});

		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}

		});

		this.add(rowTitulo);
		this.add(rowUsuario);
		this.add(rowContraseña);
		this.add(rowBotones);

	}

}