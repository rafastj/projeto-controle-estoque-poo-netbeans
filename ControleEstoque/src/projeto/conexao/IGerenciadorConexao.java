/**
 *
 */
package projeto.conexao;

import java.sql.Connection;
import projeto.erro.ConexaoException;

/**
 * @author DANIEL VALENÇA
 *
 * Interface responsável por estqbelecer o padrão de conexão do sistema
 *
 */
public interface IGerenciadorConexao {

    public Connection conectar() throws ConexaoException;

    public void desconectar(Connection conexao) throws ConexaoException;
}