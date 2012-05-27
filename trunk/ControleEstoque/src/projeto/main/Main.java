package projeto.main;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.*;

/**
 * @author EQUIPE 03
 */
public class Main {

    public static Fachada fachada = new Fachada();

    /**
     * @param args
     * @throws GeralException
     */
    public static void main(String[] args) throws GeralException, ConexaoException {


        /**
         * MENU PRINCIPAL DO PROGRAMA DE TESTES!!!
         */
        menuPrincipal:
        do {
            String user = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                    + "1) Testes de Daniel\n"
                    + "2) Testes de Diego\n"
                    + "3) Testes de Sandro\n"
                    + "4) Testes de Thiago\n"
                    + "5) Testes de Felipe\n"
                    + "6) Testes de Bruno\n"
                    + "0) Sair dos testes");
            try {
                int opcaoUser = Integer.parseInt(user);

                switch (opcaoUser) {

                    case 0: // Sai do sistema
                        System.exit(0);

                    /**
                     * MENU DE TESTES DE DANIEL
                     */
                    case 1: // Testes de Daniel
                        menuTestes:
                        do {
                            String menu = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                    + "1) Teste de Salvar\n"
                                    + "2) Teste de Consultar\n"
                                    + "3) Teste de Alterar\n"
                                    + "4) Teste de Excluir\n"
                                    + "5) Teste de Listar\n"
                                    + "0) Voltar ao menu anterior");
                            try {
                                int opcaoMenu = Integer.parseInt(menu);
                                switch (opcaoMenu) {

                                    case 0:
                                        continue menuPrincipal;

                                    case 1:
                                        do {
                                            String salvar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Salvar Cidade\n"
                                                    + "2) Salvar Endereço\n"
                                                    + "3) Salvar Fornecedor\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoSalvar = Integer.parseInt(salvar);
                                                switch (opcaoSalvar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarSalvarCidade();
                                                        break;
                                                    case 2:
                                                        testarSalvarEndereco();
                                                        break;
                                                    case 3:
                                                        testarSalvarFornecedor();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 2:
                                        do {
                                            String consultar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Consultar Cidade\n"
                                                    + "2) Consultar Endereço\n"
                                                    + "3) Consultar Fornecedor\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoConsultar = Integer.parseInt(consultar);
                                                switch (opcaoConsultar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarConsultarCidade();
                                                        break;
                                                    case 2:
                                                        testarConsultarEndereco();
                                                        break;
                                                    case 3:
                                                        testarConsultarFornecedor();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 3:
                                        do {
                                            String alterar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Alterar Cidade\n"
                                                    + "2) Alterar Endereço\n"
                                                    + "3) Alterar Fornecedor\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoAlterar = Integer.parseInt(alterar);
                                                switch (opcaoAlterar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarAlterarCidade();
                                                        break;
                                                    case 2:
                                                        testarAlterarEndereco();
                                                        break;
                                                    case 3:
                                                        testarAlterarFornecedor();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 4:
                                        do {
                                            String excluir = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Excluir Cidade\n"
                                                    + "2) Excluir Endereço\n"
                                                    + "3) Excluir Fornecedor\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoExcluir = Integer.parseInt(excluir);
                                                switch (opcaoExcluir) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarExcluirCidade();
                                                        break;
                                                    case 2:
                                                        testarExcluirEndereco();
                                                        break;
                                                    case 3:
                                                        testarExcluirFornecedor();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 5:
                                        do {
                                            String listar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Cidade\n"
                                                    + "2) Listar Endereço\n"
                                                    + "3) Listar Fornecedor\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoListar = Integer.parseInt(listar);
                                                switch (opcaoListar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarListarCidade();
                                                        break;
                                                    case 2:
                                                        testarListarEndereco();
                                                        break;
                                                    case 3:
                                                        testarListarFornecedor();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }

                                        } while (true);
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                }
                            } catch (NumberFormatException x) {
                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                            }
                        } while (true);

                    /**
                     * MENU DE TESTES DE DIEGO
                     */
                    case 2: // Testes de Diego
                        menuTestes:
                        do {
                            String menu = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                    + "1) Teste de Salvar\n"
                                    + "2) Teste de Consultar\n"
                                    + "3) Teste de Alterar\n"
                                    + "4) Teste de Excluir\n"
                                    + "5) Teste de Listar\n"
                                    + "0) Voltar ao menu anterior");
                            try {
                                int opcaoMenu = Integer.parseInt(menu);
                                switch (opcaoMenu) {

                                    case 0:
                                        continue menuPrincipal;
                                    case 1:
                                        do {
                                            String salvar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Alterar Produto\n"
                                                    + "2) Alterar Produto_Fornecedor\n"
                                                    + "3) Alterar NotaFiscal_Produto\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoSalvar = Integer.parseInt(salvar);
                                                switch (opcaoSalvar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarSalvarProduto();
                                                        break;
                                                    case 2:
                                                        testarSalvarProduto_Fornecedor();
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 2:
                                        menuConsultar:
                                        do {
                                            String consultar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Consultar Produto\n"
                                                    + "2) Consultar Produto_Fornecedor\n"
                                                    + "3) Consultar NotaFiscal_Produto\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoConsultar = Integer.parseInt(consultar);
                                                switch (opcaoConsultar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        do {
                                                            String tipoConsulta = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                                    + "1) Consultar pela Descrição do Produto\n"
                                                                    + "2) Consultar pelo Código do Produto\n"
                                                                    + "0) Voltar ao menu anterior");
                                                            try {
                                                                int opcaoTipoConsulta = Integer.parseInt(tipoConsulta);
                                                                switch (opcaoTipoConsulta) {
                                                                    case 0:
                                                                        continue menuConsultar;
                                                                    case 1:
                                                                        testarConsultarProdutoDescricao();
                                                                        break;
                                                                    case 2:
                                                                        testarConsultarProdutoCodigo();
                                                                        break;
                                                                    default:
                                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                                }
                                                            } catch (NumberFormatException x) {
                                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                                            }
                                                        } while (true);
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 3:
                                        do {
                                            String alterar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Alterar Produto\n"
                                                    + "2) Alterar Produto_Fornecedor\n"
                                                    + "3) Alterar NotaFiscal_Produto\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoAlterar = Integer.parseInt(alterar);
                                                switch (opcaoAlterar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarAlterarProduto();
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 4:
                                        do {
                                            String excluir = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Excluir Produto\n"
                                                    + "2) Excluir Produto_Fornecedor\n"
                                                    + "3) Excluir NotaFiscal_Produto\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoExcluir = Integer.parseInt(excluir);
                                                switch (opcaoExcluir) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarExcluirProduto();
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 5:
                                        do {
                                            String listar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Produto\n"
                                                    + "2) Listar Produto_Fornecedor\n"
                                                    + "3) Listar NotaFiscal_Produto\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoListar = Integer.parseInt(listar);
                                                switch (opcaoListar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarListarProduto();
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                }
                            } catch (NumberFormatException x) {
                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                            }
                        } while (true);

                    /**
                     * MENU DE TESTES DE SANDRO
                     */
                    case 3:
                        menuTestes:
                        do {
                            String menu = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                    + "1) Teste de Salvar\n"
                                    + "2) Teste de Consultar\n"
                                    + "3) Teste de Alterar\n"
                                    + "4) Teste de Excluir\n"
                                    + "5) Teste de Listar\n"
                                    + "0) Voltar ao menu anterior");
                            try {
                                int opcaoMenu = Integer.parseInt(menu);
                                switch (opcaoMenu) {

                                    case 0:
                                        continue menuPrincipal;

                                    case 1:
                                        do {
                                            String salvar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Salvar Cliente\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoSalvar = Integer.parseInt(salvar);
                                                switch (opcaoSalvar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarSalvarCliente();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 2:
                                        do {
                                            String consultar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Cliente\n"
                                                    + "2) Listar Pessoa Física\n"
                                                    + "3) Listar Pessoa Jurídica\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoConsultar = Integer.parseInt(consultar);
                                                switch (opcaoConsultar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        testarConsultarPessoaFisica();
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 3:
                                        do {
                                            String alterar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Cliente\n"
                                                    + "2) Listar Pessoa Física\n"
                                                    + "3) Listar Pessoa Jurídica\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoAlterar = Integer.parseInt(alterar);
                                                switch (opcaoAlterar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 4:
                                        do {
                                            String excluir = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Cliente\n"
                                                    + "2) Listar Pessoa Física\n"
                                                    + "3) Listar Pessoa Jurídica\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoExcluir = Integer.parseInt(excluir);
                                                switch (opcaoExcluir) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 5:
                                        do {
                                            String listar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Cliente\n"
                                                    + "2) Listar Pessoa Física\n"
                                                    + "3) Listar Pessoa Jurídica\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoListar = Integer.parseInt(listar);
                                                switch (opcaoListar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        testarListarPessoaFisica();
                                                        break;
                                                    case 3:
                                                        testarListarPessoaJuridica();                                                 break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                }
                            } catch (NumberFormatException x) {
                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                            }
                        } while (true);

                    /**
                     * MENU DE TESTES DE THIAGO
                     */
                    case 4:
                        menuTestes:
                        do {
                            String menu = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                    + "1) Teste de Salvar\n"
                                    + "2) Teste de Consultar\n"
                                    + "3) Teste de Alterar\n"
                                    + "4) Teste de Excluir\n"
                                    + "5) Teste de Listar\n"
                                    + "0) Voltar ao menu anterior");
                            try {
                                int opcaoMenu = Integer.parseInt(menu);
                                switch (opcaoMenu) {

                                    case 0:
                                        continue menuPrincipal;

                                    case 1:
                                        do {
                                            String salvar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Funcionário\n"
                                                    + "2) Listar Usuário\n"
                                                    + "3) Listar Nota Fiscal\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoSalvar = Integer.parseInt(salvar);
                                                switch (opcaoSalvar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 2:
                                        do {
                                            String consultar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Funcionário\n"
                                                    + "2) Listar Usuário\n"
                                                    + "3) Listar Nota Fiscal\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoConsultar = Integer.parseInt(consultar);
                                                switch (opcaoConsultar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 3:
                                        do {
                                            String alterar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Funcionário\n"
                                                    + "2) Listar Usuário\n"
                                                    + "3) Listar Nota Fiscal\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoAlterar = Integer.parseInt(alterar);
                                                switch (opcaoAlterar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 4:
                                        do {
                                            String excluir = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Funcionário\n"
                                                    + "2) Listar Usuário\n"
                                                    + "3) Listar Nota Fiscal\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoExcluir = Integer.parseInt(excluir);
                                                switch (opcaoExcluir) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 5:
                                        do {
                                            String listar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Funcionário\n"
                                                    + "2) Listar Usuário\n"
                                                    + "3) Listar Nota Fiscal\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoListar = Integer.parseInt(listar);
                                                switch (opcaoListar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 2:
                                                        //Chamada do método aqui
                                                        break;
                                                    case 3:
                                                        //Chamada do método aqui
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                }
                            } catch (NumberFormatException x) {
                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                            }
                        } while (true);

                    /**
                     * MENU DE TESTES DE FELIPE
                     */
                    case 5:
                        menuTestes:
                        do {
                            String menu = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                    + "1) Teste de Salvar\n"
                                    + "2) Teste de Consultar\n"
                                    + "3) Teste de Alterar\n"
                                    + "4) Teste de Excluir\n"
                                    + "5) Teste de Listar\n"
                                    + "0) Voltar ao menu anterior");
                            try {
                                int opcaoMenu = Integer.parseInt(menu);
                                switch (opcaoMenu) {

                                    case 0:
                                        continue menuPrincipal;

                                    case 1:
                                        do {
                                            String salvar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Salvar Tipo\n"
                                                    + "2) Salvar Marca\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoSalvar = Integer.parseInt(salvar);
                                                switch (opcaoSalvar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testeSalvarTipo();
                                                        break;
                                                    case 2:
                                                        testeSalvarMarca();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 2:
                                        do {
                                            String consultar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Consultar Tipo\n"
                                                    + "2) Consultar Marca\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoConsultar = Integer.parseInt(consultar);
                                                switch (opcaoConsultar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarConsultarTipos();
                                                        break;
                                                    case 2:
                                                        testarConsultarMarcas();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 3:
                                        do {
                                            String alterar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Alterar Tipo\n"
                                                    + "2) Alterar Marca\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoAlterar = Integer.parseInt(alterar);
                                                switch (opcaoAlterar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testeAlterarTipo();
                                                        break;
                                                    case 2:
                                                        testeAlterarMarca();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 4:
                                        do {
                                            String excluir = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Excluir Tipo\n"
                                                    + "2) Excluir Marca\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoExcluir = Integer.parseInt(excluir);
                                                switch (opcaoExcluir) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarExcluirTipo();
                                                        break;
                                                    case 2:
                                                        testarExcluirMarca();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 5:
                                        do {
                                            String listar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Tipo\n"
                                                    + "2) Listar Marca\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoListar = Integer.parseInt(listar);
                                                switch (opcaoListar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarListarTipo();
                                                        break;
                                                    case 2:
                                                        testarListarMarca();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                }
                            } catch (NumberFormatException x) {
                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                            }
                        } while (true);

                    /**
                     * MENU DE TESTES DE BRUNO
                     */
                    case 6:
                        menuTestes:
                        do {
                            String menu = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                    + "1) Teste de Salvar\n"
                                    + "2) Teste de Consultar\n"
                                    + "3) Teste de Alterar\n"
                                    + "4) Teste de Excluir\n"
                                    + "5) Teste de Listar\n"
                                    + "0) Voltar ao menu anterior");
                            try {
                                int opcaoMenu = Integer.parseInt(menu);
                                switch (opcaoMenu) {

                                    case 0:
                                        continue menuPrincipal;

                                    case 1:
                                        do {
                                            String salvar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Salvar Segmento\n"
                                                    + "2) Salvar Forma de Pagamento\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoSalvar = Integer.parseInt(salvar);
                                                switch (opcaoSalvar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarSalvarSegmento();
                                                        break;
                                                    case 2:
                                                        testarSalvarFormaPagamento();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);

                                    case 2:
                                        do {
                                            String consultar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Consultar Segmento\n"
                                                    + "2) Consultar Forma de Pagamento\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoConsultar = Integer.parseInt(consultar);
                                                switch (opcaoConsultar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarConsultarSegmento();
                                                        break;
                                                    case 2:
                                                        testarConsultarFormaPagamento();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 3:
                                        do {
                                            String alterar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Alterar Segmento\n"
                                                    + "2) Alterar Forma de Pagamento\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoAlterar = Integer.parseInt(alterar);
                                                switch (opcaoAlterar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarAlterarSegmento();
                                                        break;
                                                    case 2:
                                                        testarAlterarFormaPagamento();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 4:
                                        do {
                                            String excluir = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Excluir Segmento\n"
                                                    + "2) Excluir Forma de Pagamento\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoExcluir = Integer.parseInt(excluir);
                                                switch (opcaoExcluir) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarExcluirSegmento();
                                                        break;
                                                    case 2:
                                                        testarExcluirFormaPagamento();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    case 5:
                                        do {
                                            String listar = JOptionPane.showInputDialog("Informe a opção desejada:\n"
                                                    + "1) Listar Segmento\n"
                                                    + "2) Listar Forma de Pagamento\n"
                                                    + "0) Voltar ao menu anterior");
                                            try {
                                                int opcaoListar = Integer.parseInt(listar);
                                                switch (opcaoListar) {
                                                    case 0:
                                                        continue menuTestes;
                                                    case 1:
                                                        testarListarSegmento();
                                                        break;
                                                    case 2:
                                                        testarListarFormaPagamento();
                                                        break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                                }
                                            } catch (NumberFormatException x) {
                                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                                            }
                                        } while (true);
                                    default:
                                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                                }
                            } catch (NumberFormatException x) {
                                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
                            }
                        } while (true);

                    default:
                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                }
            } catch (NumberFormatException x) {
                JOptionPane.showMessageDialog(null, "Escolha uma opção!");
            }

        } while (true);
    }

    /**
     * ABAIXO BLOCO PARA CONSTRUÇÃO DOS MÉTODOS DE TESTES
     */
    /**
     * ÁREA ESCRITA POR DANIEL VALENÇA RESPONSAVEL PELAS CLASSES Cidade,
     * Fornecedor, Endereco.
     */
    /**
     * CIDADE
     */
    private static void testarSalvarCidade() {
        System.out.println("Iniciando processo...");
        String cdSalvar = JOptionPane.showInputDialog("Digite o nome da cidade");
        try {
            int validoString = Integer.parseInt(cdSalvar);
            JOptionPane.showMessageDialog(null, "Digite apenas o nome da cidade!");
        } catch (NumberFormatException x) {
            Cidade cd = new Cidade(cdSalvar);
            try {
                fachada.salvarCidade(cd);
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarConsultarCidade() {
        System.out.println("Iniciando processo...");
        Cidade cd;
        int cidades_Codigo;
        String cidades_Nome = JOptionPane.showInputDialog("Digite o código ou o nome da cidade");
        try {
            cidades_Codigo = Integer.parseInt(cidades_Nome);
            try {
                cd = fachada.consultarCidade(cidades_Codigo);
                JOptionPane.showMessageDialog(null, "Código da Cidade.: (" + cd.getCidades_Codigo() + ") \nNome da Cidade.: (" + cd.getCidades_Nome() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                cd = fachada.consultarCidade(cidades_Nome);
                JOptionPane.showMessageDialog(null, "Código da Cidade.: (" + cd.getCidades_Codigo() + ") \nNome da Cidade.: (" + cd.getCidades_Nome() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarExcluirCidade() {
        System.out.println("Iniciando processo...");
        int cdExcluirCod;
        String cdExcluir = JOptionPane.showInputDialog("Digite o código ou o nome da cidade");
        try {
            cdExcluirCod = Integer.parseInt(cdExcluir);
            try {
                fachada.excluirCidade(cdExcluirCod);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                fachada.excluirCidade(cdExcluir);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado");
    }

    private static void testarAlterarCidade() {

        System.out.println("Iniciando processo...");
        int cdAlterarCod;
        String cdAltOld = JOptionPane.showInputDialog("Digite o código ou o nome da cidade a ser alterado");
        try {
            cdAlterarCod = Integer.parseInt(cdAltOld);
            try {
                String cdAltNew = JOptionPane.showInputDialog("Digite o novo nome da cidade");
                Cidade cd = new Cidade();
                cd.setCidades_Nome(cdAltNew);
                cd.setCidades_Codigo(cdAlterarCod);
                fachada.alterarCidade(cd);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                Cidade cd = new Cidade();
                Cidade cdOld = new Cidade();
                cdOld = fachada.consultarCidade(cdAltOld);
                int cidades_Codigo;
                cidades_Codigo = cdOld.getCidades_Codigo();
                String cdAltNew = JOptionPane.showInputDialog("Digite o novo nome da cidade");
                cd.setCidades_Codigo(cidades_Codigo);
                cd.setCidades_Nome(cdAltNew);
                fachada.alterarCidade(cd);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarListarCidade() {
        System.out.println("Iniciando processo...");

        Cidade cd = null;
        ArrayList<Cidade> lista;
        try {
            lista = (ArrayList<Cidade>) fachada.listarCidade("");
            String imprimeLista = "";
            for (Iterator<Cidade> it = lista.iterator(); it.hasNext();) {
                cd = it.next();
                imprimeLista = imprimeLista + "Código.: (" + cd.getCidades_Codigo() + ") Cidade.: (" + cd.getCidades_Nome() + ")\n-------------------------------------------------------------------\n";
            }
            JOptionPane.showMessageDialog(null, imprimeLista);
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    /**
     * ENDERECO
     *
     * @throws GeralException
     */
    private static void testarSalvarEndereco() throws GeralException {
        System.out.println("Iniciando processo...");
        String cep = JOptionPane.showInputDialog("Digite o CEP");
        String logradouro = JOptionPane.showInputDialog("Digite o logradouro");
        String cidade = JOptionPane.showInputDialog("Digite o nome da cidade");
        String nome = null;
        Cidade cd = fachada.consultarCidade(cidade);
        int codigo = cd.getCidades_Codigo();
        int enderecos_Codigo = 0;
        Endereco end = new Endereco(enderecos_Codigo, cep, logradouro, codigo, nome);
        try {
            fachada.salvarEndereco(end);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarConsultarEndereco() {
        System.out.println("Iniciando processo...");
        Endereco end;
        Cidade cd;
        @SuppressWarnings("unused")
        int CEP;
        String endConsult = JOptionPane.showInputDialog("Digite o CEP ou o nome do Logradouro");
        try {
            CEP = Integer.parseInt(endConsult);
            try {
                end = fachada.consultarEndCep(endConsult);
                cd = fachada.consultarCidade(end.getCidades_Codigo());
                JOptionPane.showMessageDialog(null, "CEP.: (" + end.getEnderecos_CEP() + ") \nLogradouro.: (" + end.getEnderecos_Logradouro() + ") \nCidade.: (" + cd.getCidades_Nome() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                end = fachada.consultarEndLog(endConsult);
                cd = fachada.consultarCidade(end.getCidades_Codigo());
                JOptionPane.showMessageDialog(null, "CEP.: (" + end.getEnderecos_CEP() + ") \nLogradouro.: (" + end.getEnderecos_Logradouro() + ") \nCidade.: (" + cd.getCidades_Nome() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarExcluirEndereco() {
        System.out.println("Iniciando processo...");
        String endExcluir = JOptionPane.showInputDialog("Digite o CEP do endereço a ser excluído");
        try {
            fachada.excluirEndereco(endExcluir);
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
        } catch (GeralException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("...processo finalizado");
    }

    private static void testarAlterarEndereco() {
        System.out.println("Iniciando processo...");
        String cepOld = JOptionPane.showInputDialog("Digite o CEP");
        try {
            Endereco end = fachada.consultarEndCep(cepOld);
            if (end == null) {
                JOptionPane.showMessageDialog(null, "Endereço não está cadastrado!");
            } else {
                int codOld = end.getEnderecos_Codigo();
                String cepNew = JOptionPane.showInputDialog("Digite o novo CEP");
                String logNew = JOptionPane.showInputDialog("Digite o Logradouro");
                String cidNew = JOptionPane.showInputDialog("Digite o nome da Cidade");
                Cidade cd = fachada.consultarCidade(cidNew);
                int codNew = cd.getCidades_Codigo();
                end = new Endereco();
                end.setEnderecos_CEP(cepNew);
                end.setEnderecos_Logradouro(logNew);
                end.setCidades_Codigo(codNew);
                end.setEnderecos_Codigo(codOld);
                fachada.alterarEndereco(end);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            }
        } catch (GeralException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarListarEndereco() {
        System.out.println("Iniciando processo...");

        Endereco end = null;
        ArrayList<Endereco> lista;
        try {
            lista = (ArrayList<Endereco>) fachada.listarEndereco("");
            String imprimeLista = "";
            for (Iterator<Endereco> it = lista.iterator(); it.hasNext();) {
                end = it.next();
                imprimeLista = imprimeLista + "Código.: (" + end.getEnderecos_Codigo() + ") CEP.: (" + end.getEnderecos_CEP() + ") Logradouro.: (" + end.getEnderecos_Logradouro() + ") Cidade.: (" + end.getCidades_Codigo() + ")\n-----------------------------------------------------------------------------------------------------------\n";
            }
            JOptionPane.showMessageDialog(null, imprimeLista);
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    /**
     * FORNECEDOR
     *
     * @throws GeralException
     */
    private static void testarSalvarFornecedor() throws GeralException {
        System.out.println("Iniciando processo...");
        String cnpj = JOptionPane.showInputDialog("Digite o CNPJ");
        String razaoSocial = JOptionPane.showInputDialog("Digite a Razão Social");
        int numeroRua = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da rua"));
        int enderecos_Codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do endereço"));
        int fornecedores_Codigo = 0;
        Fornecedor f = new Fornecedor(fornecedores_Codigo, cnpj, razaoSocial, numeroRua, enderecos_Codigo);
        try {
            fachada.salvarFornecedor(f);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarConsultarFornecedor() {
        System.out.println("Iniciando processo...");
        Fornecedor f;
        @SuppressWarnings("unused")
        double cnpj;
        String fornecedor = JOptionPane.showInputDialog("Digite o CNPJ ou Razão Social");
        try {
            cnpj = Double.parseDouble(fornecedor);
            try {
                f = fachada.consultarForCNPJ(fornecedor);
                JOptionPane.showMessageDialog(null, "Código do Fornecedor.: (" + f.getFornecedores_Codigo() + ") \nCNPJ.: (" + f.getFornecedores_CNPJ() + ") \nRazão Social.: (" + f.getFornecedores_RazaoSocial() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                f = fachada.consultarForRazaoSocial(fornecedor);
                JOptionPane.showMessageDialog(null, "Código do Fornecedor.: (" + f.getFornecedores_Codigo() + ") \nCNPJ.: (" + f.getFornecedores_CNPJ() + ") \nRazão Social.: (" + f.getFornecedores_RazaoSocial() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarExcluirFornecedor() {
        System.out.println("Iniciando processo...");
        String forExcluir = JOptionPane.showInputDialog("Digite o CNPJ do fornecedor a ser excluído");
        try {
            fachada.excluirFornecedor(forExcluir);
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
        } catch (GeralException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("...processo finalizado");
    }

    private static void testarAlterarFornecedor() {
        System.out.println("Iniciando processo...");
        String cnpjOld = JOptionPane.showInputDialog("Digite o CNPJ a ser alterado");
        try {
            Fornecedor f = fachada.consultarForCNPJ(cnpjOld);
            if (f == null) {
                JOptionPane.showMessageDialog(null, "Fornecedor não está cadastrado!");
            } else {
                int codOld = f.getFornecedores_Codigo();
                String cnpjNew = JOptionPane.showInputDialog("Digite o novo CNPJ");
                String rsNew = JOptionPane.showInputDialog("Digite a Razão Social");
                int numNew = Integer.parseInt(JOptionPane.showInputDialog("Digite o número"));
                String cepNew = JOptionPane.showInputDialog("Digite o CEP");
                Endereco end = fachada.consultarEndCep(cepNew);
                int codNew = end.getEnderecos_Codigo();
                f = new Fornecedor();
                f.setEnderecos_Codigo(codNew);
                f.setFornecedores_CNPJ(cnpjNew);
                f.setFornecedores_RazaoSocial(rsNew);
                f.setFornecedores_NumeroResidencia(numNew);
                f.setFornecedores_Codigo(codOld);
                fachada.alterarFornecedor(f);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            }
        } catch (GeralException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarListarFornecedor() {
        System.out.println("Iniciando processo...");
        Fornecedor f = null;
        ArrayList<Fornecedor> lista;
        try {
            lista = (ArrayList<Fornecedor>) fachada.listarFornecedor("");
            String imprimeLista = "";
            for (Iterator<Fornecedor> it = lista.iterator(); it.hasNext();) {
                f = it.next();
                imprimeLista = imprimeLista + "Código.: (" + f.getFornecedores_Codigo() + ") CNPJ.: (" + f.getFornecedores_CNPJ() + ") Razão Social.: (" + f.getFornecedores_RazaoSocial() + ") Número.: (" + f.getFornecedores_NumeroResidencia() + ") Código Endereço.: (" + f.getEnderecos_Codigo() + ")\n-------------------------------------------------------------------\n";
            }
            JOptionPane.showMessageDialog(null, imprimeLista);
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    /**
     * FIM DA ÁREA ESCRITA POR DANIEL VALENÇA
     */
    /**
     * AREA ESCRITA POR Diego Silva RESPONSAVEL PELAS CLASSES Produto,
     * Produto_Fornecedor, NotaFiscal_Produto.
     */
    /**
     * Diego Silva Teste de Salvar Teste de Salvar Produto na tabela Produtos
     * Utilizando as camadas
     */
    private static void testarSalvarProduto() {
        System.out.println("Teste de salvar Produto");

        Produto p = new Produto(1, 1, 1, "Camisa Regata T=p", 10, 9.99);

        try {
            fachada.salvarProduto(p);
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim teste salvar!");
    }

    /**
     * Diego Silva teste de Consultar pela Descricao
     */
    private static void testarConsultarProdutoDescricao() {
        System.out.println("Tetando consulta");

        try {
            Produto p = fachada.consultarProduto("Camisa");
            JOptionPane.showMessageDialog(null, " CodigoProduto.: (" + p.getProdutos_Codigo() + ") CodigoSegmento.: (" + p.getSegmentos_Codigo() + ") CodigoTipo.: (" + p.getTipos_Codigo() + ") CodigoMarca.: (" + p.getMarcas_Codigo() + ") Descriï¿½ï¿½o.: (" + p.getProdutos_Descricao() + ") Quantidade.: (" + p.getProdutos_Quantidade() + ") ValorVeda.: (" + p.getProdutos_ValorVenda() + ")");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim do teste de consulta pela descricao");
    }

    /**
     * Diego Silva teste de Consultar pelo Codigo
     */
    private static void testarConsultarProdutoCodigo() {
        System.out.println("Tetando consulta");

        try {
            Produto p = fachada.consultarProduto(1);
            JOptionPane.showMessageDialog(null, " CodigoProduto.: (" + p.getProdutos_Codigo() + ") CodigoSegmento.: (" + p.getSegmentos_Codigo() + ") CodigoTipo.: (" + p.getTipos_Codigo() + ") CodigoMarca.: (" + p.getMarcas_Codigo() + ") Descriï¿½ï¿½o.: (" + p.getProdutos_Descricao() + ") Quantidade.: (" + p.getProdutos_Quantidade() + ") ValorVeda.: (" + p.getProdutos_ValorVenda() + ")");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim do teste de consulta pela descricao");
    }

    /**
     * Diego Silva Teste de Exclusão Teste de exclusão do Produto na tabela
     * Produtos Utilizando as camadas
     */
    public static void testarExcluirProduto() {
        System.out.println("Teste de exclusão de produto");

        try {
            fachada.excluirProduto(3);
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim Teste de exclusão");
    }

    /**
     * Diego Silva teste de Alteração
     */
    public static void testarAlterarProduto() {
        System.out.println("Testando alteração do produto");

        Produto p = new Produto();
        p.setSegmentos_Codigo(1);
        p.setTipos_Codigo(1);
        p.setMarcas_Codigo(1);
        p.setProdutos_Descricao("Camisa Verde Irada TM'm'");
        p.setProdutos_Quantidade(7);
        p.setProdutos_ValorVenda(28.85);
        p.setProdutos_Codigo(4);

        try {
            fachada.alterarProduto(p);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Fim teste de alterar");
    }

    /**
     * Diego Silva teste de listagem dos produtos pela descrição informada
     */
    public static void testarListarProduto() {
        Produto p = null;
        ArrayList<Produto> lista;
        try {
            lista = (ArrayList<Produto>) fachada.listarProduto("Cami");
            for (Iterator<Produto> it = lista.iterator(); it.hasNext();) {
                p = it.next();
                JOptionPane.showMessageDialog(null, "Segmento.: (" + p.getSegmentos().getSegmentos_Descricao() + ") Tipo.: (" + p.getTipo().getTipos_Descricao() + ") Marca.: (" + p.getMarcas().getMarcas_Descricao() + ") Descriï¿½ï¿½o.: (" + p.getProdutos_Descricao() + ") Quantidade.: (" + p.getProdutos_Quantidade() + ") Valor de Venda.: (" + p.getProdutos_ValorVenda() + ")");
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim teste de listagem");
    }

    /**
     * --PRODUTO_FORNECEDOR--
     */
    /**
     * Diego Silva teste de Salva Produto_Fornecedor
     */
    public static void testarSalvarProduto_Fornecedor() {
        System.out.println("Teste de salvar Produto_Fonecedor");
        //criar um novo Produto_Fornecedor
        Produto_Fornecedor pf = new Produto_Fornecedor();
        pf.setProdutos_Codigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do produto!")));
        pf.setFornecedores_Codigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o cï¿½digo do fornecedor!")));

        try {
            fachada.salvarProduto_Fornecedor(pf);

        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim teste salvar!");
    }

    /**
     * FIM DA ï¿½REA ESCRITA POR DIEGO SILVA
     */
    /**
     * ÁREA ESCRITA POR SANDRO RESPONSAVEL PELAS CLASSES Cliente, PessoaFisica,
     * PessoaJuridica.
     */
    private static void testarSalvarCliente() {
        System.out.println("Iniciando processo...");
        String cliTipo = JOptionPane.showInputDialog("Digite o Tipo de Cliente");
        try {
            if ((cliTipo.equals("F")) || (cliTipo.equals("f"))) {
                int cliEndCodigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do endereco"));
                String cliNumero = JOptionPane.showInputDialog("Digite o numero de residencia");
                String cliNome = JOptionPane.showInputDialog("Digite o Nome do Cliente");
                String cliCPF = JOptionPane.showInputDialog("Digite o CPF do Cliente");
                String cliSexo = JOptionPane.showInputDialog("Digite o SEXO (M)asculino (F)eminino");
                PessoaFisica clipf = new PessoaFisica(cliEndCodigo, cliNumero, cliTipo, cliNome, cliCPF, cliSexo);
                fachada.salvarCliente(clipf);
            } else {
                if ((cliTipo.equals("J")) || (cliTipo.equals("j"))) {
                    int cliEndCodigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do endereco"));
                    String cliNumero = JOptionPane.showInputDialog("Digite o numero do estabelecimento");
                    String cliRazaoSocial = JOptionPane.showInputDialog("Digite a Razao Social");
                    String cliCNPJ = JOptionPane.showInputDialog("Digite o CNPJ do Cliente");
                    PessoaJuridica clipj = new PessoaJuridica(cliEndCodigo, cliNumero, cliTipo, cliCNPJ, cliRazaoSocial);
                    fachada.salvarCliente(clipj);
                }
            }


        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarConsultarPessoaFisica() throws GeralException {
        System.out.println("Iniciando processo...");
        PessoaFisica pf;
        @SuppressWarnings("unused")
        double cpf;
        String cliPf = JOptionPane.showInputDialog("Digite o CPf ou Nome do Cliente");
        try {
            cpf = Double.parseDouble(cliPf);
            //pf = fachada.consultarPF_Nome(cliPf);
            //JOptionPane.showMessageDialog(null, "Codigo do Fornecedor.: ("+pf.getClientes_Codigo() +") \nCNPJ.: ("+pf.getPessoasFisica_CPF() +") \nRazão Social.: ("+pf.getPessoasFisica_Nome() +")");
        } catch (NumberFormatException x) {
            pf = fachada.consultarPF_Nome(cliPf);
            JOptionPane.showMessageDialog(null, "Codigo do Fornecedor.: (" + pf.getClientes_Codigo() + ") \nCNPJ.: (" + pf.getPessoasFisica_CPF() + ") \nRazï¿½o Social.: (" + pf.getPessoasFisica_Nome() + ")");
        }
        System.out.println("...processo finalizado!");
    }
    
        public static void testarListarPessoaFisica() throws ConexaoException {
        PessoaFisica pf;
        ArrayList<PessoaFisica> lista;
        try {
            lista = (ArrayList<PessoaFisica>) fachada.listarPessoaFisica();
            for (Iterator<PessoaFisica> it = lista.iterator(); it.hasNext();) {
                pf = it.next();
                JOptionPane.showMessageDialog(null, "Cliente.: " + pf.getPessoasFisica_Nome()) ;
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim teste de listagem");
    }

        public static void testarListarPessoaJuridica() throws ConexaoException {
        PessoaJuridica pj;
        ArrayList<PessoaJuridica> lista;
        try {
            lista = (ArrayList<PessoaJuridica>) fachada.listarPessoaJuridica();
            if (lista == null){
                JOptionPane.showMessageDialog(null, "Não há Cliente a ser Listado");
            }else{
            for (Iterator<PessoaJuridica> it = lista.iterator(); it.hasNext();) {
                pj = it.next();
                JOptionPane.showMessageDialog(null, "Razão Social.: " + pj.getPessoasJuridica_RazaoSocial()) ;
            }
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("Fim teste de listagem");
    }


    /**
     * FIM DA ÁREA ESCRITA POR SANDRO
     */
    /**
     * AREA ESCRITA POR FELIPE CARLOS RESPONSAVEL PELAS CLASSES tipo e marca.
     */
    //teste salvar
    public static void testeSalvarTipo() {
        /*
         * Tipo t = new Tipo(1,"AAAA"); try{ fachada.salvarTipo(t); }catch (
         * GeralException ex ){ JOptionPane.showMessageDialog(null,
         * ex.getMessage() ); } System.out.println("Fim teste salvar!");
         */


        System.out.println("Iniciando processo...");
        String tSalvar = JOptionPane.showInputDialog("Digite o Tipo");
        try {
            @SuppressWarnings("unused")
            int validoString = Integer.parseInt(tSalvar);
            JOptionPane.showMessageDialog(null, "Digite apenas a descriï¿½ï¿½o do tipo!");
        } catch (NumberFormatException x) {
            Tipo t = new Tipo();
            t.setTipos_Descricao(tSalvar);
            try {
                fachada.salvarTipo(t);
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    //teste alterar
    public static void testeAlterarTipo() {
        System.out.println("Iniciando processo...");
        int tAlterarCod;
        String tAltOld = JOptionPane.showInputDialog("Digite o cï¿½digo ou a descricão do tipo a ser alterado");
        try {
            tAlterarCod = Integer.parseInt(tAltOld);
            try {
                String tAlt = JOptionPane.showInputDialog("Digite o novo Tipo");
                Tipo t = new Tipo();
                t.setTipos_Descricao(tAlt);
                t.setTipos_Codigo(tAlterarCod);
                fachada.alterarTipo(t);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                Tipo t = new Tipo();
                Tipo tOld = new Tipo();
                tOld = fachada.consultarTipos(tAltOld);
                int tipos_Codigo;
                tipos_Codigo = tOld.getTipos_Codigo();
                String tAlt = JOptionPane.showInputDialog("Digite o novo tipo");
                t.setTipos_Codigo(tipos_Codigo);
                t.setTipos_Descricao(tAlt);
                fachada.alterarTipo(t);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    /*
     * Tipo t = new Tipo(); t.setTipos_Codigo(1); t.setTipos_Descricao("AAAAA");
     * try{ fachada.alterarTipo(t); JOptionPane.showMessageDialog(null,
     * "Alteração realizada com sucesso!"); }catch (GeralException ex){
     * JOptionPane.showMessageDialog(null, ex.getMessage()); }
     * JOptionPane.showMessageDialog(null, "Fim teste de alterar"); }
     */
    //teste listar
    public static void testarListarTipo() {
        Tipo t = null;
        String tp = "";
        ArrayList<Tipo> lista;
        try {
            lista = (ArrayList<Tipo>) fachada.listarTipo("");
            for (Iterator<Tipo> it = lista.iterator(); it.hasNext();) {
                t = it.next();
                String cod = String.valueOf(t.getTipos_Codigo());
                tp = tp + "Cï¿½digo: " + cod + "-" + "Descrição: " + t.getTipos_Descricao() + "\n";
                //JOptionPane.showMessageDialog(null,"Código.: ("+ t.getTipos_Codigo() +") \nTipo.: ("+ t.getTipos_Descricao()+")");
            }

        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, tp);
        System.out.println("Fim teste de listagem");
    }

    public static void testarExcluirTipo() {
        /*
         * System.out.println("Teste de exclusão de produto");
         *
         * try{ fachada.excluirTipo(1); JOptionPane.showMessageDialog(null,
         * "Tipo excluido com sucesso!"); }catch (GeralException ex){
         * JOptionPane.showMessageDialog(null, ex.getMessage()); }
         * System.out.println("Fim Teste de exclusão");
         */
        System.out.println("Iniciando processo...");

        int tExcluirCod;
        String tExcluir = JOptionPane.showInputDialog("Digite o código ou o nome do tipo");
        try {
            tExcluirCod = Integer.parseInt(tExcluir);
            try {
                fachada.excluirTipo(tExcluirCod);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                fachada.excluirTipo(tExcluir);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado");
    }

    public static void testarConsultarTipos() {
        System.out.println("Iniciando consulta");
        int tpCodigo;
        String tConsult = JOptionPane.showInputDialog("Digite o código ou o nome tipo");
        try {
            tpCodigo = Integer.parseInt(tConsult);
            try {
                Tipo t = fachada.consultarTipos(tpCodigo);
                JOptionPane.showMessageDialog(null, "Código: " + t.getTipos_Codigo() + "- Descrição: " + t.getTipos_Descricao());
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                Tipo t = fachada.consultarTipos(tConsult);
                JOptionPane.showMessageDialog(null, "Código: " + t.getTipos_Codigo() + "- Descrição: " + t.getTipos_Descricao());
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("Consulta finalizada!");
    }

    //MARCA
    public static void testeSalvarMarca() {
        /*
         * Marca m = new Marca(1,"Nike"); try{ fachada.salvarMarca(m); }catch (
         * GeralException ex ){ JOptionPane.showMessageDialog(null,
         * ex.getMessage() ); } System.out.println("Fim teste salvar!");
         */
        System.out.println("Iniciando processo...");
        String tSalvar = JOptionPane.showInputDialog("Digite a Marca");
        try {
            @SuppressWarnings("unused")
            int validoString = Integer.parseInt(tSalvar);
            JOptionPane.showMessageDialog(null, "Digite apenas a descriï¿½ï¿½o da marca!");
        } catch (NumberFormatException x) {
            Marca m = new Marca();
            m.setMarcas_Descricao(tSalvar);
            try {
                fachada.salvarMarca(m);
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    //teste alterar
    public static void testeAlterarMarca() {
        System.out.println("Iniciando processo...");
        int mAlterarCod;
        String mAltOld = JOptionPane.showInputDialog("Digite o código ou a descrição da marca a ser alterado");
        try {
            mAlterarCod = Integer.parseInt(mAltOld);
            try {
                String mAlt = JOptionPane.showInputDialog("Digite a nova marca");
                Marca m = new Marca();
                m.setMarcas_Descricao(mAlt);
                m.setMarcas_Codigo(mAlterarCod);
                fachada.alterarMarca(m);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                Marca m = new Marca();
                Marca mOld = new Marca();
                mOld = fachada.consultarMarcas(mAltOld);
                int marcas_Codigo;
                marcas_Codigo = mOld.getMarcas_Codigo();
                String mAlt = JOptionPane.showInputDialog("Digite nova marca");
                m.setMarcas_Codigo(marcas_Codigo);
                m.setMarcas_Descricao(mAlt);
                fachada.alterarMarca(m);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    /*
     * Marca m = new Marca(); m.setMarcas_Codigo(1);
     * m.setMarcas_Descricao("AAAAA"); try{ fachada.alterarMarca(m);
     * JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
     * }catch (GeralException ex){ JOptionPane.showMessageDialog(null,
     * ex.getMessage()); } JOptionPane.showMessageDialog(null, "Fim teste de
     * alterar");
     *
     * }
     */
    //teste listar
    public static void testarListarMarca() {
        Marca m = null;
        String ma = "";
        ArrayList<Marca> lista;
        try {
            lista = (ArrayList<Marca>) fachada.listarMarca("");
            for (Iterator<Marca> it = lista.iterator(); it.hasNext();) {
                m = it.next();
                String cod = String.valueOf(m.getMarcas_Codigo());
                ma = ma + "Código: " + cod + "-" + "Descrição: " + m.getMarcas_Descricao() + "\n";
                //JOptionPane.showMessageDialog(null,"Código: "+ t.getTipos_Codigo() +" - Tipo:"+ t.getTipos_Descricao());
            }

        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, ma);
        System.out.println("Fim teste de listagem");
    }

    public static void testarExcluirMarca() {
        /*
         * System.out.println("Teste de exclusão de produto");
         *
         * try{ fachada.excluirMarca(1); JOptionPane.showMessageDialog(null,
         * "Marca excluído com sucesso!"); }catch (GeralException ex){
         * JOptionPane.showMessageDialog(null, ex.getMessage()); }
         * System.out.println("Fim Teste de exclusão"); }
         */
        System.out.println("Iniciando processo...");

        int mExcluirCod;
        String mExcluir = JOptionPane.showInputDialog("Digite o codigo ou a descricao da marca");
        try {
            mExcluirCod = Integer.parseInt(mExcluir);
            try {
                fachada.excluirMarca(mExcluirCod);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                fachada.excluirMarca(mExcluir);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado");
    }

    public static void testarConsultarMarcas() {
        System.out.println("Iniciando consulta");
        int maCodigo;
        String mConsult = JOptionPane.showInputDialog("Digite o código ou o nome tipo");
        try {
            maCodigo = Integer.parseInt(mConsult);
            try {
                Marca m = fachada.consultarMarcas(maCodigo);
                JOptionPane.showMessageDialog(null, "Código: " + m.getMarcas_Codigo() + " - Descrição: " + m.getMarcas_Descricao());
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                Marca m = fachada.consultarMarcas(mConsult);
                JOptionPane.showMessageDialog(null, "Código: " + m.getMarcas_Codigo() + " - Descrição: " + m.getMarcas_Descricao());
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("Consulta finalizada!");
    }

    /**
     * ÁREA ESCRITA POR BRUNO PINHEIRO RESPONSAVEL PELAS CLASSES FormaPagamento,
     * Segmento.
     */
    /**
     * FORMAPAGAMENTO
     */
    private static void testarSalvarFormaPagamento() {
        System.out.println("Iniciando processo...");
        String fpSalvar = JOptionPane.showInputDialog("Digite a Forma de Pagamento");
        try {
            @SuppressWarnings("unused")
            int validoString = Integer.parseInt(fpSalvar);
            JOptionPane.showMessageDialog(null, "Digite apenas a Forma de Pagamento!");
        } catch (NumberFormatException x) {
            FormaPagamento fp = new FormaPagamento();
            fp.setFormaPagamento_Descricao(fpSalvar);
            try {
                fachada.salvarFormaPagamento(fp);
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarConsultarFormaPagamento() {
        System.out.println("Iniciando processo...");
        FormaPagamento fp;
        int formaPagamento_Codigo;
        String formaPagamento_Descricao = JOptionPane.showInputDialog("Digite o código ou o nome da Forma de Pagamanto");
        try {
            formaPagamento_Codigo = Integer.parseInt(formaPagamento_Descricao);
            try {
                fp = fachada.consultarFormaPagamento(formaPagamento_Codigo);
                JOptionPane.showMessageDialog(null, "Código da Forma de Pagamento.: (" + fp.getFormaPagamento_Codigo() + ") \nDescrição da Forma de Pagamento.: (" + fp.getFormaPagamento_Descricao() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                fp = fachada.consultarFormaPagamento(formaPagamento_Descricao);
                JOptionPane.showMessageDialog(null, "Código da Forma de Pagamento.: (" + fp.getFormaPagamento_Codigo() + ") \nDescrição da Forma de Pagamento.: (" + fp.getFormaPagamento_Descricao() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarExcluirFormaPagamento() {
        System.out.println("Iniciando processo...");
        int fpExcluirCod;
        String fpExcluir = JOptionPane.showInputDialog("Digite o código da Forma de Pagamento");
        try {
            fpExcluirCod = Integer.parseInt(fpExcluir);
            fachada.excluirFormaPagamento(fpExcluirCod);

        } catch (GeralException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("...processo finalizado");
    }

    private static void testarAlterarFormaPagamento() {

        System.out.println("Iniciando processo...");
        int fpAlterarCod;
        String fpAltOld = JOptionPane.showInputDialog("Digite o código ou a Descricao da Forma de Pagamento a ser alterada");
        try {
            fpAlterarCod = Integer.parseInt(fpAltOld);
            try {
                String fpAltNew = JOptionPane.showInputDialog("Digite o novo nome da Forma de Pagamento");
                FormaPagamento fp = new FormaPagamento();
                fp.setFormaPagamento_Descricao(fpAltNew);
                fp.setFormaPagamento_Codigo(fpAlterarCod);
                fachada.alterarFormaPagamento(fp);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                FormaPagamento fp = new FormaPagamento();
                FormaPagamento fpOld = new FormaPagamento();
                fpOld = fachada.consultarFormaPagamento(fpAltOld);
                int FormaPagamento_Codigo;
                FormaPagamento_Codigo = fpOld.getFormaPagamento_Codigo();
                String fpAltNew = JOptionPane.showInputDialog("Digite o novo nome da Forma de Pagamento");
                fp.setFormaPagamento_Codigo(FormaPagamento_Codigo);
                fp.setFormaPagamento_Descricao(fpAltNew);
                fachada.alterarFormaPagamento(fp);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarListarFormaPagamento() {
        System.out.println("Iniciando processo...");

        FormaPagamento fp = null;
        ArrayList<FormaPagamento> lista;
        try {
            lista = (ArrayList<FormaPagamento>) fachada.listarFormasPagamentos("");
            String imprimeLista = "";
            for (Iterator<FormaPagamento> it = lista.iterator(); it.hasNext();) {
                fp = it.next();
                imprimeLista = imprimeLista + "Código.: (" + fp.getFormaPagamento_Codigo() + ") Cidade.: (" + fp.getFormaPagamento_Descricao() + ")\n";
            }
            JOptionPane.showMessageDialog(null, imprimeLista);
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    // SEGMENTO
    private static void testarSalvarSegmento() {
        System.out.println("Iniciando processo...");
        String sSalvar = JOptionPane.showInputDialog("Digite o Segmento");
        try {
            @SuppressWarnings("unused")
            int validoString = Integer.parseInt(sSalvar);
            JOptionPane.showMessageDialog(null, "Digite apenas o Segmento!");
        } catch (NumberFormatException x) {
            Segmento s = new Segmento();
            s.setSegmentos_Descricao(sSalvar);
            try {
                fachada.salvarSegmento(s);
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarConsultarSegmento() {
        System.out.println("Iniciando processo...");
        Segmento s;
        int segmento_Codigo;
        String segmento_Descricao = JOptionPane.showInputDialog("Digite o código ou descricao do Segmento");
        try {
            segmento_Codigo = Integer.parseInt(segmento_Descricao);
            try {
                s = fachada.consultarSegmentos(segmento_Codigo);
                JOptionPane.showMessageDialog(null, "Codigo do Segmento.: (" + s.getSegmentos_Codigo() + ") \nDescrição do Segmento.: (" + s.getSegmentos_Descricao() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                s = fachada.consultarSegmentos(segmento_Descricao);
                JOptionPane.showMessageDialog(null, "Codigo do Segmento.: (" + s.getSegmentos_Codigo() + ") \nDescricao do Segmento.: (" + s.getSegmentos_Descricao() + ")");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarExcluirSegmento() {
        System.out.println("Iniciando processo...");
        int sExcluirCod;
        String sExcluir = JOptionPane.showInputDialog("Digite o código do Segmento");
        try {
            sExcluirCod = Integer.parseInt(sExcluir);
            fachada.excluirSegmento(sExcluirCod);

        } catch (GeralException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println("...processo finalizado");
    }

    private static void testarAlterarSegmento() {

        System.out.println("Iniciando processo...");
        int sAlterarCod;
        String sAltOld = JOptionPane.showInputDialog("Digite o código ou a Descrição do Segmento a ser alterado");
        try {
            sAlterarCod = Integer.parseInt(sAltOld);
            try {
                String sAltNew = JOptionPane.showInputDialog("Digite a nova descricacao do segmento");
                Segmento s = new Segmento();
                s.setSegmentos_Descricao(sAltNew);
                s.setSegmentos_Codigo(sAlterarCod);
                fachada.alterarSegmento(s);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (NumberFormatException x) {
            try {
                Segmento s = new Segmento();
                Segmento sOld = new Segmento();
                sOld = fachada.consultarSegmentos(sAltOld);
                int Segmento_Codigo;
                Segmento_Codigo = sOld.getSegmentos_Codigo();
                String sAltNew = JOptionPane.showInputDialog("Digite a nova descricao do segmento");
                s.setSegmentos_Codigo(Segmento_Codigo);
                s.setSegmentos_Descricao(sAltNew);
                fachada.alterarSegmento(s);
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            } catch (GeralException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("...processo finalizado!");
    }

    private static void testarListarSegmento() {
        System.out.println("Iniciando processo...");

        Segmento s = null;
        ArrayList<Segmento> lista;
        try {
            lista = (ArrayList<Segmento>) fachada.listarSegmentos("");
            String imprimeLista = "";
            for (Iterator<Segmento> it = lista.iterator(); it.hasNext();) {
                s = it.next();
                imprimeLista = imprimeLista + "Código.: (" + s.getSegmentos_Codigo() + ") Cidade.: (" + s.getSegmentos_Descricao() + ")\n";
            }
            JOptionPane.showMessageDialog(null, imprimeLista);
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        System.out.println("...processo finalizado!");
    }

    /**
     * FIM DA ÁREA ESCRITA POR BRUNO PINHEIRO
     */
    /**
     * ÁREA ESCRITA POR Thiago Evoá RESPONSAVEL PELAS CLASSES Usuário,
     * Funcionario, Nota Fiscal.
     */
    /**
     * Usuário
     */


/**
 * FIM DA ÁREA ESCRITA POR Thiago Evoá
 */
    
}