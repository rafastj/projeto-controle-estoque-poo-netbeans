/**
 *
 */
package projeto.modelo.to;

/**
 * @author diego
 *
 */
public class NotaFiscal_Produto {

    private int produtos_Codigo;
    private Produto produto = new Produto();
    private int notasFiscal_Numero;
    private NotaFiscal notasfiscal_Numero = new NotaFiscal();
    private int notasFiscalProdutos_Quantidade;
    private double notasFiscalProdutos_ValorQuantidade;

    public NotaFiscal_Produto() {
    }

    public NotaFiscal_Produto(int produtos_Codigo, int notasFiscal_Numero, int notasFiscalProdutos_Quantidade, double notasFiscalProdutos_ValorQuantidade) {
        this.produtos_Codigo = produtos_Codigo;
        this.notasFiscal_Numero = notasFiscal_Numero;
        this.notasFiscalProdutos_Quantidade = notasFiscalProdutos_Quantidade;
        this.notasFiscalProdutos_ValorQuantidade = notasFiscalProdutos_ValorQuantidade;
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

    public int getNotasFiscal_Numero() {
        return notasFiscal_Numero;
    }

    public void setNotasFiscal_Numero(int notasFiscal_Numero) {
        this.notasFiscal_Numero = notasFiscal_Numero;
    }

    public NotaFiscal getNotasfiscal_Numero() {
        return notasfiscal_Numero;
    }

    public void setNotasfiscal_Numero(NotaFiscal notasfiscal_Numero) {
        this.notasfiscal_Numero = notasfiscal_Numero;
    }

    public int getNotasFiscalProdutos_Quantidade() {
        return notasFiscalProdutos_Quantidade;
    }

    public void setNotasFiscalProdutos_Quantidade(int notasFiscalProdutos_Quantidade) {
        this.notasFiscalProdutos_Quantidade = notasFiscalProdutos_Quantidade;
    }

    public double getNotasFiscalProdutos_ValorQuantidade() {
        return notasFiscalProdutos_ValorQuantidade;
    }

    public void setNotasFiscalProdutos_ValorQuantidade(
            double notasFiscalProdutos_ValorQuantidade) {
        this.notasFiscalProdutos_ValorQuantidade = notasFiscalProdutos_ValorQuantidade;
    }
}