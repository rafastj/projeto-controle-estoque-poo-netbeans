/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.gui;

import javax.swing.JOptionPane;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.Usuario;

/**
 *
 * @author diego
 */
public class GuiMenu extends javax.swing.JFrame {

    public static Fachada fachada = new Fachada();

    /**
     * Creates new form GuiMenu
     */
    public GuiMenu() {
        initComponents();
        //extender o frame
       
        setLocationRelativeTo(null);//mostra no centro da tela
        jMenuBarra.setVisible(false); //esconder a barra de menu 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jPGuiLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLoginField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jbAcessar = new javax.swing.JButton();
        jMenuBarra = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCidade = new javax.swing.JMenu();
        jMenuTabelaCidade = new javax.swing.JMenuItem();
        jMenuCliente = new javax.swing.JMenu();
        jMenuItemPF = new javax.swing.JMenuItem();
        jMenuEndereco = new javax.swing.JMenu();
        jMenuEnderecoNovo = new javax.swing.JMenuItem();
        jMenuFornecedor = new javax.swing.JMenu();
        jMenuGerenciarFornecedor = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuFuncionario = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItemNovoUsuario = new javax.swing.JMenuItem();
        jMenuProduto = new javax.swing.JMenu();
        jMenuItemNovoProduto = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuTipos = new javax.swing.JMenuItem();
        jMenuMarcas = new javax.swing.JMenuItem();
        jMovimentacao = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItemLogoff = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuItemSobre = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        jPGuiLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Autenticação..."));

        jLabel1.setText("Login.:");

        jLabel2.setText("Senha.:");

        jbAcessar.setText("Acessar");
        jbAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcessarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPGuiLoginLayout = new javax.swing.GroupLayout(jPGuiLogin);
        jPGuiLogin.setLayout(jPGuiLoginLayout);
        jPGuiLoginLayout.setHorizontalGroup(
            jPGuiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGuiLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGuiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGuiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField)
                    .addComponent(jLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbAcessar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPGuiLoginLayout.setVerticalGroup(
            jPGuiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGuiLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGuiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLoginField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGuiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAcessar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuCadastro.setText("Cadastro");

        jMenuCidade.setText("Cidade");

        jMenuTabelaCidade.setText("Gerenciar Cidade");
        jMenuTabelaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTabelaCidadeActionPerformed(evt);
            }
        });
        jMenuCidade.add(jMenuTabelaCidade);

        jMenuCadastro.add(jMenuCidade);

        jMenuCliente.setText("Cliente");

