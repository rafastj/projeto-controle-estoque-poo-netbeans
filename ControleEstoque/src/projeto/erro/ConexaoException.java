/**
 *
 */
package projeto.erro;

/**
 * @author DANIEL VALENÇA
 *
 */
public class ConexaoException extends Exception {

    public ConexaoException() {
        super();
    }

    public ConexaoException(String texto) {
        super(texto);
    }

    public ConexaoException(Exception e) {
        super(e);
    }
}