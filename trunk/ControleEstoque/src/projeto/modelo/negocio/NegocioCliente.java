/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioCliente;
import projeto.modelo.repositorio.RepositorioCliente;
import projeto.modelo.repositorio.RepositorioProduto;
import projeto.modelo.to.*;
import projeto.modelo.to.PessoaJuridica;
import projeto.modelo.to.Produto;
import projeto.validaCampo.ValidaCampo;

/**
 * @author Sandro
 *
 */
public class NegocioCliente {

    private IRepositorioCliente rep;

    public NegocioCliente() {
        rep = new RepositorioCliente();
    }

    public void salvar(PessoaFisica pf) throws GeralException {
        boolean cpf = ValidaCampo.ValidaCPF(pf.getPessoasFisica_CPF());
        if (cpf == false) {
            throw new GeralException("CPF Inválido!");
        }

        if (pf.getClientes_NumeroResidencia() == null) {
            throw new GeralException("Digite o numero da residencia!");
        }

        if (pf.getPessoasFisica_Nome() == null) {
            throw new GeralException("Digite o Nome de Cliente!");
        }

        try {
            /*
             * PessoaFisica pfConsult =
             * rep.consultarPF(pf.getPessoasFisica_CPF()); if( pfConsult != null
             * ){ throw new GeralException("Cliente já está cadastrado!");
			}
             */
            rep.salvar(pf);
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("Banco de dados inacessível!!!");
        }
    }

    public void salvar(PessoaJuridica pj) throws GeralException {
        /*
         * boolean cnpj=ValidaCNPJ(pj.getPessoasJuridica_CNPJ()); if(cnpj ==
         * false) { throw new GeralException("CNPJ Inválido!");
	}
         */

        if (pj.getClientes_NumeroResidencia() == null) {
            throw new GeralException("Digite o numero da residencia!");
        }

        if (pj.getPessoasJuridica_RazaoSocial() == null) {
            throw new GeralException("Digite a Razão Social do Cliente!");
        }

        try {
            //PessoaJuridica pjConsult = rep.consultarPJ(pj.getPessoasJuridica_CNPJ());
		/*
             * if( pjConsult != null ){ throw new GeralException("Cliente já
             * está cadastrado!");
		}
             */
            rep.salvar(pj);
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");
        } catch (ConexaoException e) {
            throw new GeralException("Banco de dados inacessível!!!");
        }
    }

    public PessoaFisica consultarPF_Nome(String pessoafisica_Nome) throws GeralException {
        PessoaFisica pf = null;
        if (pessoafisica_Nome == null) {
            throw new GeralException("Digite um CNPJ!");
        }

        try {
            pf = rep.consultarPF_Nome(pessoafisica_Nome);
            if (pf == null) {
                throw new GeralException("Fornecedor não está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return pf;
    }
    
       public Collection<PessoaFisica> listarPessoaFisica() throws GeralException, ConexaoException {

        ArrayList<PessoaFisica> lista = null;
        try {
            lista = (ArrayList<PessoaFisica>) new RepositorioCliente().listarPessoaFisica();
        } catch (RepositorioException ex) {
            Logger.getLogger(NegocioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
       
       public Collection<PessoaJuridica> listarPessoaJuridica() throws ConexaoException{
           
        ArrayList<PessoaJuridica> lista = null;
        try {
            lista = (ArrayList<PessoaJuridica>) new RepositorioCliente().listarPessoaJuridica();
        } catch (RepositorioException ex) {
            Logger.getLogger(NegocioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
       }
       
       public Collection<Cliente> listarTodosCliente() throws ConexaoException{
           
        ArrayList<Cliente> lista = null;
        try {
            lista = (ArrayList<Cliente>) new RepositorioCliente().listarTodosCliente();
        } catch (RepositorioException ex) {
            Logger.getLogger(NegocioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
       }

        public void excluirCliente(Cliente cli) throws GeralException {
        /*if (codigo < 1) {
            throw new GeralException("Digite o CEP!");
        }*/
        String tipo = cli.getClientes_Tipo();
        int codigo = cli.getClientes_Codigo();
        try {
            boolean verificaCliente = rep.consultarCliente(codigo);
            if (verificaCliente == false) {
                throw new GeralException("Cliente nÃ£o existe");
            }
            if (("f".equals(tipo)) || ("F".equals(tipo))){
                rep.excluirPF(codigo);
            }
            else{
                rep.excluirPJ(codigo);
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Registro nÃ£o pode ser excluÃ­do!\nMotivo: Existem um ou mais cadastros vinculados a este endereÃ§o.");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados nÃ£o estÃ¡ acessÃ­vel no momento");
        }
            
    }

}