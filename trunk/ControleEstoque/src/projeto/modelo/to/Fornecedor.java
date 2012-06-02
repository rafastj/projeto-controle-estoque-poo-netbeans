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
    private String enderecos_CEP;
    private String enderecos_Logradouro;
    private int cidades_Codigo;
    private String cidades_Nome;
    private Endereco endereco = new Endereco();
    private Cidade cidade = new Cidade();
    
    public Fornecedor() {
    }

    public Fornecedor(int fornecedores_Codigo, String fornecedores_CNPJ, String fornecedores_RazaoSocial, int fornecedores_NumeroResidencia, int enderecos_Codigo, String enderecos_CEP, String enderecos_Logradouro, int cidades_Codigo, String cidades_Nome) {
        this.fornecedores_Codigo = fornecedores_Codigo;
        this.fornecedores_CNPJ = fornecedores_CNPJ;
        this.fornecedores_RazaoSocial = fornecedores_RazaoSocial;
        this.fornecedores_NumeroResidencia = fornecedores_NumeroResidencia;
        this.enderecos_Codigo = enderecos_Codigo;
        this.enderecos_CEP = enderecos_CEP;
        this.enderecos_Logradouro = enderecos_Logradouro;
        this.cidades_Codigo = cidades_Codigo;
        this.cidades_Nome = cidades_Nome;
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
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCidades_Codigo() {
        return cidades_Codigo;
    }

    public void setCidades_Codigo(int cidades_Codigo) {
        this.cidades_Codigo = cidades_Codigo;
    }

    public String getCidades_Nome() {
        return cidades_Nome;
    }

    public void setCidades_Nome(String cidades_Nome) {
        this.cidades_Nome = cidades_Nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEnderecos_CEP() {
        return enderecos_CEP;
    }

    public void setEnderecos_CEP(String enderecos_CEP) {
        this.enderecos_CEP = enderecos_CEP;
    }

    public String getEnderecos_Logradouro() {
        return enderecos_Logradouro;
    }

    public void setEnderecos_Logradouro(String enderecos_Logradouro) {
        this.enderecos_Logradouro = enderecos_Logradouro;
    }
}