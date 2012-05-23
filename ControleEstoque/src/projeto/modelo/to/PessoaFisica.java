/**
 *
 */
package projeto.modelo.to;

/**
 * @author Sandro
 *
 */
public class PessoaFisica extends Cliente {

    private String pessoasFisica_Nome;
    private String pessoasFisica_CPF;
    private String pessoasFisica_Sexo;

    public PessoaFisica() {
    }

    public PessoaFisica(int enderecos_codigo, String clientes_NumeroResidencia, String clientes_Tipo, String pessoaFisica_Nome, String pessoasFisica_CPF, String pessoasFisica_Sexo) {
        this.pessoasFisica_CPF = pessoasFisica_CPF;
        this.pessoasFisica_Sexo = pessoasFisica_Sexo;
        this.pessoasFisica_Nome = pessoaFisica_Nome;
        this.setEnderecos_Codigo(enderecos_codigo);
        this.setClientes_NumeroResidencia(clientes_NumeroResidencia);
        this.setClientes_Tipo(clientes_Tipo);
    }

    public String getPessoasFisica_Nome() {
        return pessoasFisica_Nome;
    }

    public void setPessoasFisica_Nome(String pessoasFisica_Nome) {
        this.pessoasFisica_Nome = pessoasFisica_Nome;
    }

    public String getPessoasFisica_CPF() {
        return pessoasFisica_CPF;
    }

    public void setPessoasFisica_CPF(String pessoasFisica_CPF) {
        this.pessoasFisica_CPF = pessoasFisica_CPF;
    }

    public String getPessoasFisica_Sexo() {
        return pessoasFisica_Sexo;
    }

    public void setPessoasFisica_Sexo(String pessoasFisica_Sexo) {
        this.pessoasFisica_Sexo = pessoasFisica_Sexo;
    }
}