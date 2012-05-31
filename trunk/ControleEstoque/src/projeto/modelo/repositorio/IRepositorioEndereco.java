/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Endereco;

/**
 * @author DANIEL VALENÇA
 *
 */
public interface IRepositorioEndereco {

    /**
     * Insere um registro/endereço no banco de dados
     *
     * @param end Endereco
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void salvar(Endereco end) throws ConexaoException, RepositorioException;

    /**
     * Exclui um registro/endereço no banco de dados
     *
     * @param enderecos_Logradouro String, nome do endereço a ser excluído
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(String enderecos_Cep) throws ConexaoException, RepositorioException;

    /**
     * Altera um registro/endereço no banco de dados
     *
     * @param end Endereço - Identifica o endereço a ser alterado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void alterar(Endereco end) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/endereço baseado no código do endereço informado
     *
     * @param endereco_Codigo int - Código dendereço a ser consultado
     * @return Endereco, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Endereco consultarLogradouro(String enderecos_Logradouro) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/endereco baseado no nome informado
     *
     * @param endereco_CEP String - CEP do endereço
     * @return Endereco, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Endereco consultarCep(String enderecos_CEP) throws ConexaoException, RepositorioException;

    /**
     * Retorna uma lista de todos os endereços
     *
     * @return Collection<Endereco>
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Endereco> listarTudo() throws ConexaoException, RepositorioException;
    
    /**
     * Retorna uma lista filtrada pelo CEP;
     * 
     * @return
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    public Collection<Endereco> listarEndCEP(String enderecos_CEP) throws ConexaoException, RepositorioException;
    
    /**
     * Retorna uma lista filtrada pelo Logradouro;
     * 
     * @param enderecos_Log
     * @return
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    public Collection<Endereco> listarEndLog(String enderecos_Logradouro) throws ConexaoException, RepositorioException;
    
    /**
     * Retorna uma lista filtrada pelo Nome da Cidade;
     * 
     * @param cidades_Nome
     * @return
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    public Collection<Endereco> listarEndCidade(String cidades_Nome) throws ConexaoException, RepositorioException;
}