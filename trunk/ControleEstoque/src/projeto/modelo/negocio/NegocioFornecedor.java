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
import projeto.gui.GuiFornecedor;
import projeto.gui.GuiFornecedorNovo;
import projeto.modelo.repositorio.IRepositorioEndereco;
import projeto.modelo.repositorio.IRepositorioFornecedor;
import projeto.modelo.repositorio.RepositorioEndereco;
import projeto.modelo.repositorio.RepositorioFornecedor;
import projeto.modelo.to.Endereco;
import projeto.modelo.to.Fornecedor;

/**
 * @author Daniel
 */
public class NegocioFornecedor {

    private IRepositorioFornecedor repFor;
    private IRepositorioEndereco repEnd;

    public NegocioFornecedor() {
        repFor = new RepositorioFornecedor();
        repEnd = new RepositorioEndereco();
    }

    public void salvar(Fornecedor f) throws GeralException {
        int resposta;
        int resComCadastro;
        Fornecedor cnpjConsult;
        Endereco end;
        int fornecedores_Codigo = 0;
        String fornecedores_CNPJ;
        String enderecos_CEP;
        String str_cep;
        String str_cnpj;
        //Trata o CNPJ para salvar;
        str_cnpj = f.getFornecedores_CNPJ();
        str_cnpj = str_cnpj.replace('.', ' ');
        str_cnpj = str_cnpj.replace('/', ' ');
        str_cnpj = str_cnpj.replace('-', ' ');
        str_cnpj = str_cnpj.replaceAll(" ", "");
        fornecedores_CNPJ = str_cnpj;
        //Trata o CEP para salvar;
        str_cep = f.getEnderecos_CEP();
        str_cep = str_cep.replace('-', ' ');
        str_cep = str_cep.replaceAll(" ", "");
        enderecos_CEP = str_cep;
        
        if ((f.getFornecedores_RazaoSocial() == null) || (f.getFornecedores_RazaoSocial().equals(""))) {
            JOptionPane.showMessageDialog(null, "Informe a Razão Social");
            GuiFornecedorNovo.jTextFieldEntradaRS.requestFocus();
        }
        if ((enderecos_CEP == null) || (enderecos_CEP.equals(""))){
            JOptionPane.showMessageDialog(null, "Informe o CEP");
            GuiFornecedorNovo.jFormattedTextFieldEntradaCEP.requestFocus();
        }
        if ((f.getEnderecos_Logradouro() == null) || (f.getEnderecos_Logradouro().equals(""))){
            JOptionPane.showMessageDialog(null, "Informe o Logradouro");
            GuiFornecedorNovo.jTextFieldEntradaLog.requestFocus();
        }
        if (((f.getFornecedores_RazaoSocial() == null) || (f.getFornecedores_RazaoSocial().equals(""))) || ((enderecos_CEP == null) || (enderecos_CEP.equals(""))) || ((f.getEnderecos_Logradouro() == null) || (f.getEnderecos_Logradouro().equals("")))){
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
            GuiFornecedorNovo guiFornecedorNovo = new GuiFornecedorNovo();
            GuiFornecedorNovo.jFormattedTextFieldEntradaCNPJ.setText(fornecedores_CNPJ);
            GuiFornecedorNovo.jTextFieldEntradaRS.setText(f.getFornecedores_RazaoSocial());
            GuiFornecedorNovo.jFormattedTextFieldEntradaCEP.setText(enderecos_CEP);
            GuiFornecedorNovo.jTextFieldEntradaLog.setText(f.getEnderecos_Logradouro());
            GuiFornecedorNovo.jTextFieldEntradaNumero.setText(String.valueOf(f.getFornecedores_NumeroResidencia()));
            GuiFornecedorNovo.jTextFieldCidade.setText(f.getCidades_Nome());
            GuiFornecedorNovo.liberarTela();
            guiFornecedorNovo.setVisible(true);
        } else {
            try {
                cnpjConsult = repFor.consultarCNPJ(fornecedores_CNPJ);
                if (cnpjConsult == null) {
                    end = repEnd.consultarCep(enderecos_CEP);
                    f.setFornecedores_Codigo(fornecedores_Codigo);
                    f.setFornecedores_CNPJ(fornecedores_CNPJ);
                    f.setFornecedores_RazaoSocial(f.getFornecedores_RazaoSocial());
                    f.setFornecedores_NumeroResidencia(f.getFornecedores_NumeroResidencia());
                    f.setEnderecos_Codigo(end.getEnderecos_Codigo());
                    repFor.salvar(f);
                    resposta = JOptionPane.showConfirmDialog(null, "Registro salvo com sucesso! Deseja salvar outro?", "", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION){
                        GuiFornecedorNovo guiFornecedorNovo = new GuiFornecedorNovo();
                        guiFornecedorNovo.setVisible(true);
                    } else {
                        GuiFornecedor guiFornecedor = new GuiFornecedor();
                        guiFornecedor.setVisible(true);
                    }
                } else {
                    resComCadastro = JOptionPane.showConfirmDialog(null, "Fornecedor já está cadastrado!\nDeseja cadastrar outro?", "", JOptionPane.YES_NO_OPTION);
                    if(resComCadastro == JOptionPane.YES_OPTION){
                        GuiFornecedorNovo guiFornecedorNovo = new GuiFornecedorNovo();
                        guiFornecedorNovo.setVisible(true);
                    }else{
                        GuiFornecedor guiFornecedor = new GuiFornecedor();
                        guiFornecedor.setVisible(true);
                    }
                }

            } catch (RepositorioException e) {
                throw new GeralException("Erro de programação!");

            } catch (ConexaoException e) {
                throw new GeralException("O banco de dados não está acessível no momento");
            }
        }
    }

