package exceptions;

import com.sun.org.omg.CORBA.ExceptionDescriptionHelper;

/**
 * Definimos una excepcion, que sera la que utilicemos en los try catch de cada metodo. 
 * Si no lo trabajamos, la subimos a la siguiente capa.
 *
 */
public class MyFormatExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public MyFormatExcepcion(String message) {
	super(message);
	}

	
}
