/**
 *
 */
package projeto.modelo.to;

/**
 * @author DANIEL VALENÇA
 */
public class Endereco {

    private int enderecos_Codigo;
    private String enderecos_CEP;
    private String enderecos_Logradouro;
    private int cidades_Codigo;
    private Cidade cidade = new Cidade();

    public Endereco() {
    }

    public Endereco(int enderecos_Codigo, String enderecos_CEP, String enderecos_Logradouro, int cidades_Codigo, String cidades_Nome) {
        this.enderecos_Codigo = enderecos_Codigo;
        this.enderecos_CEP = enderecos_CEP;
        this.enderecos_Logradouro = enderecos_Logradouro;
        this.cidades_Codigo = cidades_Codigo;
    }

    public int getEnderecos_Codigo() {
        return enderecos_Codigo;
    }

    public void setEnderecos_Codigo(int enderecos_Codigo) {
        this.enderecos_Codigo = enderecos_Codigo;
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

    public int getCidades_Codigo() {
        return cidades_Codigo;
    }

    public void setCidades_Codigo(int cidades_Codigo) {
        this.cidades_Codigo = cidades_Codigo;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}