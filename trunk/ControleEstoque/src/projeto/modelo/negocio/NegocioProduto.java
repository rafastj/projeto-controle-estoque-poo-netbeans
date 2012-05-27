/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.*;
import projeto.modelo.to.Marca;
import projeto.modelo.to.Produto;
import projeto.modelo.to.Segmento;
import projeto.modelo.to.Tipo;

/**
 * @author diego
 *
 */
public class NegocioProduto {

    private IRepositorioProduto rep;
    private IRepositorioSegmento reps;
    private IRepositorioTipo rept;
    private IRepositorioMarca repm;

    /**
     * Contrutor inicializa o atributo "rep" responsável pela camada de acesso a
     * dados
     */
    public NegocioProduto() {
        rep = new RepositorioProduto();
        reps = new RepositorioSegmento();
        rept = new RepositorioTipo();
         repm = new RepositorioMarca();
    }


    /**
     * Verificar os dados antes de salvar este método usa Exceptions para
     * transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void salvarProduto(Produto p) throws GeralException {
        //validação dos campos no próprio método

        //validação da seleção do segmento
        if (p.getSegmentos_Codigo() <= 0) {
            throw new GeralException("Segmento não informado!");
        }

        //validaão da seleção do Tipo
        if (p.getTipos_Codigo() <= 0) {
            throw new GeralException("Tipo não informado!");
        }

        //validação da seleção da marca
        if (p.getMarcas_Codigo() <= 0) {
            throw new GeralException("Marca não informada!");
        }

        //validação da descricao
        if (p.getProdutos_Descricao() == null) {
            throw new GeralException("Descrição não informada!");
        }

        //validação da quantidade
        if (p.getProdutos_Quantidade() <= 0) {
            throw new GeralException("Quantidade não informada!");
        }

        //validação do valor de venda
        if (p.getProdutos_ValorVenda() <= 0) {
            throw new GeralException("Valor de Venda não informado!");
        }

        try {

            //verificar se o produto já foi cadastrado
            Produto pconsul = rep.consultarDescricao(p.getProdutos_Descricao());
            if (pconsul != null) {
                throw new GeralException("Produto já cadastrado!");
            }

            //verificar se existe o segmento informado
            Segmento sconsul = reps.consultarSegmentos(p.getSegmentos_Codigo());
            if (sconsul == null) {
                throw new GeralException("O código do segmento informado não existe!");
            }

            //verificar se existe o Tipo informado
            Tipo tconsul = rept.consultarTipos(p.getTipos_Codigo());
            if (tconsul == null) {
                throw new GeralException("O código do tipo informado não existe!");
            }

            //verificar se o existe a Marca informada
            Marca mconsul = repm.consultarMarcas(p.getMarcas_Codigo());
            if (mconsul == null) {
                throw new GeralException("O código da Marca informado não existe!");
            }

            //se caso de tudo certo acima ele irar executar o código abaixo!

            rep.salvar(p);
        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verifica os dados antes de consultar a String
     */
    public Produto consultarDescricao(String produtos_Descricao) throws GeralException {
        Produto p = null;

        if (produtos_Descricao.equals("")) {
            throw new GeralException("Descrição do produto não informada");
        }

        try {
            p = rep.consultarDescricao(produtos_Descricao);

            if (p == null) {
                throw new GeralException("Produto não encontrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return p;
    }

    /**
     * Verifica os dados antes de consultar a String Codigo
     */
    public Produto consultarCodigo(int produtos_Codigo) throws GeralException {
        Produto p = null;

        if (produtos_Codigo <= 0) {
            throw new GeralException("Codigo do produto não informada");
        }

        try {
            p = rep.consultarCodigo(produtos_Codigo);

            if (p == null) {
                throw new GeralException("Produto não encontrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return p;
    }

    /**
     * Verificar os dados antes de excluir o produto este método usa Exceptions
     * para transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void excluirProduto(int produtos_Codigo) throws GeralException {

        //verificar se o codigo do produto foi informado
        if (produtos_Codigo <= 0) {
            throw new GeralException("Produto não foi selecionado para ser deletado!");
        }

        try {

            Produto p = rep.consultarCodigo(produtos_Codigo);
            if (p == null) {
                throw new GeralException("Produto não existe!");
            }

            rep.excluir(produtos_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Ação Negada! Esse produto é relecionado com uma Nota Fiscal!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de Aletar o produto
     *
     * @param p
     * @throws GeralException
     */
    public void alterarProduto(Produto p) throws GeralException {
        //validação dos campos no próprio método

        //validação da seleção do Produto
        if (p.getProdutos_Codigo() <= 0) {
            throw new GeralException("Produto não informado!");
        }

        //validação da seleção do segmento
        if (p.getSegmentos_Codigo() <= 0) {
            throw new GeralException("Segmento não informado!");
        }

        //validaão da seleção do Tipo
        if (p.getTipos_Codigo() <= 0) {
            throw new GeralException("Tipo não informado!");
        }

        //validação da seleção da marca
        if (p.getMarcas_Codigo() <= 0) {
            throw new GeralException("Marca não informada!");
        }

        //validação da descricao
        if (p.getProdutos_Descricao() == null) {
            throw new GeralException("Descrição não informada!");
        }

        //validação da quantidade
        if (p.getProdutos_Quantidade() <= 0) {
            throw new GeralException("Quantidade não informada!");
        }

        //validação do valor de venda
        if (p.getProdutos_ValorVenda() <= 0) {
            throw new GeralException("Valor de Venda não informado!");
        }

        try {

            Produto pconsul = rep.consultarCodigo(p.getProdutos_Codigo());
            if (pconsul == null) {
                throw new GeralException("Produto não existe!");
            }

            rep.alterar(p);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de consultar a lista pela Descrição do Produto
     */
    public Collection<Produto> listarProdutos(String produtos_Descricao) throws GeralException {

        ArrayList<Produto> lista;

        if (produtos_Descricao.equals("")) {
            throw new GeralException("Descrição do produto não informada");
        }
        try {
            lista = (ArrayList<Produto>) new RepositorioProduto().listar(produtos_Descricao);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
    
    /**
     * Verificar os dados antes de consultar a lista pelo Codigo da Marca
     */
    public Collection<Produto> listarProdutosMarca(int marcas_Codigo) throws GeralException {

        ArrayList<Produto> lista;

        if (marcas_Codigo <= 0) {
            throw new GeralException("Código da Marca não informada");
        }
        try {
            lista = (ArrayList<Produto>) new RepositorioProduto().listarMarcas( marcas_Codigo );

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
       }
    
     /**
     * Verificar os dados antes de consultar a lista pelo Codigo do Tipos
     */
    public Collection<Produto> listarProdutosTipos(int tipos_Codigo) throws GeralException {

        ArrayList<Produto> lista;

        if (tipos_Codigo <= 0) {
            throw new GeralException("Código da Marca não informada");
        }
        try {
            lista = (ArrayList<Produto>) new RepositorioProduto().listarTipos( tipos_Codigo );

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
       }
    
     /**
     * Verificar os dados antes de consultar a lista pelo Codigo do Segmento
     */
    public Collection<Produto> listarProdutosSegmento(int Segmentos_Codigo) throws GeralException {

        ArrayList<Produto> lista;

        if (Segmentos_Codigo <= 0) {
            throw new GeralException("Código da Marca não informada");
        }
        try {
            lista = (ArrayList<Produto>) new RepositorioProduto().listarSegmentos( Segmentos_Codigo );

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
       }
    
    
}