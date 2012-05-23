/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Tipo;

/**
 * @author Felipe Carlos
 *
 */
public interface IRepositorioTipo {

    /**
     * Cadastra um tipo de produto no banco de dados
     */
    public void salvar(Tipo t) throws ConexaoException, RepositorioException;

    /**
     * Excluir tipos cadastrados de produtos
     */
    public void excluirTipos(int tipos_Codigo) throws ConexaoException, RepositorioException;

    public void excluirTipos(String tipos_Descricao) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão de alteração da tabela Tipo
     */
    public void alterar(Tipo t) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão para consultar
     */
    public Tipo consultarTipos(String tipos_Descricao) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão para consultar
     */
    public Tipo consultarTipos(int tipos_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Metodo Padrão para lista os dados
     */
    public Collection<Tipo> listarTipo(String Tipos_Descricao) throws ConexaoException, RepositorioException;
}