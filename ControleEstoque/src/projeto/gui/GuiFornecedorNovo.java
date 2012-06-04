/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.gui;

import javax.swing.JOptionPane;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.Endereco;
import projeto.modelo.to.Fornecedor;
import projeto.validaCampo.ValidaCampo;

/**
 *
 * @author Daniel
 */
public class GuiFornecedorNovo extends javax.swing.JDialog {

    public static Fachada fachada = new Fachada();

    /**
     * Creates new form GuiFornecedorNovo
     */
    public GuiFornecedorNovo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public GuiFornecedorNovo() {
        initComponents();
        setLocationRelativeTo(null);
        bloquearTela();
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
            java.util.logging.Logger.getLogger(GuiFornecedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                GuiFornecedorNovo dialog = new GuiFornecedorNovo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "CallToThreadDumpStack"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFiltro = new javax.swing.JPanel();
        jLabelCNPJ = new javax.swing.JLabel();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jTextFieldEntradaRS = new javax.swing.JTextField();
        jLabelCEP = new javax.swing.JLabel();
        jButtonPesquisaCNPJ = new javax.swing.JButton();
        jButtonPesquisaCEP = new javax.swing.JButton();
        jLabelCidade = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelLogradouro = new javax.swing.JLabel();
        jButtonSalvarFornecedor = new javax.swing.JButton();
        jFormattedTextFieldEntradaCNPJ = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEntradaCEP = new javax.swing.JFormattedTextField();
        jTextFieldEntradaLog = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldEntradaNumero = new projeto.modelo.componente.SoNumero();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salvar novo fornecedor");
        setModal(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabelCNPJ.setText("CNPJ.:");

        jLabelRazaoSocial.setText("Razão Social.:");

        jLabelCEP.setText("CEP.:");

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

        jLabelCidade.setText("Cidade.:");

        jLabelNumero.setText("Número.:");

        jLabelLogradouro.setText("Logradouro.:");

        jButtonSalvarFornecedor.setText("Salvar Fornecedor");
        jButtonSalvarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarFornecedorActionPerformed(evt);
            }
        });

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

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumero)
                    .addComponent(jLabelCEP)
                    .addComponent(jLabelCNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextFieldEntradaCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldEntradaCEP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPesquisaCNPJ)
                            .addComponent(jButtonPesquisaCEP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRazaoSocial)
                            .addComponent(jLabelLogradouro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jTextFieldEntradaLog)))
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jTextFieldEntradaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvarFornecedor)))
                .addContainerGap())
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCNPJ)
                        .addComponent(jFormattedTextFieldEntradaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPesquisaCNPJ))
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRazaoSocial)
                            .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLogradouro)
                            .addComponent(jFormattedTextFieldEntradaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCEP)
                            .addComponent(jTextFieldEntradaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisaCEP))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvarFornecedor)
                            .addComponent(jLabelCidade)
                            .addComponent(jLabelNumero)
                            .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonVoltar)
                            .addComponent(jTextFieldEntradaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisaCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCNPJActionPerformed
        pesquisarCNPJ();
    }//GEN-LAST:event_jButtonPesquisaCNPJActionPerformed

    private void jButtonPesquisaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCEPActionPerformed
        pesquisarCEP();
    }//GEN-LAST:event_jButtonPesquisaCEPActionPerformed

    private void jButtonSalvarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarFornecedorActionPerformed
        salvarFornecedor();
    }//GEN-LAST:event_jButtonSalvarFornecedorActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //
    }//GEN-LAST:event_formComponentShown

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
        voltar();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void salvarFornecedor() {
        try {
            try {
                Fornecedor fSalvar = new Fornecedor();
                fSalvar.setFornecedores_CNPJ(jFormattedTextFieldEntradaCNPJ.getText());
                fSalvar.setFornecedores_RazaoSocial(jTextFieldEntradaRS.getText());
                fSalvar.setEnderecos_CEP(jFormattedTextFieldEntradaCEP.getText());
                fSalvar.setEnderecos_Logradouro(jTextFieldEntradaLog.getText());
                fSalvar.setFornecedores_NumeroResidencia(Integer.parseInt(jTextFieldEntradaNumero.getText()));
                fSalvar.setCidades_Nome(jTextFieldCidade.getText());
                dispose();
                fachada.salvarFornecedor(fSalvar);
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite o número!");
                jTextFieldEntradaNumero.requestFocus();
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void pesquisarCNPJ() {
        String str_cnpj;
        String fornecedores_CNPJ;
        int resComCadastro;
        int resSemCadastro;
        try {
            str_cnpj = jFormattedTextFieldEntradaCNPJ.getText();
            str_cnpj = str_cnpj.replace('.', ' ');
            str_cnpj = str_cnpj.replace('/', ' ');
            str_cnpj = str_cnpj.replace('-', ' ');
            str_cnpj = str_cnpj.replaceAll(" ", "");
            fornecedores_CNPJ = str_cnpj;
            if ((fornecedores_CNPJ == null) || (fornecedores_CNPJ.equals(""))) {
                JOptionPane.showMessageDialog(null, "Digite o CNPJ!");
                bloquearTela();
            } else {
                if (ValidaCampo.validaCNPJ(fornecedores_CNPJ) == true) {
                    Fornecedor f = fachada.consultarForCNPJ(fornecedores_CNPJ);
                    if (f != null) {
                        resComCadastro = JOptionPane.showConfirmDialog(null, "\nCNPJ já está cadastrado!\n\nDeseja inserir outro?", "", JOptionPane.YES_NO_OPTION);
                        if (resComCadastro == JOptionPane.YES_OPTION) {
                            bloquearTela();
                        } else {
                            dispose();
                            voltar();
                        }
                    } else {
                        resSemCadastro = JOptionPane.showConfirmDialog(null, "\nCNPJ não está cadastrado! Deseja continuar?\n\nSe não informe outro CNPJ.", "", JOptionPane.YES_NO_OPTION);
                        if (resSemCadastro == JOptionPane.YES_OPTION) {
                            liberarTela();
                        } else {
                            bloquearTela();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CNPJ inválido!");
                    bloquearTela();
                }
            }
        } catch (GeralException ex) {
        }
    }

    private void pesquisarCEP() {
        int resComCep;
        int resSemCep;
        String str_cep;
        String enderecos_CEP;
        String rs;
        String cnpj;
        Endereco end;
        try {
            str_cep = jFormattedTextFieldEntradaCEP.getText();
            str_cep = str_cep.replace('-', ' ');
            str_cep = str_cep.replaceAll(" ", "");
            enderecos_CEP = str_cep;
            if ((enderecos_CEP == null) || (enderecos_CEP.equals(""))) {
                JOptionPane.showMessageDialog(null, "Digite o CEP!");
                bloquearTela();
            } else {
                end = fachada.consultarEndCep(enderecos_CEP);
                if (end != null) {
                    resComCep = JOptionPane.showConfirmDialog(null, "CEP já cadastrado. Deseja utilizá-lo?\nSe não informe outro CEP.", "", JOptionPane.YES_NO_OPTION);
                    if (resComCep == JOptionPane.YES_OPTION) {
                        jFormattedTextFieldEntradaCEP.setText(end.getEnderecos_CEP());
                        jTextFieldEntradaLog.setText(end.getEnderecos_Logradouro());
                        jTextFieldCidade.setText(end.getCidades_Nome());
                        jTextFieldEntradaNumero.requestFocus();
                    } else {
                        jFormattedTextFieldEntradaCEP.requestFocus();
                        jFormattedTextFieldEntradaCEP.setValue(null);
                    }
                } else {
                    resSemCep = JOptionPane.showConfirmDialog(null, "CEP não está cadastrado. Deseja cadastrar?\nSe não informe outro CEP.", "", JOptionPane.YES_NO_OPTION);
                    cnpj = jFormattedTextFieldEntradaCNPJ.getText();
                    rs = jTextFieldEntradaRS.getText();
                    if (resSemCep == JOptionPane.YES_OPTION) {
                        dispose();
                        GuiEnderecoNovo guiEnderecoNovo = new GuiEnderecoNovo();
                        GuiEnderecoNovo.jFormattedTextFieldCEP.setText(enderecos_CEP);
                        GuiEnderecoNovo.jTextFieldEntradaLog.requestFocus();
                        GuiEnderecoNovo.liberarTela();
                        guiEnderecoNovo.setVisible(true);
                        end = fachada.consultarEndCep(enderecos_CEP);
                        GuiFornecedorNovo guiFornecedorNovo = new GuiFornecedorNovo();
                        liberarTela();
                        GuiFornecedorNovo.jFormattedTextFieldEntradaCNPJ.setText(cnpj);
                        GuiFornecedorNovo.jTextFieldEntradaRS.setText(rs);
                        GuiFornecedorNovo.jFormattedTextFieldEntradaCEP.setText(enderecos_CEP);
                        GuiFornecedorNovo.jTextFieldEntradaLog.setText(end.getEnderecos_Logradouro());
                        GuiFornecedorNovo.jTextFieldCidade.setText(end.getCidades_Nome());
                        jTextFieldEntradaNumero.requestFocus();
                        guiFornecedorNovo.setVisible(true);
                    } else {
                        dispose();
                        GuiFornecedorNovo guiFornecedorNovo = new GuiFornecedorNovo();
                        GuiFornecedorNovo.jFormattedTextFieldEntradaCNPJ.setText(cnpj);
                        GuiFornecedorNovo.jTextFieldEntradaRS.setText(rs);
                        liberarTela();
                        jFormattedTextFieldEntradaCEP.requestFocus();
                        guiFornecedorNovo.setVisible(true);
                    }
                }
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void limparCampos() {
        //limpar os edits
        jFormattedTextFieldEntradaCNPJ.setText("");
        jTextFieldEntradaRS.setText("");
        jTextFieldEntradaNumero.setText("");
        jFormattedTextFieldEntradaCEP.setText("");
        jTextFieldEntradaLog.setText("");
    }

    public static void liberarTela() {
        jTextFieldEntradaRS.setEnabled(true);
        jFormattedTextFieldEntradaCEP.setEnabled(true);
        jButtonPesquisaCEP.setEnabled(true);
        jTextFieldEntradaNumero.setEnabled(true);
        jButtonSalvarFornecedor.setEnabled(true);
        jTextFieldEntradaRS.requestFocus();
    }

    public static void bloquearTela() {
        jTextFieldEntradaRS.setEnabled(false);
        jFormattedTextFieldEntradaCEP.setEnabled(false);
        jButtonPesquisaCEP.setEnabled(false);
        jTextFieldEntradaLog.setEnabled(false);
        jTextFieldEntradaNumero.setEnabled(false);
        jTextFieldCidade.setEnabled(false);
        jButtonSalvarFornecedor.setEnabled(false);
        jFormattedTextFieldEntradaCNPJ.requestFocus();
        jFormattedTextFieldEntradaCNPJ.setValue(null);
    }

    public static void voltar() {
        GuiFornecedor guiFornecedor = new GuiFornecedor();
        guiFornecedor.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButtonPesquisaCEP;
    private static javax.swing.JButton jButtonPesquisaCNPJ;
    private static javax.swing.JButton jButtonSalvarFornecedor;
    private javax.swing.JButton jButtonVoltar;
    public static javax.swing.JFormattedTextField jFormattedTextFieldEntradaCEP;
    public static javax.swing.JFormattedTextField jFormattedTextFieldEntradaCNPJ;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JPanel jPanelFiltro;
    public static javax.swing.JTextField jTextFieldCidade;
    public static javax.swing.JTextField jTextFieldEntradaLog;
    public static javax.swing.JTextField jTextFieldEntradaNumero;
    public static javax.swing.JTextField jTextFieldEntradaRS;
    // End of variables declaration//GEN-END:variables
}