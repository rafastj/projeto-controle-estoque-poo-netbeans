/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Fornecedor;

/**
 * @author DANIEL VALENÇA
 *
 */
public interface IRepositorioFornecedor {

    /**
     * Insere um registro/fornecedor no banco de dados
     *
     * @param f Fornecedor
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void salvar(Fornecedor f) throws ConexaoException, RepositorioException;

    /**
     * Exclui um registro/fornecedor do banco de dados
     *
     * @param Fornecedor_Codigo int, código do Fornecedor a ser excluído
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(int fornecedores_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Exclui um registro/fornecedor do banco de dados
     *
     * @param fornecedor_CNPJ String
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(String fornecedores_CNPJ) throws ConexaoException, RepositorioException;

    /**
     * Altera um registro/fornecedor no banco de dados
     *
     * @param end Fornecedor - Identifica o fornecedor a ser alterado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void alterar(Fornecedor f) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/fornecedor baseado no código do fornecedor informado
     *
     * @param fornecedor_Codigo int - Código dendereço a ser consultado
     * @return Endereco, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Fornecedor consultarRazaoSocial(String fornecedores_RazaoSocial) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/endereco baseado no nome informado
     *
     * @param fornecedor_RazaoSocial String - razao_Social do Fornecedor
     * @return Fornecedor, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Fornecedor consultarCNPJ(String fornecedores_CNPJ) throws ConexaoException, RepositorioException;

    /**
     * Retorna uma lista de todos os Fornecedores
     *
     * @return Collection<Fornecedor>
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Fornecedor> listar(String fornecedores_CNPJ) throws ConexaoException, RepositorioException;
}