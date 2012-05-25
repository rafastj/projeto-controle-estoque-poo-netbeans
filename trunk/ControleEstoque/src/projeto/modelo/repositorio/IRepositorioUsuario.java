/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Usuario;

/**
 * @author Thiago Evoa
 *
 */
public interface IRepositorioUsuario {

    /**
     * Insere um Usuario no banco de dados
     * @param us Usuario
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void salvar(Usuario us) throws ConexaoException, RepositorioException;

    /**
     * Excluir um Usuario no banco de dados
     * @param funcionarios_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(int funcionarios_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Excluir um Usuario no banco de dados
     * @param funcionarios_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(String funcionarios_Nome) throws ConexaoException, RepositorioException;

    /**
     * Alterar um Usuario no banco de dados
     * @param us Usuário
     * @throws ConexaoException
     * @throws RepositorioException
     */
    
    public void alterar(Usuario us) throws ConexaoException, RepositorioException;

    /**
     * Consultar um Usuario pelo código
     * @param funcionarios_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Usuario consultar(int funcionarios_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Consutar um Usuário pelo nome
     * @param funcionarios_Codigo
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Usuario consultar(String funcionarios_Nome) throws ConexaoException, RepositorioException;

    /**
     * Mostra uma lista de Usuarios pelo codigo
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Usuario> listar(int funcionarios_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Mostrar uma Lista de Usuarios pelo nome
     * @param funcionarios_Nome
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<Usuario> listar(String funcionarios_Nome) throws ConexaoException, RepositorioException;
}