        jMenuItemPF.setText("Gerenciar Pessoa Fisica");
        jMenuItemPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPFActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemPF);

        jMenuCadastro.add(jMenuCliente);

        jMenuEndereco.setText("Endereço");

        jMenuEnderecoNovo.setText("Gerenciar Endereços");
        jMenuEnderecoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEnderecoNovoActionPerformed(evt);
            }
        });
        jMenuEndereco.add(jMenuEnderecoNovo);

        jMenuCadastro.add(jMenuEndereco);

        jMenuFornecedor.setText("Fornecedor");

        jMenuGerenciarFornecedor.setText("Gerenciar Fornecedor");
        jMenuGerenciarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciarFornecedorActionPerformed(evt);
            }
        });
        jMenuFornecedor.add(jMenuGerenciarFornecedor);

        jMenuItem1.setText("Fornecimento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuFornecedor.add(jMenuItem1);

        jMenuCadastro.add(jMenuFornecedor);

        jMenuFuncionario.setText("Funcionário");

        jMenuItem6.setText("Novo Funcionário");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuFuncionario.add(jMenuItem6);

        jMenuItemNovoUsuario.setText("Usuário");
        jMenuItemNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoUsuarioActionPerformed(evt);
            }
        });
        jMenuFuncionario.add(jMenuItemNovoUsuario);

        jMenuCadastro.add(jMenuFuncionario);

        jMenuProduto.setText("Produto");

        jMenuItemNovoProduto.setText("Novo Produto");
        jMenuItemNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoProdutoActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuItemNovoProduto);

        jMenuItem9.setText("Forma de Pagamento");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuItem9);

        jMenuItem10.setText("Segmento");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuItem10);

        jMenuTipos.setText("Tipo");
        jMenuTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTiposActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuTipos);

        jMenuMarcas.setText("Marca");
        jMenuMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMarcasActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuMarcas);

        jMenuCadastro.add(jMenuProduto);

        jMenuBarra.add(jMenuCadastro);

        jMovimentacao.setText("Movimentação");

        jMenuItem2.setText("Nota Fiscal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMovimentacao.add(jMenuItem2);

        jMenuBarra.add(jMovimentacao);

        jMenu9.setText("Sistema");

        jMenuItemLogoff.setText("Logoff");
        jMenuItemLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoffActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItemLogoff);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItemSair);

        jMenuItemSobre.setText("Sobre...");
        jMenu9.add(jMenuItemSobre);

        jMenuBarra.add(jMenu9);

        setJMenuBar(jMenuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jPGuiLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPGuiLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-555)/2, (screenSize.height-367)/2, 555, 367);
    }// </editor-fold>//GEN-END:initComponents

    //metodo responsável por libera o acesso ao menu
    private void acessoLiberado() {
        //ocultar o Painel de login
        
        jPGuiLogin.setVisible(false);
        //mostrar a Barra de Menu
        jMenuBarra.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    //metodo responsável por limpar os campos login e senha
    private void errologin() {
        jLoginField.setText("");
        jPasswordField.setText("");
        jLoginField.requestFocus();
    }
    //metodo de erro de senha

    private void errosenha() {
        jPasswordField.setText("");
        jPasswordField.requestFocus();
    }

    private void jbAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcessarActionPerformed
        // TODO add your handling code here:
        //AUTENTICAÇÃO DO LOGIN ADMIN
        if (jLoginField.getText().equals("000") && jPasswordField.getText().toString().equals("000")) {

            //metodo responsável por libera o acesso ao menu
            acessoLiberado();

        } else {
            //AUTENTICAÇÃO DO LOGIN COM DAO
            try {
                Usuario userAltenticacao = fachada.consultarUsuario(jLoginField.getText());

                if (userAltenticacao != null) {
                    if (userAltenticacao.getUsuarios_Senha().equals(jPasswordField.getText().toString())) {

                        //metodo responsável por libera o acesso ao menu
                        acessoLiberado();

                    } else {
                        JOptionPane.showMessageDialog(null, "Senha Incorreta!");
                        errosenha();

                    }
                }
            } catch (GeralException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                errologin();
            }
        }
        }//GEN-LAST:event_jbAcessarActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        // TODO add your handling code here:
        int resposta;
        resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            // verifica se o usuário clicou no botão YES
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoffActionPerformed
        // TODO add your handling code here:
        //errosenha();
        initComponents();
        jMenuBarra.setVisible(false);
        jPGuiLogin.setVisible(true);
        jLoginField.requestFocus();
    }//GEN-LAST:event_jMenuItemLogoffActionPerformed

    private void jMenuItemNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoUsuarioActionPerformed
        // TODO add your handling code here:
        GuiUsuario us = new GuiUsuario();
        us.setVisible(true);
    }//GEN-LAST:event_jMenuItemNovoUsuarioActionPerformed

    private void jMenuTabelaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTabelaCidadeActionPerformed
        GuiCidade cd = new GuiCidade();
        cd.setVisible(true);
    }//GEN-LAST:event_jMenuTabelaCidadeActionPerformed

    private void jMenuEnderecoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEnderecoNovoActionPerformed
        GuiEndereco end = new GuiEndereco();
        end.setVisible(true);
    }//GEN-LAST:event_jMenuEnderecoNovoActionPerformed

    private void jMenuGerenciarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciarFornecedorActionPerformed
        GuiFornecedor fornecedor = new GuiFornecedor();
        fornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuGerenciarFornecedorActionPerformed

    private void jMenuItemNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoProdutoActionPerformed
        // TODO add your handling code here:
                //CHAMADA DA GUI PRODUTO
        GuiProduto gProduto = new GuiProduto(this, rootPaneCheckingEnabled);//criei o objeto

        gProduto.setVisible(true);//chamei o objeto    
    }//GEN-LAST:event_jMenuItemNovoProdutoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         GuiFornecedorForneceProduto gForneForneProduto = new GuiFornecedorForneceProduto();//criei o objeto
         gForneForneProduto.setVisible(true);//chamei o objeto    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        GuiFuncionario gFuncionario = new GuiFuncionario();
        gFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        GuiNotaFiscal nf = new GuiNotaFiscal();
        nf.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTiposActionPerformed
        // TODO add your handling code here:
        GuiTipos tipo = new GuiTipos();
        tipo.setVisible(true);
    }//GEN-LAST:event_jMenuTiposActionPerformed

    private void jMenuMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMarcasActionPerformed
        // TODO add your handling code here:
        GuiMarcas marca = new GuiMarcas();
        marca.setVisible(true);
    }//GEN-LAST:event_jMenuMarcasActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        GuiFormaPagamento formaPagamento = new GuiFormaPagamento();
        formaPagamento.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        GuiSegmento segmento = new GuiSegmento();
        segmento.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItemPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemPFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GuiMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jLoginField;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBarra;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuCidade;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenu jMenuEndereco;
    private javax.swing.JMenuItem jMenuEnderecoNovo;
    private javax.swing.JMenu jMenuFornecedor;
    private javax.swing.JMenu jMenuFuncionario;
    private javax.swing.JMenuItem jMenuGerenciarFornecedor;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemLogoff;
    private javax.swing.JMenuItem jMenuItemNovoProduto;
    private javax.swing.JMenuItem jMenuItemNovoUsuario;
    private javax.swing.JMenuItem jMenuItemPF;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenuItem jMenuMarcas;
    private javax.swing.JMenu jMenuProduto;
    private javax.swing.JMenuItem jMenuTabelaCidade;
    private javax.swing.JMenuItem jMenuTipos;
    private javax.swing.JMenu jMovimentacao;
    private javax.swing.JPanel jPGuiLogin;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JButton jbAcessar;
    // End of variables declaration//GEN-END:variables
}