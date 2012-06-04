/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioFormaPagamento;
import projeto.modelo.repositorio.RepositorioFormaPagamento;
import projeto.modelo.to.FormaPagamento;

/**
 * @author Bruno Pinheiro
 *
 */
public class NegocioFormaPagamento {

    private IRepositorioFormaPagamento rep;

    /**
     * Contrutor inicializa o atributo "rep" responsável pela camada de acesso a
     * dados
     */
    public NegocioFormaPagamento() {
        rep = new RepositorioFormaPagamento();
    }

    /**
     * Verificar os dados antes de salvar este método usa Exceptions para
     * transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void salvar(FormaPagamento fp) throws GeralException {
        //validação dos campos no próprio método

        if (fp.getFormaPagamento_Codigo() <= 0) {
            throw new GeralException("Forma de pagamento não informada!");
        }

        if (fp.getFormaPagamento_Descricao() == null) {
            throw new GeralException("Descrição não informada!");
        }

        try {

            FormaPagamento mconsul = rep.consultarFormaPagamento(fp.getFormaPagamento_Descricao());
            if (mconsul != null) {
                throw new GeralException("Forma de pagamento já cadastrada!");
            }

            rep.salvar(fp);
            throw new GeralException("Forma de pagamento salva com sucesso!");
        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verifica os dados antes de consultar a String Descricao
     */
    public FormaPagamento consultarFormaPagamento(String FormaPagamento_Descricao) throws GeralException {
        FormaPagamento fp = null;

        if (FormaPagamento_Descricao == null) {
            throw new GeralException("Descrição da Forma de Pagamento não informada");
        }

        try {
            fp = rep.consultarFormaPagamento(FormaPagamento_Descricao);

            if (fp == null) {
                throw new GeralException("Forma de pagamento não encontrada!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return fp;
    }

    /**
     * Verifica os dados antes de consultar a String Codigo
     */
    public FormaPagamento consultarFormaPagamento(int FormaPagamento_Codigo) throws GeralException {
        FormaPagamento fp = null;

        if (FormaPagamento_Codigo <= 0) {
            throw new GeralException("Codigo da Forma de Pagamento não informado");
        }

        try {
            fp = rep.consultarFormaPagamento(FormaPagamento_Codigo);

            if (fp == null) {
                throw new GeralException("Forma de Pagamento não encontrada!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return fp;
    }

    /**
     * Verificar os dados antes de excluir a Forma de Pagamento este método usa
     * Exceptions para transmitir mensagens entre as camadas do sistema (negocio
     * -> apresentação)
     */
    public void excluir(int FormaPagamento_Codigo) throws GeralException {

        //verificar se a marca do produto foi informado
        if (FormaPagamento_Codigo <= 0) {
            throw new GeralException("Fora de Pagamento não foi selecionada para ser deletada!");
        }

        try {

            FormaPagamento fp = rep.consultarFormaPagamento(FormaPagamento_Codigo);
            if (fp == null) {
                throw new GeralException("Forma de Pagamento não existe!");
            }

            rep.excluir(FormaPagamento_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de Aletar a Forma de Pagamento
     *
     * @param p
     * @throws GeralException
     */
    public void alterar(FormaPagamento fp) throws GeralException {
        //validação dos campos no próprio método

        //validação da seleção da Forma de Pagamento do produto
        if (fp.getFormaPagamento_Codigo() <= 0) {
            throw new GeralException("Forma de Pagamento não informada!");
        }

        //validação da descricao
        if (fp.getFormaPagamento_Descricao() == null) {
            throw new GeralException("Forma de Pagamento da Descrição não informada!");
        }

        try {

            FormaPagamento fpconsul = rep.consultarFormaPagamento(fp.getFormaPagamento_Codigo());
            if (fpconsul == null) {
                throw new GeralException("Forma de Pagamento não existe!");
            }

            rep.alterar(fp);

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo de errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

        /**
     * Verificar os dados antes de consultar a lista
     */
    public Collection<FormaPagamento> listarFormasPagamentos() throws GeralException {

        ArrayList<FormaPagamento> lista;
        try {
            lista = (ArrayList<FormaPagamento>) new RepositorioFormaPagamento().listarFormasPagamentos();

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    /**
     * Verificar os dados antes de consultar a lista
     */
    public Collection<FormaPagamento> listarFormaPagamentoDescricao(String formaPagamento_Descricao)throws GeralException{
       ArrayList<FormaPagamento> lista;
        try {
            lista = (ArrayList<FormaPagamento>) new RepositorioFormaPagamento().listarFormasPagamentosDescricao(formaPagamento_Descricao);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public int CodigoFormaPagamento()throws GeralException{
		int m = 0;
		try {
			m = rep.CodigoFormaPagamento();
		} catch (ConexaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return m;
	 }
}