/**
 *
 */
package projeto.modelo.to;

/**
 * @author Thiago Evoa
 *
 */
public class Funcionario {

    private int funcionarios_Codigo;
    private int enderecos_Codigo;
    private Endereco enderecos = new Endereco();
    private String funcionarios_Nome;
    private String funcionarios_NumeroResidencia;

    public Funcionario() {
    }

    public Funcionario(int funcionario_Codigo, int enderecos_Codigo, String funcionarios_Nome, String funcionarios_NumeroResidencia) {
        this.setFuncionarios_Codigo(funcionario_Codigo);
        this.setEnderecos_Codigo(enderecos_Codigo);
        this.setFuncionarios_Nome(funcionarios_Nome);
        this.setFuncionarios_NumeroResidencia(funcionarios_NumeroResidencia);
    }

    public int getFuncionarios_Codigo() {
        return funcionarios_Codigo;
    }

    public void setFuncionarios_Codigo(int funcionarios_Codigo) {
        this.funcionarios_Codigo = funcionarios_Codigo;
    }

    public int getEnderecos_Codigo() {
        return enderecos_Codigo;
    }

    public void setEnderecos_Codigo(int enderecos_Codigo) {
        this.enderecos_Codigo = enderecos_Codigo;
    }

    public String getFuncionarios_Nome() {
        return funcionarios_Nome;
    }

    public void setFuncionarios_Nome(String funcionarios_Nome) {
        this.funcionarios_Nome = funcionarios_Nome;
    }

    public String getFuncionarios_NumeroResidencia() {
        return funcionarios_NumeroResidencia;
    }

    public void setFuncionarios_NumeroResidencia(
            String funcionarios_NumeroResidencia) {
        this.funcionarios_NumeroResidencia = funcionarios_NumeroResidencia;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }
}