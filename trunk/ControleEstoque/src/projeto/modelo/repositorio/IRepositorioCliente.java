/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Cliente;
import projeto.modelo.to.PessoaFisica;
import projeto.modelo.to.PessoaJuridica;

/**
 * @author Sandro
 *
 */
public interface IRepositorioCliente {

    /**
     * Insere um registro/fornecedor no banco de dados
     *
     * @param f Fornecedor
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void salvar(PessoaFisica pf) throws ConexaoException, RepositorioException;

    public void salvar(PessoaJuridica pj) throws ConexaoException, RepositorioException;

    /**
     * Exclui um registro/fornecedor no banco de dados
     *
     * @param Fornecedor_Codigo int, código do Fornecedor a ser excluído
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(int clientes_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Altera um registro/fornecedor no banco de dados
     *
     * @param end Fornecedor - Identifica o fornecedor a ser alterado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void alterar(PessoaFisica pf) throws ConexaoException, RepositorioException;

    public void alterar(PessoaJuridica pj) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/fornecedor baseado no código do fornecedor informado
     *
     * @param fornecedor_Codigo int - Código dendereço a ser consultado
     * @return Endereco, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public PessoaFisica consultarPF(String pf_Cpf) throws ConexaoException, RepositorioException;

    public PessoaJuridica consultarPJ(String pj_CNPJ) throws ConexaoException, RepositorioException;

    public PessoaFisica consultarPF_Nome(String pf_Nome) throws ConexaoException, RepositorioException;

    public PessoaJuridica consultarPJ_RSocial(String pj_RSocial) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/endereco baseado no nome informado
     *
     * @param fornecedor_RazaoSocial String - razao_Social do Fornecedor
     * @return Fornecedor, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    //public Fornecedor consultar ( String razao_Social ) throws ConexaoException, RepositorioException;
    /**
     * Retorna uma lista de todos os Fornecedores
     *
     * @return Collection<Fornecedor>
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Cliente> listar() throws ConexaoException, RepositorioException;
}