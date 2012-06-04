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
import projeto.modelo.repositorio.RepositorioFornecedor;
import projeto.modelo.repositorio.RepositorioProduto;
import projeto.modelo.repositorio.RepositorioProduto_Fornecedor;
import projeto.modelo.to.Fornecedor;
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
    private RepositorioFornecedor repFornecedor;

    public NegocioProduto_Fornecedor() {
        rep = new RepositorioProduto_Fornecedor();
        repProduto = new RepositorioProduto();
        repFornecedor = new RepositorioFornecedor();
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
    public void alterarProduto_Fornecedor(int NFornecedor_Codigo, int NProduto_Codigo, int Fornecedor_Codigo, int Produto_Codigo) throws GeralException {

        if (NFornecedor_Codigo <= 0) {
            throw new GeralException("Informe o código do novo FORNECEDOR!");
        }

        if (NProduto_Codigo <= 0) {
            throw new GeralException("Informe o código do novo PRODUTO");
        }
        
        if (Fornecedor_Codigo <= 0) {
            throw new GeralException("Informe o código do antigo FORNECEDOR!");
        }

        if (Produto_Codigo <= 0) {
            throw new GeralException("Informe o código do antigo PRODUTO");
        }


        try {
            
            //Se caso os dados passarem na verificação dos dados Irar executa de fato a exclusão!
            rep.alterar(NFornecedor_Codigo, NProduto_Codigo, Fornecedor_Codigo, Produto_Codigo);


        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }
    
    /**
     * Lista todos os Fornecedores que fornece o Produto informado
     * @param Produto_Descricao
     * @return
     * @throws GeralException 
     */
    public Collection<Produto_Fornecedor> listarFornecedordeProduto(String Produto_Descricao) throws GeralException {

        //criar uma array lista vazia
        ArrayList<Produto_Fornecedor> lista;

        //verifica se foi realmente informado o nome do produto
        if (Produto_Descricao.equals("")) {
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
    
    /**
     * Metodo para Listar todos os Produtos do Fornecedor informado
     * @param fornecedor_RazaoSocial
     * @return
     * @throws GeralException 
     */
    public Collection<Produto_Fornecedor> listarFornecedordeProdutoFornecido(String fornecedor_RazaoSocial) throws GeralException {

        //criar uma array lista vazia
        ArrayList<Produto_Fornecedor> lista;

        //verifica se foi realmente informado o nome do produto
        if (fornecedor_RazaoSocial.equals("")) {
            throw new GeralException("O Nome do Produto não foi Informado!");
        }

        try {

            Fornecedor fconsul = repFornecedor.consultarRazaoSocial(fornecedor_RazaoSocial);
            if (fconsul == null) {
                throw new GeralException("Esse produto não existe na tabela de Produtos!");
            }

            lista = (ArrayList<Produto_Fornecedor>) new RepositorioProduto_Fornecedor().listarFornecedor(fornecedor_RazaoSocial);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
    
     /**
      * LISTAR Todos os Produtos que tem fornecedores
      * @return
      * @throws GeralException 
      */
     public Collection<Produto_Fornecedor> listarTodos() throws GeralException {
        //criar uma array lista vazia
        ArrayList<Produto_Fornecedor> lista;

        try {
            lista = (ArrayList<Produto_Fornecedor>) new RepositorioProduto_Fornecedor().listarTodos();

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
     
     /**
      * LISTA todos os produtos não fornecidos pelo Fornecedor selecionado
      * @param fornecedor_RazaoSocial
      * @return
      * @throws GeralException 
      */
     public Collection<Produto_Fornecedor> listadeProdutosNaoFornecidos(String fornecedor_RazaoSocial) throws GeralException {

        //criar uma array lista vazia
        ArrayList<Produto_Fornecedor> lista;

        //verifica se foi realmente informado o nome do produto
        if (fornecedor_RazaoSocial.equals("")) {
            throw new GeralException("O Nome do Produto não foi Informado!");
        }

        try {

            lista = (ArrayList<Produto_Fornecedor>) new RepositorioProduto_Fornecedor().listadeProdutosNaoFornecidos(fornecedor_RazaoSocial);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
         
    
//fim
}