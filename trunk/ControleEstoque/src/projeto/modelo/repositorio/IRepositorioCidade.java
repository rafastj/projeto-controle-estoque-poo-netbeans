/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Cidade;

/**
 * @author DANIEL VALENÇA
 *
 */
public interface IRepositorioCidade {

    /**
     * Insere um registro/cidade no banco de dados
     *
     * @param cd Cidade
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void salvar(Cidade cd) throws ConexaoException, RepositorioException;

    /**
     * Exclui um registro/cidade no banco de dados
     *
     * @param cidades_Codigo int, código da cidade a ser excluído
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(int cidades_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Exclui um registro/cidade no banco de dados
     *
     * @param cidades_Nome String, nome da cidade a ser excluído
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(String cidades_Nome) throws ConexaoException, RepositorioException;

    /**
     * Altera um registro/cidade no banco de dados
     *
     * @param cd Cidade - Identifica a cidade a ser alterada
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void alterar(Cidade cd) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/cidade baseado no código da cidade informado
     *
     * @param cidade_Codigo int - Código da cidade a ser consultada
     * @return Cidade, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Cidade consultar(int cidades_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Retorna um registro/cidade baseado no nome informado
     *
     * @param cidade_Nome String - Nome da cidade
     * @return Cidade, ou Null se não for encontrado
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Cidade consultar(String cidades_Nome) throws ConexaoException, RepositorioException;

    /**
     * Retorna uma lista de todas as cidades
     *
     * @return Collection<Cidade>
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Cidade> listarTudo() throws ConexaoException, RepositorioException;
    
    /**
     * 
     * @param cidades_Nome
     * @return
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    public Collection<Cidade> listarCidadeNome(String cidades_Nome) throws ConexaoException, RepositorioException;
}