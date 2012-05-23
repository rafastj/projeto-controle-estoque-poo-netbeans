/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.RepositorioProduto;
import projeto.modelo.repositorio.RepositorioProduto_Fornecedor;
import projeto.modelo.to.Produto;
import projeto.modelo.to.Produto_Fornecedor;

/**
 * @author diego
 *
 */
public class NegocioProduto_Fornecedor {

    /**
     * Contrutor inicializa o atributo "rep" responsável pela camada de acesso a
     * dados
     */
    private RepositorioProduto_Fornecedor rep;
    private RepositorioProduto repProduto;

    public NegocioProduto_Fornecedor() {
        rep = new RepositorioProduto_Fornecedor();
        repProduto = new RepositorioProduto();
    }

    /**
     * Salvar a relação do Fornecedor que fornece tal produto
     *
     * @param pf
     * @throws GeralException
     */
    public void salvarProduto_Fornecedor(Produto_Fornecedor pf) throws GeralException {

        if (pf.getProdutos_Codigo() <= 0) {
            throw new GeralException("Informe o código do produto");
        }

        if (pf.getFornecedores_Codigo() <= 0) {
            throw new GeralException("Informe o código do fornecedor");
        }

        try {
            Produto pfconsul = repProduto.consultarCodigo(pf.getProdutos_Codigo());
            if (pfconsul == null) {
                throw new GeralException("Produto não encontrado!");
            }
            //altenticação da existencia do fornecedor

            rep.salvar(pf);
        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Consultar se o Fornecedor fornece tah produto
     *
     * @param Fornecedores_RazaoSocial
     * @param Produtos_Descricao
     * @return
     * @throws GeralException
     */
    public Produto_Fornecedor ConsultarFornecedor_Produto(String Fornecedores_RazaoSocial, String Produtos_Descricao) throws GeralException {

        //gerei um produto_fornecedor que irar se vazio
        Produto_Fornecedor pf = null;

        if (Fornecedores_RazaoSocial == null) {
            throw new GeralException("Informe o código do fornecedor");
        }

        if (Produtos_Descricao == null) {
            throw new GeralException("Informe o código do produto");
        }
        try {
            //falta utilizar a consultar por String do Fornecedor (Daniel)

            //Consultar se existe o tal produto informado na tabela Produto (Diego)
            Produto pconsul = repProduto.consultarDescricao(Produtos_Descricao);
            if (pconsul == null) {
                throw new GeralException("Esse produto não existe na tabela de Produtos!");
            }

            pf = rep.ConsultarLigacaoFornecedorProduto(Fornecedores_RazaoSocial, Produtos_Descricao);

            if (pf == null) {
                throw new GeralException("Esse fornecedor não fornece esse produto!");
            }
        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }

        return pf;
    }

    /**
     * Excluir o relacionamento que o Fornecedor tem com o Produto
     *
     * @param Fornecedor_Codigo
     * @param Produto_Codigo
     * @throws GeralException
     */
    public void excluirFornecedor_Produto(int Fornecedor_Codigo, int Produto_Codigo) throws GeralException {

        if (Fornecedor_Codigo <= 0) {
            throw new GeralException("Informe o Código do FORNECEDOR!");
        }

        if (Produto_Codigo <= 0) {
            throw new GeralException("Informe o Códiego do PRODUTO!");
        }

        try {

            //falta implementar o consultar fornecedor que ainda não foi feito

            //Impletamentação do consultar o código do produto
            Produto pconsul = repProduto.consultarCodigo(Produto_Codigo);
            if (pconsul == null) {
                throw new GeralException("Código do produto não existente");
            }

            //Se caso os dados passarem na verificação dos dados Irar executa de fato a exclusão!
            rep.excluir(Fornecedor_Codigo, Produto_Codigo);


        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }

    }

    /**
     * Alterar o produto do fornecedor da tabela Produtos_Fornecedores
     *
     * @param Fornecedores_RazaoSocial
     * @param Produtos_Descricao
     * @throws GeralException
     */
    public void alterarProduto_Fornecedor(String Fornecedores_RazaoSocial, String Produtos_Descricao) throws GeralException {

        if (Fornecedores_RazaoSocial == null) {
            throw new GeralException("Informe o Nome do FORNECEDOR!");
        }

        if (Produtos_Descricao == null) {
            throw new GeralException("Informe o Nome do PRODUTO");
        }

        try {

            //Consultar se existe Fornecedor fornecendo o codigo do produto informado!
            Produto_Fornecedor pfconsul = rep.ConsultarLigacaoFornecedorProduto(Fornecedores_RazaoSocial, Produtos_Descricao);
            if (pfconsul == null) {
                throw new GeralException("O Fornecedor não fornece este Produto");
            }

            //recebe o nome do produto substituto
            String NProduto = JOptionPane.showInputDialog("O fornecedor.: " + pfconsul.getFornecedor().getFornecedores_RazaoSocial() + "| fornece sim -> " + pfconsul.getProduto().getProdutos_Descricao() + ". Informe o nome do produto substituto!");

            //Procura na tabela Produtos a existencia do produto informado
            //Consultar se existe o tal produto informado na tabela Produtos (Diego)
            Produto psconsul = repProduto.consultarDescricao(NProduto);
            if (psconsul == null) {
                throw new GeralException("Esse produto não existe na tabela de Produtos!");
            }


            //Se caso os dados passarem na verificação dos dados Irar executa de fato a exclusão!
            rep.alterar(pfconsul.getFornecedores_Codigo(), psconsul.getProdutos_Codigo(), pfconsul.getFornecedores_Codigo(), pfconsul.getProdutos_Codigo());


        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    public Collection<Produto_Fornecedor> listarFornecedordeProduto(String Produto_Descricao) throws GeralException {

        //criar uma array lista vazia
        ArrayList<Produto_Fornecedor> lista;

        //verifica se foi realmente informado o nome do produto
        if (Produto_Descricao == null) {
            throw new GeralException("O Nome do Produto não foi Informado!");
        }

        try {

            Produto psconsul = repProduto.consultarDescricao(Produto_Descricao);
            if (psconsul == null) {
                throw new GeralException("Esse produto não existe na tabela de Produtos!");
            }

            lista = (ArrayList<Produto_Fornecedor>) new RepositorioProduto_Fornecedor().listar(Produto_Descricao);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
}