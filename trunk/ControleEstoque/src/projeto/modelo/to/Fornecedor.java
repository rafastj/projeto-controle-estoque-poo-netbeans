/**
 *
 */
package projeto.modelo.to;

/**
 * @author DANIEL VALENÇA
 */
public class Fornecedor {

    private int fornecedores_Codigo;
    private String fornecedores_CNPJ;
    private String fornecedores_RazaoSocial;
    private int fornecedores_NumeroResidencia;
    private int enderecos_Codigo;
    private Endereco endereco = new Endereco();
        
    public Fornecedor() {
    }

    public Fornecedor(int fornecedores_Codigo, String fornecedores_CNPJ, String fornecedores_RazaoSocial, int fornecedores_NumeroResidencia, int enderecos_Codigo, String enderecos_CEP, String enderecos_Logradouro, int cidades_Codigo, String cidades_Nome) {
        this.fornecedores_Codigo = fornecedores_Codigo;
        this.fornecedores_CNPJ = fornecedores_CNPJ;
        this.fornecedores_RazaoSocial = fornecedores_RazaoSocial;
        this.fornecedores_NumeroResidencia = fornecedores_NumeroResidencia;
        this.enderecos_Codigo = enderecos_Codigo;
    }

    public int getFornecedores_Codigo() {
        return fornecedores_Codigo;
    }

    public void setFornecedores_Codigo(int fornecedores_Codigo) {
        this.fornecedores_Codigo = fornecedores_Codigo;
    }

    public String getFornecedores_CNPJ() {
        return fornecedores_CNPJ;
    }

    public void setFornecedores_CNPJ(String fornecedores_CNPJ) {
        this.fornecedores_CNPJ = fornecedores_CNPJ;
    }

    public String getFornecedores_RazaoSocial() {
        return fornecedores_RazaoSocial;
    }

    public void setFornecedores_RazaoSocial(String fornecedores_RazaoSocial) {
        this.fornecedores_RazaoSocial = fornecedores_RazaoSocial;
    }

    public int getFornecedores_NumeroResidencia() {
        return fornecedores_NumeroResidencia;
    }

    public void setFornecedores_NumeroResidencia(
            int fornecedores_NumeroResidencia) {
        this.fornecedores_NumeroResidencia = fornecedores_NumeroResidencia;
    }

    public Endereco getCodigo() {
        return endereco;
    }
    
     public void setCodigo(Endereco codigo) {
        this.endereco = codigo;
    }

    public void setEndereco_Codigo(Endereco codigo) {
        this.endereco = codigo;
    }

    public void setEnderecos_Codigo(int enderecos_Codigo) {
        this.enderecos_Codigo = enderecos_Codigo;
    }

    public int getEnderecos_Codigo() {
        return enderecos_Codigo;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}