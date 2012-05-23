/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Marca;

/**
 * @author Felipe Carlos
 *
 */
public interface IRepositorioMarca {

    /**
     * Cadastra uma marca de produto no banco de dados
     */
    public void salvar(Marca m) throws ConexaoException, RepositorioException;

    /**
     * Excluir marcas cadastrados de produtos
     */
    public void excluirMarcas(int marcas_Codigo) throws ConexaoException, RepositorioException;

    public void excluirMarcas(String marcas_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão de alteração da tabela Tipo
     */
    public void alterar(Marca m) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão para consultar
     */
    public Marca consultarMarcas(String marcas_Descricao) throws ConexaoException, RepositorioException;

    public Marca consultarMarcas(int marcas_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Metodo Padrão para lista os dados
     */
    public Collection<Marca> listarMarca(String marcas_Descricao) throws ConexaoException, RepositorioException;
}