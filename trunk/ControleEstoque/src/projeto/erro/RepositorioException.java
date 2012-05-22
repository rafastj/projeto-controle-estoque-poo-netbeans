/**
 * 
 */
package projeto.erro;

/**
 * @author DANIEL VALENÇA
 *
 */

@SuppressWarnings("serial")
public class RepositorioException extends Exception {
	public RepositorioException () {
		super();
	}
	
	public RepositorioException (String texto) {
		super(texto);
	}
	
	public RepositorioException (Exception e) {
		super (e);
	}
}