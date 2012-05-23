/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Segmento;

/**
 * @author Bruno Pinheiro
 *
 */
public interface IRepositorioSegmento {

    /**
     * Cadastra um segmento do produto no banco de dados
     */
    public void salvar(Segmento s) throws ConexaoException, RepositorioException;

    /**
     * Excluir segmentos cadastrados dos produtos
     */
    public void excluir(int segmento_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão de alteração de segmentos
     */
    public void alterar(Segmento s) throws ConexaoException, RepositorioException;

    /**
     * Metodo padrão para consultar
     */
    public Segmento consultarSegmentos(String segmentos_Descricao) throws ConexaoException, RepositorioException;

    public Segmento consultarSegmentos(int segmentos_Codigo) throws ConexaoException, RepositorioException;

    /**
     * Metodo Padrão para lista os dados
     */
    public Collection<Segmento> listarSegmentos(String segmentos_Descricao) throws ConexaoException, RepositorioException;
}