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
import projeto.modelo.to.Cliente;
import projeto.modelo.to.Endereco;
import projeto.modelo.to.PessoaFisica;
import projeto.modelo.to.PessoaJuridica;
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
    
    public PessoaFisica consultaPF_CPF (String cpf) throws GeralException{
        PessoaFisica pf = null;
        if (cpf.equals("")) {
            throw new GeralException("Digite um CNPJ!");
        }

        try {
            pf = rep.consultarPF(cpf);
            if (pf == null) {
                throw new GeralException("CPF não Encontrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return pf; 
    }
    
    
    public PessoaJuridica consultaPJ_CNPJ (String cnpj) throws GeralException{
        PessoaJuridica pj = null;
        if (cnpj.equals("")) {
            throw new GeralException("Digite um CNPJ!");
        }

        try {
            pj = rep.consultarPJ(cnpj);
            if (pj == null) {
                throw new GeralException("CNPJ não Encontrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return pj; 
    }
    
    public Collection<PessoaFisica> listarPessoaFisica() throws GeralException {

        ArrayList<PessoaFisica> lista = null;
        try {
            lista = (ArrayList<PessoaFisica>) new RepositorioCliente().listarPessoaFisica();
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }

        return lista;
    }
       
    public Collection<PessoaFisica> listarPfCidade(String cidade_nome) throws GeralException {

        ArrayList<PessoaFisica> lista = null;
        try {
            lista = (ArrayList<PessoaFisica>) new RepositorioCliente().listarPfCidade(cidade_nome);
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }

        return lista;
    }
       
       public Collection<PessoaJuridica> listarPessoaJuridica() throws GeralException{
           
        ArrayList<PessoaJuridica> lista = null;
        try {
            lista = (ArrayList<PessoaJuridica>) new RepositorioCliente().listarPessoaJuridica();
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }

        return lista;
       }
       
    public Collection<PessoaJuridica> listarPjCidade(String cidade_nome) throws GeralException {

        ArrayList<PessoaJuridica> lista = null;
        try {
            lista = (ArrayList<PessoaJuridica>) new RepositorioCliente().listarPjCidade(cidade_nome);
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }

        return lista;
    }

    public void excluirPessoaFisica(int codigo) throws GeralException {
        try {
            boolean verificaCliente = rep.consultarCliente(codigo);
            if (verificaCliente == false) {
                throw new GeralException("Cliente não existe");
            }
            else{
                rep.excluirPF(codigo);
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Registro não pode ser excluído!\nMotivo: Existem um ou mais cadastros vinculados a este endereÃ§o.");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados nÃ£o estÃ¡ acessÃ­vel no momento");
        }
            
    }

    public void excluirPessoaJuridica(int codigo) throws GeralException {
        try {
            boolean verificaCliente = rep.consultarCliente(codigo);
            if (verificaCliente == false) {
                throw new GeralException("Cliente não existe");
            }
            else{
                rep.excluirPJ(codigo);
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Registro não pode ser excluído!\nMotivo: Existem um ou mais cadastros vinculados a este endereÃ§o.");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados nÃ£o estÃ¡ acessÃ­vel no momento");
        }
            
    }
    
        public void cliente(PessoaFisica pf) throws GeralException {

        if ((pf.getPessoasFisica_CPF() == null) || (pf.getPessoasFisica_CPF().equals(""))) {
            throw new GeralException("Digite o CPF!");
        }

        try {
            rep.alterar(pf);
        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    
}