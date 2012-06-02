/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.gui;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.Cidade;
import projeto.modelo.to.Endereco;
import projeto.modelo.to.Fornecedor;

/**
 *
 * @author Daniel
 */
public class GuiFornecedorAlterar extends javax.swing.JFrame {
    public static Fachada fachada = new Fachada();
    /**
     * Creates new form GuiFornecedorAlterar
     */
    public GuiFornecedorAlterar() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
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
            java.util.logging.Logger.getLogger(GuiFornecedorAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedorAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedorAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedorAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GuiFornecedorAlterar().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelForAntigo = new javax.swing.JPanel();
        jLabelCNPJ = new javax.swing.JLabel();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jTextFieldSaidaRS = new javax.swing.JTextField();
        jLabelCEP = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelLogradouro = new javax.swing.JLabel();
        jFormattedTextFieldSaidaNumero = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSaidaCNPJ = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSaidaCEP = new javax.swing.JFormattedTextField();
        jTextFieldSaidaLog = new javax.swing.JTextField();
        jTextFieldSaidaCidade = new javax.swing.JTextField();
        jPanelForAtual = new javax.swing.JPanel();
        jLabelCNPJ1 = new javax.swing.JLabel();
        jLabelRazaoSocial1 = new javax.swing.JLabel();
        jTextFieldEntradaRS = new javax.swing.JTextField();
        jLabelCEP1 = new javax.swing.JLabel();
        jButtonPesquisaCNPJ = new javax.swing.JButton();
        jButtonPesquisaCEP = new javax.swing.JButton();
        jLabelCidade1 = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox();
        jButtonGerenciarCidade = new javax.swing.JButton();
        jLabelNumero1 = new javax.swing.JLabel();
        jLabelLogradouro1 = new javax.swing.JLabel();
        jButtonAlterarFornecedor = new javax.swing.JButton();
        jFormattedTextFieldEntradaNumero = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEntradaCNPJ = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEntradaCEP = new javax.swing.JFormattedTextField();
        jTextFieldEntradaLog = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelForAntigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor Antigo"));

        jLabelCNPJ.setText("CNPJ.:");

        jLabelRazaoSocial.setText("Razão Social.:");

        jTextFieldSaidaRS.setEditable(false);

        jLabelCEP.setText("CEP.:");

        jLabelCidade.setText("Cidade.:");

        jLabelNumero.setText("Número.:");

        jLabelLogradouro.setText("Logradouro.:");

        jFormattedTextFieldSaidaNumero.setEditable(false);
        jFormattedTextFieldSaidaNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0"))));

        jFormattedTextFieldSaidaCNPJ.setEditable(false);
        try {
            jFormattedTextFieldSaidaCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jFormattedTextFieldSaidaCEP.setEditable(false);
        try {
            jFormattedTextFieldSaidaCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTextFieldSaidaLog.setEditable(false);

        jTextFieldSaidaCidade.setEditable(false);

        javax.swing.GroupLayout jPanelForAntigoLayout = new javax.swing.GroupLayout(jPanelForAntigo);
        jPanelForAntigo.setLayout(jPanelForAntigoLayout);
        jPanelForAntigoLayout.setHorizontalGroup(
            jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForAntigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumero)
                    .addComponent(jLabelCEP)
                    .addComponent(jLabelCNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextFieldSaidaCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldSaidaCEP)
                    .addComponent(jFormattedTextFieldSaidaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRazaoSocial)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jLabelCidade))
                .addGap(18, 18, 18)
                .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSaidaCidade)
                    .addComponent(jTextFieldSaidaLog)
                    .addComponent(jTextFieldSaidaRS))
                .addContainerGap())
        );
        jPanelForAntigoLayout.setVerticalGroup(
            jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForAntigoLayout.createSequentialGroup()
                .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelForAntigoLayout.createSequentialGroup()
                        .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCNPJ)
                            .addComponent(jFormattedTextFieldSaidaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCEP)
                            .addComponent(jFormattedTextFieldSaidaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNumero)
                            .addComponent(jFormattedTextFieldSaidaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelForAntigoLayout.createSequentialGroup()
                        .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRazaoSocial)
                            .addComponent(jTextFieldSaidaRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLogradouro)
                            .addComponent(jTextFieldSaidaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAntigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCidade)
                            .addComponent(jTextFieldSaidaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanelForAtual.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor Atual"));

        jLabelCNPJ1.setText("CNPJ.:");

        jLabelRazaoSocial1.setText("Razão Social.:");

        jLabelCEP1.setText("CEP.:");

        jButtonPesquisaCNPJ.setText("Pesquisar");
        jButtonPesquisaCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCNPJActionPerformed(evt);
            }
        });

        jButtonPesquisaCEP.setText("Pesquisar");
        jButtonPesquisaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCEPActionPerformed(evt);
            }
        });

        jLabelCidade1.setText("Cidade.:");

        jButtonGerenciarCidade.setText("Gerenciar Cidade");
        jButtonGerenciarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarCidadeActionPerformed(evt);
            }
        });

        jLabelNumero1.setText("Número.:");

        jLabelLogradouro1.setText("Logradouro.:");

        jButtonAlterarFornecedor.setText("Alterar Fornecedor");
        jButtonAlterarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarFornecedorActionPerformed(evt);
            }
        });

        jFormattedTextFieldEntradaNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0"))));

        try {
            jFormattedTextFieldEntradaCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldEntradaCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelForAtualLayout = new javax.swing.GroupLayout(jPanelForAtual);
        jPanelForAtual.setLayout(jPanelForAtualLayout);
        jPanelForAtualLayout.setHorizontalGroup(
            jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForAtualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumero1)
                    .addComponent(jLabelCEP1)
                    .addComponent(jLabelCNPJ1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelForAtualLayout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldEntradaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabelCidade1))
                    .addComponent(jFormattedTextFieldEntradaCNPJ)
                    .addComponent(jFormattedTextFieldEntradaCEP))
                .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelForAtualLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabelRazaoSocial1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEntradaRS))
                    .addGroup(jPanelForAtualLayout.createSequentialGroup()
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelForAtualLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonPesquisaCNPJ)
                                    .addGroup(jPanelForAtualLayout.createSequentialGroup()
                                        .addComponent(jButtonPesquisaCEP)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelLogradouro1))))
                            .addGroup(jPanelForAtualLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelForAtualLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonGerenciarCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jButtonAlterarFornecedor))
                            .addGroup(jPanelForAtualLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jTextFieldEntradaLog)))))
                .addContainerGap())
        );
        jPanelForAtualLayout.setVerticalGroup(
            jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForAtualLayout.createSequentialGroup()
                .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelForAtualLayout.createSequentialGroup()
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCNPJ1)
                            .addComponent(jButtonPesquisaCNPJ)
                            .addComponent(jFormattedTextFieldEntradaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCEP1)
                            .addComponent(jButtonPesquisaCEP)
                            .addComponent(jFormattedTextFieldEntradaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNumero1)
                            .addComponent(jLabelCidade1)
                            .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGerenciarCidade)
                            .addComponent(jFormattedTextFieldEntradaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelForAtualLayout.createSequentialGroup()
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRazaoSocial1)
                            .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelForAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLogradouro1)
                            .addComponent(jTextFieldEntradaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlterarFornecedor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelForAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelForAntigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelForAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelForAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarComboCidade();
    }//GEN-LAST:event_formComponentShown

    private void jButtonPesquisaCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisaCNPJActionPerformed

    private void jButtonPesquisaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisaCEPActionPerformed

    private void jButtonGerenciarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGerenciarCidadeActionPerformed

    private void jButtonAlterarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAlterarFornecedorActionPerformed

    private void jTextFieldEntradaRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaRSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntradaRSActionPerformed
    
    private void pesquisarCNPJ() {
        String str_cnpj;
        String fornecedores_CNPJ;
        int resComCadastro;
        int resSemCadastro;
        try {
            str_cnpj = jFormattedTextFieldSaidaCNPJ.getText();
            str_cnpj = str_cnpj.replace('.', ' ');
            str_cnpj = str_cnpj.replace('/', ' ');
            str_cnpj = str_cnpj.replace('-', ' ');
            str_cnpj = str_cnpj.replaceAll(" ", "");
            fornecedores_CNPJ = str_cnpj;
            if ((fornecedores_CNPJ == null) || (fornecedores_CNPJ.equals(""))) {
                JOptionPane.showMessageDialog(null, "Digite o CNPJ!");
                jFormattedTextFieldSaidaCNPJ.requestFocus();
            } else {
                Fornecedor f = fachada.consultarForCNPJ(fornecedores_CNPJ);
                if (f != null) {
                    resComCadastro = JOptionPane.showConfirmDialog(null, "CNPJ já está cadastrado!\nDeseja alterar?", "", JOptionPane.YES_NO_OPTION);
                    if (resComCadastro == JOptionPane.YES_OPTION) {
                        jFormattedTextFieldSaidaCNPJ.requestFocus();
                    } else {
                        jTextFieldSaidaRS.requestFocus();
                    }
                } else {
                    resSemCadastro = JOptionPane.showConfirmDialog(null, "CNPJ não está cadastrado!\nDeseja continuar?", "", JOptionPane.YES_NO_OPTION);
                    if (resSemCadastro == JOptionPane.YES_OPTION) {
                        jTextFieldSaidaRS.requestFocus();
                    } else {
                        dispose();
                    }
                }
            }
        } catch (GeralException ex) {
            
        }
    }
    
    private void pesquisarCEP() {
        String str_cep;
        try {
            str_cep = jFormattedTextFieldSaidaCEP.getText();
            str_cep = str_cep.replace('-', ' ');
            str_cep = str_cep.replaceAll(" ", "");
            if ((str_cep == null) || (str_cep.equals(""))) {
                JOptionPane.showMessageDialog(null, "Digite o CEP!");
                jFormattedTextFieldSaidaCEP.requestFocus();
            } else {
                Endereco end = fachada.consultarEndCep(str_cep);
                if (end != null) {
                    jFormattedTextFieldSaidaCEP.setText(end.getEnderecos_CEP());
                    jTextFieldSaidaLog.setText(end.getEnderecos_Logradouro());
                } else {
                    jTextFieldSaidaLog.requestFocus();
                }
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
   
    private void alterarFornecedor() {
        
    }
    
    private void atualizarComboCidade() {
        Cidade cid;
        ArrayList<Cidade> listaCd;
        try {
            listaCd = (ArrayList<Cidade>) fachada.listarCidadeTudo();
            for (Iterator<Cidade> it = listaCd.iterator(); it.hasNext();) {
                cid = it.next();
                jComboBoxCidade.addItem(cid.getCidades_Nome());
            }
        } catch (GeralException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarFornecedor;
    private javax.swing.JButton jButtonGerenciarCidade;
    private javax.swing.JButton jButtonPesquisaCEP;
    private javax.swing.JButton jButtonPesquisaCNPJ;
    private javax.swing.JComboBox jComboBoxCidade;
    public javax.swing.JFormattedTextField jFormattedTextFieldEntradaCEP;
    public javax.swing.JFormattedTextField jFormattedTextFieldEntradaCNPJ;
    public javax.swing.JFormattedTextField jFormattedTextFieldEntradaNumero;
    public javax.swing.JFormattedTextField jFormattedTextFieldSaidaCEP;
    public javax.swing.JFormattedTextField jFormattedTextFieldSaidaCNPJ;
    public javax.swing.JFormattedTextField jFormattedTextFieldSaidaNumero;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCEP1;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCNPJ1;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelCidade1;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelLogradouro1;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelNumero1;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JLabel jLabelRazaoSocial1;
    private javax.swing.JPanel jPanelForAntigo;
    private javax.swing.JPanel jPanelForAtual;
    public javax.swing.JTextField jTextFieldEntradaLog;
    public javax.swing.JTextField jTextFieldEntradaRS;
    public javax.swing.JTextField jTextFieldSaidaCidade;
    public javax.swing.JTextField jTextFieldSaidaLog;
    public javax.swing.JTextField jTextFieldSaidaRS;
    // End of variables declaration//GEN-END:variables
}