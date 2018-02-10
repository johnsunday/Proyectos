package Swing.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

import Swing.HandlerGeneral;

/**
 * Se define un formulario para contener todos los paneles.
 * La estructura del layout es: Form -> Jpanel -> Objetos del panel (Btns, txtBox, etc.)
 * Tambien esta definido el JmenuBar. Estructura: JMenuBAr -> JMenu->  JMenuItem
 * 
 *
 */
public class MiFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private HandlerGeneral handler;
	

/*	
	public MiFrame(handlerGeneral handlerGeneral) {
		this.handlerGeneral = handlerGeneral;
		initUI();
	}

	public MiFrame(HandlerProyecto handler) {
		this.handler = handler;
		initUI();
	}
*/
	
	public MiFrame(HandlerGeneral handler) {
		this.handler=handler;
		initUI();
	}

	
	private void initUI() {

		this.setTitle("Haunstetter & Ortiz - Project Management Tool");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		JMenuBar mb;

		JMenuItem miAltaProyecto;
		JMenuItem miBajaProyecto;
		JMenuItem miModificacionProyecto;

		JMenuItem miAltaEmpleado;
		JMenuItem miBajaEmpleado;
		JMenuItem miModificacionEmpleado;

		JMenuItem miAltaTarea;
		JMenuItem miBajaTarea;
		JMenuItem miModificacionTarea;

		
		JMenuItem miReporteProyByEstado;
		
		JMenu mproyecto;
		JMenu mEmpleado;
		JMenu mtarea;
		JMenu mreportes;

		mb = new JMenuBar();

		miAltaProyecto = new JMenuItem("Alta");
		miBajaProyecto = new JMenuItem("Baja");
		miModificacionProyecto = new JMenuItem("Modificacion");

		miAltaEmpleado = new JMenuItem("Alta");
		miBajaEmpleado = new JMenuItem("Baja");
		miModificacionEmpleado = new JMenuItem("Modificacion");

		

		miAltaTarea = new JMenuItem("Alta");
		miBajaTarea = new JMenuItem("Baja");
		miModificacionTarea = new JMenuItem("Modificacion");
		
		
		miReporteProyByEstado = new JMenuItem("Proyectos por estado");

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

		
		// MENU DE Tarea//
		mtarea = new JMenu();
		mtarea.setText("Tarea");
		mtarea.add(miAltaTarea);
		mtarea.add(miBajaTarea);
		mtarea.add(miModificacionTarea);

		//MENU DE Reportes //
		mreportes = new JMenu();
		mreportes.setText("Reportes");
		mreportes.add(miReporteProyByEstado);
		

		mb.add(mEmpleado);
		mb.add(mproyecto);
		mb.add(mtarea);
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
				handler.mostrarAltaEmpleado();
			}

		});

		miBajaEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				handler.mostrarBajaEmpleado();
			}

		});
		
		miModificacionEmpleado.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent arg0) {

			handler.verEmpleados();
		}

	});

		
		// PANEL DE TAREAS //
		miAltaTarea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.mostrarAltaTarea();
			}

		});

		miBajaTarea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				handler.mostrarBajaTarea();
			}

		});
		
		miModificacionTarea.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent arg0) {

			handler.verTareas();
		}

	});

		
		miReporteProyByEstado.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent arg0) {

			handler.verProyectosByEstado("Iniciado");
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
