/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioEndereco;
import projeto.modelo.repositorio.RepositorioEndereco;
import projeto.modelo.to.Endereco;

/**
 * @author DANIEL VALENÇA R.143
 */
public class NegocioEndereco {

    private IRepositorioEndereco rep;

    public NegocioEndereco() {
        rep = new RepositorioEndereco();
    }

    public void salvar(Endereco end) throws GeralException {

        if ((end.getEnderecos_CEP() == null) || (end.getEnderecos_CEP().equals(""))) {
            throw new GeralException("Digite um CEP!");
        }

        if ((end.getEnderecos_Logradouro() == null) || (end.getEnderecos_Logradouro().equals(""))) {
            throw new GeralException("Digite um Logradouro!");
        }

        if (end.getCidades_Codigo() <= 0) {
            throw new GeralException("Digite um código válido!");
        }

        try {
            Endereco cepConsult = rep.consultarCep(end.getEnderecos_CEP());
            if (cepConsult == null) {
                rep.salvar(end);
            } else {
                throw new GeralException("Endereço já está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public Endereco consultarCep(String enderecos_Cep) throws GeralException {
        Endereco end = null;
        if (enderecos_Cep == null) {
            throw new GeralException("Digite um endereço!");
        }

        try {
            end = rep.consultarCep(enderecos_Cep);
            if (end == null) {
                throw new GeralException("Endereço não está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return end;
    }

    public Endereco consultarLogradouro(String enderecos_Logradouro) throws GeralException {
        Endereco end = null;
        if (enderecos_Logradouro == null) {
            throw new GeralException("Digite um endereço!");
        }

        try {
            end = rep.consultarLogradouro(enderecos_Logradouro);
            if (end == null) {
                throw new GeralException("Endereço não está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return end;
    }

    public void excluir(String enderecos_Cep) throws GeralException {
        if (enderecos_Cep == null) {
            throw new GeralException("Digite o CEP!");
        }

        try {
            Endereco end = rep.consultarCep(enderecos_Cep);
            if (end == null) {
                throw new GeralException("Endereço não está cadastrado!");
            }
            rep.excluir(enderecos_Cep);

        } catch (RepositorioException ex) {
            throw new GeralException("Registro não pode ser excluído!\nMotivo: Existem um ou mais cadastros vinculados a este endereço.");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public void alterar(Endereco end) throws GeralException {

        if ((end.getEnderecos_CEP() == null) || (end.getEnderecos_CEP().equals(""))) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }

        try {
            Endereco endConsul = rep.consultarCep(end.getEnderecos_CEP());
            if (endConsul == null) {
                rep.alterar(end);
            } else {
                throw new GeralException("Endereço não está cadastrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public Collection<Endereco> listar() throws GeralException {

        ArrayList<Endereco> lista;

        /*if (enderecos_Cep == null) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }*/

        try {
            lista = (ArrayList<Endereco>) new RepositorioEndereco().listar();

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
}