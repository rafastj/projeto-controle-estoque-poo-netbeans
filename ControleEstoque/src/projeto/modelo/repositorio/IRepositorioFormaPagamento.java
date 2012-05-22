/**
 * 
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.FormaPagamento;

/**
 * @author Bruno Pinheiro
 *
 */
public interface IRepositorioFormaPagamento {

	/**
	 * Cadastra a forma de pagamento do produto no banco de dados
	 */
	public void salvar (FormaPagamento fp) throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Excluir forma de pagamento cadastradas dos produtos
	 */
	public void excluir (int formaPagamento_Codigo) throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Metodo padrão de alteração das forma de pagamentos
	 */
	public void alterar (FormaPagamento fp)throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Metodo padrão para consultar
	 */
	public FormaPagamento consultarFormaPagamento (String formaPagamento_Descricao)throws ConexaoException,RepositorioException;
	
	
	public FormaPagamento consultarFormaPagamento (int formaPagamento_Codigo)throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Metodo Padrão para lista os dados
	 */
	public Collection <FormaPagamento> listarFormasPagamentos (String formaPagamento_Descricao)throws ConexaoException, RepositorioException;
}