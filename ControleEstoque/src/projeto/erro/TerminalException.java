/**
 * 
 */
package projeto.erro;

/**
 * @author DANIEL VALENÇA
 *
 */
@SuppressWarnings("serial")
public class TerminalException extends Exception {
	
	public TerminalException(){
        super();
    }

    public TerminalException(String texto){
        super(texto);
    }

    public TerminalException(Exception e){
        super(e);
    }
}