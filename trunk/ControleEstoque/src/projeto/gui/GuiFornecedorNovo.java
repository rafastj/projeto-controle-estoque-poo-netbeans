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

/**
 *
 * @author Daniel
 */
public class GuiFornecedorNovo extends javax.swing.JFrame {
    public static Fachada fachada = new Fachada();
    /**
     * Creates new form GuiFornecedorNovo
     */
    public GuiFornecedorNovo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFiltro = new javax.swing.JPanel();
        jLabelCNPJ = new javax.swing.JLabel();
        jTextFieldEntradaCNPJ = new javax.swing.JTextField();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jTextFieldEntradaRS = new javax.swing.JTextField();
        jLabelCEP = new javax.swing.JLabel();
        jTextFieldEntradaCEP = new javax.swing.JTextField();
        jTextFieldEntradaLog = new javax.swing.JTextField();
        jButtonPesquisaCNPJ = new javax.swing.JButton();
        jButtonPesquisaRS = new javax.swing.JButton();
        jButtonPesquisaCEP = new javax.swing.JButton();
        jLabelCidade = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox();
        jButtonIncluirCidade = new javax.swing.JButton();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldEntradaNumero = new javax.swing.JTextField();
        jButtonPesquisaLog = new javax.swing.JButton();
        jLabelLogradouro = new javax.swing.JLabel();
        jButtonSalvarFornecedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Fornecedor");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabelCNPJ.setText("CNPJ.:");

        jLabelRazaoSocial.setText("Razão Social.:");

        jLabelCEP.setText("CEP.:");

        jTextFieldEntradaLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntradaLogActionPerformed(evt);
            }
        });

        jButtonPesquisaCNPJ.setText("...");
        jButtonPesquisaCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCNPJActionPerformed(evt);
            }
        });

        jButtonPesquisaRS.setText("...");

        jButtonPesquisaCEP.setText("...");
        jButtonPesquisaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCEPActionPerformed(evt);
            }
        });

        jLabelCidade.setText("Cidade.:");

        jButtonIncluirCidade.setText("Incluir Cidade");
        jButtonIncluirCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirCidadeActionPerformed(evt);
            }
        });

        jLabelNumero.setText("Número.:");

        jTextFieldEntradaNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntradaNumeroActionPerformed(evt);
            }
        });

        jButtonPesquisaLog.setText("...");

        jLabelLogradouro.setText("Logradouro.:");

        jButtonSalvarFornecedor.setText("Salvar Fornecedor");

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCNPJ)
                            .addComponent(jLabelCEP))
                        .addGap(22, 22, 22)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                                .addComponent(jTextFieldEntradaCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisaCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelLogradouro))
                            .addComponent(jTextFieldEntradaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                                .addComponent(jTextFieldEntradaLog, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisaLog)
                                .addGap(25, 25, 25)
                                .addComponent(jLabelNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldEntradaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                                .addComponent(jButtonPesquisaCNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelRazaoSocial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisaRS)))
                        .addContainerGap())
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonIncluirCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvarFornecedor))))
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEntradaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCNPJ)
                    .addComponent(jLabelRazaoSocial)
                    .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisaCNPJ)
                    .addComponent(jButtonPesquisaRS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCEP)
                            .addComponent(jTextFieldEntradaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEntradaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisaCEP)
                            .addComponent(jButtonPesquisaLog)
                            .addComponent(jLabelLogradouro))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEntradaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalvarFornecedor)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCidade)
                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonIncluirCidade)))
                .addContainerGap())
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
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Cidade cid;
        ArrayList<Cidade> listaCd;
        try {
            listaCd = (ArrayList<Cidade>) fachada.listarCidade();
            for (Iterator<Cidade> it = listaCd.iterator(); it.hasNext();) {
                cid = it.next();
                jComboBoxCidade.addItem(cid.getCidades_Nome());
            }
        } catch (GeralException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_formComponentShown

    private void jTextFieldEntradaLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntradaLogActionPerformed

    private void jButtonIncluirCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirCidadeActionPerformed
        GuiCidadeNova cidade = new GuiCidadeNova();
        cidade.setVisible(true);
    }//GEN-LAST:event_jButtonIncluirCidadeActionPerformed

    private void jTextFieldEntradaNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntradaNumeroActionPerformed

    private void jButtonPesquisaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCEPActionPerformed
        String enderecos_CEP;
        String enderecos_Logradouro;
        try {
            enderecos_CEP = jTextFieldEntradaCEP.getText();
            Endereco end = fachada.consultarEndCep(enderecos_CEP);
            enderecos_Logradouro = end.getEnderecos_Logradouro();
            if (end != null) {
                jTextFieldEntradaCEP.setText(enderecos_CEP);
                jTextFieldEntradaLog.setText(enderecos_Logradouro);
            } else {
                jTextFieldEntradaLog.requestFocus();
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            jTextFieldEntradaCEP.requestFocus();
        }
    }//GEN-LAST:event_jButtonPesquisaCEPActionPerformed

    private void jButtonPesquisaCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCNPJActionPerformed
        
    }//GEN-LAST:event_jButtonPesquisaCNPJActionPerformed

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
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GuiFornecedorNovo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirCidade;
    private javax.swing.JButton jButtonPesquisaCEP;
    private javax.swing.JButton jButtonPesquisaCNPJ;
    private javax.swing.JButton jButtonPesquisaLog;
    private javax.swing.JButton jButtonPesquisaRS;
    private javax.swing.JButton jButtonSalvarFornecedor;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JTextField jTextFieldEntradaCEP;
    private javax.swing.JTextField jTextFieldEntradaCNPJ;
    private javax.swing.JTextField jTextFieldEntradaLog;
    private javax.swing.JTextField jTextFieldEntradaNumero;
    private javax.swing.JTextField jTextFieldEntradaRS;
    // End of variables declaration//GEN-END:variables
}
