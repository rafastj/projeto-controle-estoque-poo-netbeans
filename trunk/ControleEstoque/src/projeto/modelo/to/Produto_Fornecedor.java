/**
 *
 */
package projeto.modelo.to;

/**
 * @author diego
 *
 */
public class Produto_Fornecedor {

    private int produtos_Codigo;
    private Produto produto = new Produto();
    private int fornecedores_Codigo;
    private Fornecedor fornecedor = new Fornecedor();

    public Produto_Fornecedor() {
    }

    public Produto_Fornecedor(int produtos_Codigo, int fornecedores_Codigo) {
        this.produtos_Codigo = produtos_Codigo;
        this.fornecedores_Codigo = fornecedores_Codigo;
    }

    public int getProdutos_Codigo() {
        return produtos_Codigo;
    }

    public void setProdutos_Codigo(int produtos_Codigo) {
        this.produtos_Codigo = produtos_Codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getFornecedores_Codigo() {
        return fornecedores_Codigo;
    }

    public void setFornecedores_Codigo(int fornecedores_Codigo) {
        this.fornecedores_Codigo = fornecedores_Codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}