    public Fornecedor consultarCNPJ(String fornecedores_CNPJ) throws GeralException {
        Fornecedor f = null;
        
        try {
            f = repFor.consultarCNPJ(fornecedores_CNPJ);            
        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return f;
    }

    public Fornecedor consultarRazaoSocial(String fornecedores_RazaoSocial) throws GeralException {
        Fornecedor f = null;
        try {
            f = repFor.consultarRazaoSocial(fornecedores_RazaoSocial);
            if (f == null) {
                JOptionPane.showMessageDialog(null, "Fornecedor não está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return f;
    }

    public void alterar(Fornecedor f) throws GeralException {

        if ((f.getFornecedores_CNPJ() == null) || (f.getFornecedores_CNPJ().equals(""))) {
            throw new GeralException("Digite o nome CNPJ!");
        }

        try {
            Fornecedor fConsult = repFor.consultarCNPJ(f.getFornecedores_CNPJ());
            if (fConsult != null) {
                repFor.alterar(f);
            } else {
                throw new GeralException("Fornecedor não está cadastrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public void excluir(String fornecedores_CNPJ) throws GeralException {
        if (fornecedores_CNPJ == null) {
            throw new GeralException("Digite o CNPJ!");
        }

        try {
            Fornecedor f = repFor.consultarCNPJ(fornecedores_CNPJ);
            if (f == null) {
                throw new GeralException("Fornecedor não está cadastrado!");
            }
            repFor.excluir(fornecedores_CNPJ);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public Collection<Fornecedor> listar() throws GeralException {

        ArrayList<Fornecedor> lista;
        
        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listar();

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public Collection<Fornecedor> listarForCNPJ(String fornecedores_CNPJ) throws GeralException {

        ArrayList<Fornecedor> lista;
        
        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listarForCNPJ(fornecedores_CNPJ);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public Collection<Fornecedor> listarForRazaoSocial(String fornecedores_RazaoSocial) throws GeralException {

        ArrayList<Fornecedor> lista;
        
        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listarForRazaoSocial(fornecedores_RazaoSocial);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public Collection<Fornecedor> listarForCEP(String enderecos_CEP) throws GeralException {

        ArrayList<Fornecedor> lista;
        
        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listarForCEP(enderecos_CEP);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public Collection<Fornecedor> listarForLog(String enderecos_Logradouro) throws GeralException {

        ArrayList<Fornecedor> lista;
        
        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listarForLog(enderecos_Logradouro);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public Collection<Fornecedor> listarForCidade(String cidades_Nome) throws GeralException {

        ArrayList<Fornecedor> lista;
        
        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listarForCidade(cidades_Nome);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }

    /**
     * Método para Validação de CNPJ
     *
     * @param str_cnpj
     * @return
     */
    public boolean validaCNPJ(String str_cnpj) {
        if (!str_cnpj.substring(0, 1).equals("")) {
            try {
                int soma = 0, dig;
                String cnpj_calc = str_cnpj.substring(0, 12);

                if (str_cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = str_cnpj.toCharArray();
                // Primeira parte  
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11)
                        ? "0" : Integer.toString(dig);
                // Segunda parte  
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11)
                        ? "0" : Integer.toString(dig);
                return str_cnpj.equals(cnpj_calc);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }
}