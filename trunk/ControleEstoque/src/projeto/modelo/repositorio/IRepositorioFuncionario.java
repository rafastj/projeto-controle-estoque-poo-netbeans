/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Funcionario;

/**
 * @author Thiago Evoa
 *
 */
public interface IRepositorioFuncionario {

    /**
     * Insere um Funcionario no banco de dados
     * @param fu Funcionario
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void salvar(Funcionario fu) throws ConexaoException, RepositorioException;

    /**
     * Excluir um Funcionario no banco de dados
     * @param funcionarios_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(int funcionarios_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Excluir um Funcionario no banco de dados
     * @param fu Funcionario
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(String funcionarios_Nome) throws ConexaoException, RepositorioException;
    
    /**
     * Alterar um Funcionario no banco de dados
     * @param fu Funcionario
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void alterar(Funcionario fu) throws ConexaoException, RepositorioException;

    /**
     * Consultar um Funcionario pelo código
     * @param funcionarios_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Funcionario consultar(int funcionarios_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Consultar um Funcionario pelo nome
     * @param funcionarios_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Funcionario consultar(String funcionarios_Nome) throws ConexaoException, RepositorioException;

    /**
     * Mostra uma lista de Funcionario pelo código
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Funcionario> listar(int funcionarios_Codigo) throws ConexaoException, RepositorioException;
}