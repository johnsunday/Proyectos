package exceptions;

/**
 * Definimos una excepcion, que sera la que utilicemos en los try catch de cada metodo. 
 * Si no lo trabajamos, la subimos a la siguiente capa.
 *
 */

public class MyDAOExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public MyDAOExcepcion (String msg){
	      super(msg);
	   }
}
