/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.gui.GuiCidade;
import projeto.gui.GuiCidadeAlterar;
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
        int resComCadastro;
        int resSemCadastro;
        if ((cd.getCidades_Nome() == null) || (cd.getCidades_Nome().equals(""))) {
            JOptionPane.showMessageDialog(null, "Digite o nome da cidade!");
            GuiCidade.limparCampos();
        } else {
            try {
                double validoString;
                validoString = Double.parseDouble(cd.getCidades_Nome());
                JOptionPane.showMessageDialog(null, "Digite apenas o nome da cidade!");
                GuiCidade.limparCampos();
            } catch (NumberFormatException x) {
                try {
                    Cidade cdConsult = rep.consultar(cd.getCidades_Nome());
                    if (cdConsult != null) {
                        resComCadastro = JOptionPane.showConfirmDialog(null, "Cidade já cadastrada!\nDeseja cadastrar outra cidade?", "", JOptionPane.YES_NO_OPTION);
                        if(resComCadastro == JOptionPane.YES_OPTION) {
                            GuiCidade.limparCampos();
                        } else {
                            throw new GeralException();
                        }
                    } else {
                        rep.salvar(cd);
                        JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
                        GuiCidade.limparCampos();
                    }
                } catch (RepositorioException e) {
                    throw new GeralException("Erro ao tentar salvar!\n Contate o suporte!");
                } catch (ConexaoException e) {
                    throw new GeralException("O banco de dados não está acessível no momento!\nContate o suporte!");
                }
            }
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
            throw new GeralException("Digite o nome da cidade!");
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
        int resComCadastro;
        if ((cd.getCidades_Nome() == null) || (cd.getCidades_Nome().equals(""))) {
            JOptionPane.showMessageDialog(null, "Digite o nome da cidade!");
            GuiCidadeAlterar.limparCampos();
        } else {
            try {
                double validoString;
                validoString = Double.parseDouble(cd.getCidades_Nome());
                JOptionPane.showMessageDialog(null, "Digite apenas o nome da cidade!");
                GuiCidadeAlterar.limparCampos();
            } catch (NumberFormatException x) {
                try {
                    Cidade cdConsult = rep.consultar(cd.getCidades_Nome());
                    if (cdConsult != null) {
                        resComCadastro = JOptionPane.showConfirmDialog(null, "Cidade já cadastrada!\nDeseja tentar outro nome de cidade?", "", JOptionPane.YES_NO_OPTION);
                        if(resComCadastro == JOptionPane.YES_OPTION) {
                            GuiCidadeAlterar.limparCampos();
                        } else {
                            throw new GeralException();
                        }
                    } else {
                        rep.alterar(cd);
                        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
                        throw new GeralException();
                    }
                } catch (RepositorioException e) {
                    throw new GeralException("Erro ao tentar alterar!\n Contate o suporte!");
                } catch (ConexaoException e) {
                    throw new GeralException("O banco de dados não está acessível no momento!\nContate o suporte!");
                }
            }
        }
    }

    public Collection<Cidade> listarTudo() throws GeralException {
        ArrayList<Cidade> lista;
        try {
            lista = (ArrayList<Cidade>) new RepositorioCidade().listarTudo();

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public Collection<Cidade> listarCidadeNome(String cidades_Nome) throws GeralException {
        ArrayList<Cidade> lista;
        if (cidades_Nome.equals("")){
            throw new GeralException("Nome da cidade não informado!");
        }
        try {
            lista = (ArrayList<Cidade>) new RepositorioCidade().listarCidadeNome(cidades_Nome);
        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
}