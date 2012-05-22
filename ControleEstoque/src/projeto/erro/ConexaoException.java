/**
 * 
 */
package projeto.erro;

/**
 * @author DANIEL VALENÇA
 *
 */
@SuppressWarnings("serial")
public class ConexaoException extends Exception {
	
	public ConexaoException () {
		super();
	}
	
	public ConexaoException (String texto) {
		super(texto);
	}
	
	public ConexaoException (Exception e) {
		super (e);
	}

}