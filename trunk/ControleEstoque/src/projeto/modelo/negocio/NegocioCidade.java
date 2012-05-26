/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioCidade;
import projeto.modelo.repositorio.RepositorioCidade;
import projeto.modelo.to.Cidade;

/**
 * @author DANIEL VALENÇA
 *
 */
public class NegocioCidade {

    private IRepositorioCidade rep;

    /**
     * Construtor inicializa o atributo "rep", responsável pela camada de Acesso
     * a Dados;
     */
    public NegocioCidade() {
        rep = new RepositorioCidade();
    }

    /**
     * Verifica e valida os dados antes de salvar
     *
     * @param cd Cidade
     * @throws GeralException
     */
    public void salvar(Cidade cd) throws GeralException {

        if ((cd.getCidades_Nome() == null) || (cd.getCidades_Nome().equals(""))) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }

        /*
         * validação dos campos pelo objeto e retorna o campo com problema
         */
        String campo = cd.getValidoString();
        if (campo != null) {
            throw new GeralException(campo + " inválido");
        }

        /*
         * validação dos campos pelo objeto e retorna true/false
         */
        if (cd.isValido()) {
            throw new GeralException("inválido");
        }

        try {
            Cidade cdConsult = rep.consultar(cd.getCidades_Nome());
            if (cdConsult != null) {
                throw new GeralException("Cidade já está cadastrada!");
            }
            rep.salvar(cd);
            throw new GeralException("Registro foi salvo com sucesso!");
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    /**
     * Método para efetuar uma consulta pelo nome da cidade informada
     *
     * @param cidade_Nome
     * @return Cidade cd
     * @throws GeralException
     */
    public Cidade consultar(String cidades_Nome) throws GeralException {
        Cidade cd = null;
        if ((cidades_Nome == null) || (cidades_Nome.equals(""))) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }
        try {
            cd = rep.consultar(cidades_Nome);
            if (cd == null) {
                throw new GeralException("Cidade não está cadastrada!");
            }
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return cd;
    }

    /**
     * Método para efetuar uma consulta pelo código de uma cidade
     *
     * @param cidade_Codigo
     * @return Cidade cd
     * @throws GeralException
     */
    public Cidade consultar(int cidades_Codigo) throws GeralException {
        Cidade cd = null;
        if (cidades_Codigo <= 0) {
            throw new GeralException("Digite um códido válido!");
        }
        try {
            cd = rep.consultar(cidades_Codigo);
            if (cd == null) {
                throw new GeralException("Cidade não está cadastrada!");
            }
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return cd;
    }

    /**
     * Valida o código da cidade antes de efetuar a exclusão.
     *
     * @param cidade_Codigo
     * @return
     */
    public void excluir(int cidades_Codigo) throws GeralException {
        if (cidades_Codigo <= 0) {
            throw new GeralException("Digite um códido válido!");
        }
        try {
            Cidade cd = rep.consultar(cidades_Codigo);
            if (cd == null) {
                throw new GeralException("Cidade não está cadastrada!");
            }
            rep.excluir(cidades_Codigo);
        } catch (RepositorioException ex) {
            throw new GeralException("Registro não pode ser excluído!\nMotivo: Existem um ou mais endereços cadastrados para esta cidade.");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public void excluir(String cidades_Nome) throws GeralException {
        if ((cidades_Nome == null) || (cidades_Nome.equals(""))) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }
        try {
            Cidade cd = rep.consultar(cidades_Nome);
            if (cd == null) {
                throw new GeralException("Cidade não está cadastrada!");
            }

            rep.excluir(cidades_Nome);

        } catch (RepositorioException ex) {
            throw new GeralException("Registro não pode ser excluído!\nMotivo: Existem um ou mais endereços cadastrados para esta cidade.");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    /**
     * Método para alterar um registro a partir de seu código informado.
     *
     * @param cd Cidade
     * @throws GeralException
     */
    public void alterar(Cidade cd) throws GeralException {

        if (cd.getCidades_Codigo() <= 0) {
            throw new GeralException("Digite um códido válido!");
        }

        if ((cd.getCidades_Nome() == null) || (cd.getCidades_Nome().equals(""))) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }

        try {
            Cidade cdConsul = rep.consultar(cd.getCidades_Codigo());
            if (cdConsul == null) {
                throw new GeralException("Cidade não está cadastrada!");
            }

            rep.alterar(cd);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public Collection<Cidade> listar(String cidades_Nome) throws GeralException {

        ArrayList<Cidade> lista;

       /* if (cidades_Nome == null) {
            throw new GeralException("Digite o nome ou o códido da cidade!");
        }*/
        try {
            lista = (ArrayList<Cidade>) new RepositorioCidade().listar();

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
}