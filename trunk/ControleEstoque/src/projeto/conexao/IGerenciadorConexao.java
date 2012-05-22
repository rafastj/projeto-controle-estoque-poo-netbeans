/**
 * 
 */
package projeto.conexao;

import projeto.erro.ConexaoException;
import java.sql.Connection;

/**
 * @author DANIEL VALENÇA
 *
 *Interface responsável por estqbelecer o padrão de conexão do sistema
 *
 */
public interface IGerenciadorConexao {
	public Connection conectar() throws ConexaoException;
	public void desconectar( Connection conexao ) throws ConexaoException;
}