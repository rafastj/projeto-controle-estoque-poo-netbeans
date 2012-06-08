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
import projeto.modelo.repositorio.IRepositorioNotaFiscal;
import projeto.modelo.repositorio.RepositorioNotaFiscal;
import projeto.modelo.to.NotaFiscal;

/**
 * @author Thiago Evoa
 *
 */
public class NegocioNotaFiscal {

    private IRepositorioNotaFiscal rep;

    /**
     * Construtor inicializa o atributo "rep", responsável pela camada de Acesso
     * a Dados;
     */
    public NegocioNotaFiscal() {
        rep = new RepositorioNotaFiscal();
    }

    /**
     * Verifica e valida os dados antes de salvar
     *
     * @param nf Nota Fiscal
     * @throws GeralException
     */
    public void salvar(NotaFiscal nf) throws GeralException {

        if (nf.getClientes_Codigo() <= 0) {
            throw new GeralException("Informe o CPF ou CNPJ do cliente!");
        }
        if (nf.getFuncionarios_Codigo() <= 0) {
            throw new GeralException("Digite o código do Funcionário!");
        }
        if (nf.getFormasPagamento_Codigo() <= 0) {
            throw new GeralException("Digite o código da forma de pagamento!");
        }
        try {
            NotaFiscal nfconsult = rep.consultar(nf.getNotasFiscal_Numero());
            if (nfconsult != null) {
                throw new GeralException("Nota fiscal já está cadastrada!");
            }
            rep.salvar(nf);
            throw new GeralException("Registro foi salvo com sucesso!");
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("Banco de dados inacessível!!!");
        }
    }

    /**
     * Método para efetuar uma consulta pelo codigo do funcionario informada
     *
     * @param Funcionarios_Codigo
     * @return Usuario us
     * @throws GeralException
     */
    public NotaFiscal consultar(int notasFiscal_Numero) throws GeralException {
        NotaFiscal nf = null;
        if (notasFiscal_Numero <= 0) {
            throw new GeralException("Digite o número da nota fiscal!");
        }
        try {
            nf = rep.consultar(notasFiscal_Numero);
            if (nf == null) {
                throw new GeralException("Nota Fiscal não está cadastrada!");
            }
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return nf;
    }

    /**
     * Método para alterar um registro a partir de seu código informado.
     *
     * @param fu Funcionario
     * @throws GeralException
     */
    public void alterar(NotaFiscal nf) throws GeralException {

        if (nf.getClientes_Codigo() <= 0) {
            throw new GeralException("Não foi informado o CPF ou CNPJ do cliente");
        }
        if (nf.getFuncionarios_Codigo() <= 0) {
            throw new GeralException("Não foi informado o Funcionário!");
        }
        if (nf.getFormasPagamento_Codigo() <= 0) {
            throw new GeralException("Não foi informado a Forma de Pagamento!");
        }
        if (nf.getNotasFiscal_Numero() <= 0) {
            throw new GeralException("Não foi informado a Nota Fiscal!");
        }
        

        try {
            NotaFiscal nfConsul = rep.consultar(nf.getNotasFiscal_Numero());
            if (nfConsul == null) {
                throw new GeralException("Nota Fiscal não está cadastrada!");
            }

            rep.alterar(nf);
            
            JOptionPane.showMessageDialog(null, "Nota Fiscal Alterada!");

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Valida o código da cidade antes de efetuar a exclusão.
     *
     * @param funcinarios_Codigo
     * @return
     */
    public void cancelar(int notasFiscal_Numero) throws GeralException {
        if (notasFiscal_Numero <= 0) {
            throw new GeralException("Digite um número de nota fiscal válida!");
        }
        try {
            NotaFiscal nf = rep.consultar(notasFiscal_Numero);
            if (nf == null) {
                throw new GeralException("Nota fiscal não está cadastrada!");
            }

            rep.cancelar(notasFiscal_Numero);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    public Collection<NotaFiscal> listar(int notasFiscal_Numero) throws GeralException {

        ArrayList<NotaFiscal> lista;

        if (notasFiscal_Numero <= 0) {
            throw new GeralException("Digite o número da nota fiscal!");
        }
        try {
            lista = (ArrayList<NotaFiscal>) new RepositorioNotaFiscal().listar(notasFiscal_Numero);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
    
   
     public NotaFiscal consultarUltimaNotaCliente(int clientes_Codigo) throws GeralException {
        
          NotaFiscal nf = null;
        if (clientes_Codigo <= 0) {
            throw new GeralException("Digite o número da nota fiscal!");
        }
        try {
            nf = rep.consultarUltimaNota(clientes_Codigo);
            if (nf == null) {
                throw new GeralException("Nota Fiscal não está cadastrada!");
            }
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return nf;         
    }
    
    
//FIM    
}