package Swing.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Swing.HandlerEmpleado;
import Swing.HandlerProyecto;

/**
 * Se define un formulario para contener todos los paneles.
 * La estructura del layout es: Form -> Jpanel -> Objetos del panel (Btns, txtBox, etc.)
 * Tambien esta definido el JmenuBar. Estructura: JMenuBAr -> JMenu->  JMenuItem
 * 
 *
 */
public class MiFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private HandlerProyecto handler;
	private HandlerEmpleado handlerEmpleado;

	public MiFrame(HandlerProyecto handler) {
		this.handler = handler;
		initUI();
	}

	public MiFrame(HandlerEmpleado handlerEmpleado) {
		this.handlerEmpleado = handlerEmpleado;
		initUI();
	}

	private void initUI() {

		this.setTitle("Haunstetter & Ortiz - Project Management Tool");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		JMenuBar mb;

		JMenuItem miAltaProyecto;
		JMenuItem miBajaProyecto;
		JMenuItem miModificacionProyecto;

		JMenuItem miAltaEmpleado;
		JMenuItem miBajaEmpleado;
		JMenuItem miModificacionEmpleado;

		JMenuItem miAltaReportes;
		JMenuItem miBajaReportes;
		JMenuItem miModificacionReportes;
		JMenu mproyecto;
		JMenu mEmpleado;
		JMenu mreportes;

		mb = new JMenuBar();

		miAltaProyecto = new JMenuItem("Alta");
		miBajaProyecto = new JMenuItem("Baja");
		miModificacionProyecto = new JMenuItem("Ver/Modificar/Eliminar");

		miAltaEmpleado = new JMenuItem("Alta");
		miBajaEmpleado = new JMenuItem("Baja");
		miModificacionEmpleado = new JMenuItem("Modificacion");

		miAltaReportes = new JMenuItem("Alta");
		miBajaReportes = new JMenuItem("Baja");
		miModificacionReportes = new JMenuItem("Modificacion");

		// MENU DE EMPLEADO //

		mEmpleado = new JMenu();
		mEmpleado.setText("Empleado");
		mEmpleado.add(miAltaEmpleado);
		mEmpleado.add(miBajaEmpleado);
		mEmpleado.add(miModificacionEmpleado);

		// MENU DE PROYECTO//
		mproyecto = new JMenu();
		mproyecto.setText("Proyecto");
		mproyecto.add(miAltaProyecto);
		mproyecto.add(miBajaProyecto);
		mproyecto.add(miModificacionProyecto);

		// MENU DE REPORTES //
		mreportes = new JMenu();
		mreportes.setText("Reportes");
		mreportes.add(miAltaReportes);
		mreportes.add(miBajaReportes);
		mreportes.add(miModificacionReportes);

		mb.add(mEmpleado);
		mb.add(mproyecto);
		mb.add(mreportes);

		this.setJMenuBar(mb);

		miAltaProyecto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.mostrarAltaProyecto();
			}

		});

		miBajaProyecto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				handler.mostrarBajaProyecto();
			}

		});
		
		miModificacionProyecto.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent arg0) {

			handler.verProyectos();
		}

	});
	
		
	// PANEL DE EMPLEADOS //
		miAltaEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				handlerEmpleado.mostrarAltaEmpleado();
			}

		});

		miBajaEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				handlerEmpleado.mostrarBajaEmpleado();
			}

		});
		
		miModificacionEmpleado.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent arg0) {

			handlerEmpleado.verEmpleados();
		}

	});

		
	}
	
	/**
	 * Con la funcion CambiarPanel, en el mismo formulario borramos el panel
	 * actual e ingresamos uno nuevo. El nuevo Jpanel lo pasamos con el parametro "p". 
	 * 
	 */
	public void cambiarPanel(JPanel p) {

		this.getContentPane().removeAll();
		this.getContentPane().add(p);
		this.getContentPane().validate();

	}

	
	public void cerrarPanel() {

		this.getContentPane().removeAll();
		this.getContentPane().repaint();
		
	}
}
