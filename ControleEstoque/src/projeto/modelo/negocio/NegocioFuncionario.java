/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioFuncionario;
import projeto.modelo.repositorio.RepositorioFuncionario;
import projeto.modelo.to.Funcionario;

/**
 * @author Thiago Evoa
 *
 */
public class NegocioFuncionario {

    private IRepositorioFuncionario rep;

    /**
     * Construtor inicializa o atributo "rep", responsável pela camada de Acesso
     * a Dados;
     */
    public NegocioFuncionario() {
        rep = new RepositorioFuncionario();
    }

    /**
     * Verifica e valida os dados antes de salvar
     *
     * @param fu Funcionario
     * @throws GeralException
     */
    public void salvar(Funcionario fu) throws GeralException {

        if (fu.getFuncionarios_Codigo() <= 0) {
            throw new GeralException("Digite o código do funcionário!");
        }
        if (fu.getEnderecos() == null) {
            throw new GeralException("Informe o código do endereço!");
        }
        if (fu.getFuncionarios_Nome() == null) {
            throw new GeralException("Informe o nome!");
        }
        if (fu.getFuncionarios_NumeroResidencia() == null) {
            throw new GeralException("Informe o número da residencia!");
        }
        try {
            Funcionario fuconsult = rep.consultar(fu.getFuncionarios_Codigo());
            if (fuconsult != null) {
                throw new GeralException("Funcionário já está cadastrado!");
            }
            rep.salvar(fu);
            throw new GeralException("Registro foi salvo com sucesso!");
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("Banco de dados inacessível!!!");
        }
    }

    /**
     * Método para efetuar uma consulta pelo codigo do funcionario
     *
     * @param Funcionarios_Codigo
     * @return Usuario us
     * @throws GeralException
     */
    public Funcionario consultar(int funcionarios_Codigo) throws GeralException {
        Funcionario fu = null;
        if (funcionarios_Codigo <= 0) {
            throw new GeralException("Digite o codigo do Funcionário!");
        }
        try {
            fu = rep.consultar(funcionarios_Codigo);
            if (fu == null) {
                throw new GeralException("Funcionário não está cadastrado!");
            }
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return fu;
    }

    /**
     * Método para efetuar uma consulta pelo nome do funcionario
     *
     * @param funcionarios_Nome
     * @return
     * @throws GeralException
     */
    public Funcionario consultar(String funcionarios_Nome) throws GeralException {
        Funcionario fu = null;
        if ((funcionarios_Nome.equals(null)) || (funcionarios_Nome.equals(""))) {
            throw new GeralException("Digite o nome do Usuário!");
        }
        try {
            fu = rep.consultar(funcionarios_Nome);
            if (fu == null) {
                throw new GeralException("Usuario não está cadastrado!");
            }
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return fu;
    }

    /**
     * Valida o código do funcionário antes de efetuar a exclusão.
     *
     * @param funcinarios_Codigo
     * @return
     */
    public void excluir(int funcionarios_Codigo) throws GeralException {
        if (funcionarios_Codigo <= 0) {
            throw new GeralException("Digite um códido válido!");
        }
        try {
            Funcionario fu = rep.consultar(funcionarios_Codigo);
            if (fu == null) {
                throw new GeralException("Funcionário não está cadastrado!");
            }

            rep.excluir(funcionarios_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Método para alterar um registro a partir de seu código informado.
     *
     * @param fu Funcionario
     * @throws GeralException
     */
    public void alterar(Funcionario fu) throws GeralException {

        if (fu.getFuncionarios_Codigo() <= 0) {
            throw new GeralException("Digite um códido válido!");
        }

        try {
            Funcionario fuConsul = rep.consultar(fu.getFuncionarios_Codigo());
            if (fuConsul == null) {
                throw new GeralException("Funcionário não está cadastrado!");
            }

            rep.alterar(fu);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Método para listar os funcinarios pelo código
     *
     * @param funcionarios_Codigo
     * @return
     * @throws GeralException
     */
    public Collection<Funcionario> listar(int funcionarios_Codigo) throws GeralException {

        ArrayList<Funcionario> lista;

        if (funcionarios_Codigo <= 0) {
            throw new GeralException("Digite o código de um funcionario!");
        }
        try {
            lista = (ArrayList<Funcionario>) new RepositorioFuncionario().listar(funcionarios_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
}