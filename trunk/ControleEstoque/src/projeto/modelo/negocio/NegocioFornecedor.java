/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioFornecedor;
import projeto.modelo.repositorio.RepositorioFornecedor;
import projeto.modelo.to.Fornecedor;

/**
 * @author Daniel
 */
public class NegocioFornecedor {

    private IRepositorioFornecedor rep;

    public NegocioFornecedor() {
        rep = new RepositorioFornecedor();
    }

    public void salvar(Fornecedor f) throws GeralException {
        boolean cnpj = validaCNPJ(f.getFornecedores_CNPJ());

        if (cnpj == false) {
            throw new GeralException("CNPJ inválido!");
        }

        if ((f.getFornecedores_CNPJ() == null) || (f.getFornecedores_CNPJ().equals(""))) {
            throw new GeralException("Digite um CNPJ!");
        }

        if ((f.getFornecedores_RazaoSocial() == null) || (f.getFornecedores_RazaoSocial().equals(""))) {
            throw new GeralException("Digite a Razão Social!");
        }

        if (f.getEnderecos_Codigo() <= 0) {
            throw new GeralException("Digite um código válido!");
        }

        if (f.getFornecedores_NumeroResidencia() <= 0) {
            throw new GeralException("Digite um número válido!");
        }

        try {
            Fornecedor cnpjConsult = rep.consultarCNPJ(f.getFornecedores_CNPJ());
            if (cnpjConsult == null) {
                rep.salvar(f);
            } else {
                throw new GeralException("Fornecedor já está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public Fornecedor consultarCNPJ(String fornecedores_CNPJ) throws GeralException {
        Fornecedor f = null;
        if (fornecedores_CNPJ == null) {
            throw new GeralException("Digite um CNPJ!");
        }

        try {
            f = rep.consultarCNPJ(fornecedores_CNPJ);
            if (f == null) {
                throw new GeralException("Fornecedor não está cadastrado!");
            }

        } catch (RepositorioException e) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException e) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return f;
    }

    public Fornecedor consultarRazaoSocial(String fornecedores_RazaoSocial) throws GeralException {
        Fornecedor f = null;
        if (fornecedores_RazaoSocial == null) {
            throw new GeralException("Digite um CNPJ!");
        }

        try {
            f = rep.consultarRazaoSocial(fornecedores_RazaoSocial);
            if (f == null) {
                throw new GeralException("Fornecedor não está cadastrado!");
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
            Fornecedor fConsult = rep.consultarCNPJ(f.getFornecedores_CNPJ());
            if (fConsult == null) {
                rep.alterar(f);
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
            Fornecedor f = rep.consultarCNPJ(fornecedores_CNPJ);
            if (f == null) {
                throw new GeralException("Fornecedor não está cadastrado!");
            }
            rep.excluir(fornecedores_CNPJ);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
    }

    public Collection<Fornecedor> listar(String fornecedores_CNPJ) throws GeralException {

        ArrayList<Fornecedor> lista;

        if (fornecedores_CNPJ == null) {
            throw new GeralException("Digite o CNPJ!");
        }

        try {
            lista = (ArrayList<Fornecedor>) new RepositorioFornecedor().listar(fornecedores_CNPJ);

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
                str_cnpj = str_cnpj.replace('.', ' ');
                str_cnpj = str_cnpj.replace('/', ' ');
                str_cnpj = str_cnpj.replace('-', ' ');
                str_cnpj = str_cnpj.replaceAll(" ", "");
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