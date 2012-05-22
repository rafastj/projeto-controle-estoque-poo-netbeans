/**
 * Interface responsável por definir o padrão DAO para Produto
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Produto;


/**
 * @author Diego Silva
 *
 */
public interface IRepositorioProduto {

	/**
	 * Insere um registro/produto no banco de dados
	 */
	public void salvar (Produto p) throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Excluir produto da tabela produtos
	 */
	public void excluir (int produtos_Codigo) throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Metodo padrão de alteração da tabela produtos
	 */
	public void alterar ( Produto p)throws ConexaoException,RepositorioException;
	
	
	
	/**
	 * Metodo padrão para consultar pela Descricao
	 */
	public Produto consultarDescricao (String produtos_Descricao)throws ConexaoException,RepositorioException;
	
	
	/**
	 * Metodo padrão para consultar pelo Codigo
	 */
	public Produto consultarCodigo ( int produtos_Codigo ) throws ConexaoException, RepositorioException;
	
	
	/**
	 * Metodo Padrão para lista os dados
	 */
	public Collection <Produto> listar ( String produtos_Descricao)throws ConexaoException, RepositorioException;
}