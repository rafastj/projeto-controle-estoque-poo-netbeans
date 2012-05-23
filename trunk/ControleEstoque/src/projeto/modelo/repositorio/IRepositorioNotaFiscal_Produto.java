/**
 *
 */
package projeto.modelo.repositorio;

import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.NotaFiscal;
import projeto.modelo.to.NotaFiscal_Produto;
import projeto.modelo.to.Produto;

/**
 * @author diego
 *
 */
public interface IRepositorioNotaFiscal_Produto {

    /**
     * Insere um registro/produto no banco de dados
     */
    public void salvar(NotaFiscal_Produto np) throws ConexaoException, RepositorioException;

    /**
     * ATUALIZAR A QUANTIDADE DO PRODUTO
     *
     * @param p
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void atualizarProdutoQtde(Produto p) throws ConexaoException, RepositorioException;

    /**
     * ATUALIZAR O VALOR DA NOTA FISCAL
     *
     * @param np
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void atualizarNotaFiscalValordaNota(NotaFiscal np) throws ConexaoException, RepositorioException;

    /**
     * CONSULTAR se exite produto vinculado a nota fiscal
     *
     * @param NotaFiscal_Numero
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public NotaFiscal_Produto consultarNotaFiscal_Numero(int NotaFiscal_Numero) throws ConexaoException, RepositorioException;

    /**
     * CONSULTAR a Nota Fiscal possui Produto
     *
     * @param NotaFiscal_Numero
     * @param Produtos_Codigo
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public NotaFiscal_Produto consultarNotaFiscal_Produto(int NotaFiscal_Numero, int Produtos_Codigo) throws ConexaoException, RepositorioException;

    /**
     * EXCLUIR vinculo da Nota Fiscal com o tal produto salvo!
     *
     * @param NotaFiscal_Numero
     * @param Produtos_Codigo
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(int NotaFiscal_Numero, int Produtos_Codigo) throws ConexaoException, RepositorioException;

    /**
     * LISTAR Produtos de tal Nota Fiscal
     *
     * @param notaFiscal_Numero
     * @return
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Collection<NotaFiscal_Produto> lista(int notaFiscal_Numero) throws ConexaoException, RepositorioException;

    public void atualizarNotaFiscal_Produto(NotaFiscal_Produto np) throws ConexaoException, RepositorioException;
}