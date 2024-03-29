/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.gui;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.Cidade;
import projeto.modelo.to.Fornecedor;

/**
 *
 * @author Daniel
 */
public class GuiFornecedor extends javax.swing.JDialog {

    private static ArrayList<Fornecedor> listaFornecedor = null;
    public static Fachada fachada = new Fachada();
    
    /**
     * Creates new form GuiFornecedor
     */
    public GuiFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public GuiFornecedor() {
        initComponents();
        setLocationRelativeTo(null);
        atualizarComboCidade();
        atualizarTabela();
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
            java.util.logging.Logger.getLogger(GuiFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                GuiFornecedor dialog = new GuiFornecedor(new javax.swing.JFrame(), true);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLista = new javax.swing.JPanel();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jScrollPaneFornecedor = new javax.swing.JScrollPane();
        jTableListaFornecedor = new javax.swing.JTable();
        jPanelFiltro = new javax.swing.JPanel();
        jLabelCNPJ = new javax.swing.JLabel();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jTextFieldEntradaRS = new javax.swing.JTextField();
        jLabelCEP = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox();
        jLabelLogradouro = new javax.swing.JLabel();
        jFormattedTextFieldEntradaCNPJ = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEntradaCEP = new javax.swing.JFormattedTextField();
        jTextFieldEntradaLog = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de fornecedores");
        setModal(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelLista.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista dos Fornecedores"));

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.setToolTipText("Atualizar lista de fornecedores");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.setToolTipText("Salvar novo fornecedor");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar o registro selecionado");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonApagar.setText("Apagar");
        jButtonApagar.setToolTipText("Excluir o registro selecionado");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        jTableListaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "CNPJ", "Razão Social", "Logradouro", "Número", "Cidade", "CEP"
            }
        ));
        jTableListaFornecedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableListaFornecedor.setShowHorizontalLines(false);
        jTableListaFornecedor.setShowVerticalLines(false);
        jScrollPaneFornecedor.setViewportView(jTableListaFornecedor);

        javax.swing.GroupLayout jPanelListaLayout = new javax.swing.GroupLayout(jPanelLista);
        jPanelLista.setLayout(jPanelListaLayout);
        jPanelListaLayout.setHorizontalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelListaLayout.setVerticalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListaLayout.createSequentialGroup()
                        .addComponent(jButtonAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonApagar)
                        .addGap(0, 111, Short.MAX_VALUE))
                    .addComponent(jScrollPaneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabelCNPJ.setText("CNPJ.:");

        jLabelRazaoSocial.setText("Razão Social.:");

        jTextFieldEntradaRS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEntradaRSKeyReleased(evt);
            }
        });

        jLabelCEP.setText("CEP.:");

        jLabelCidade.setText("Cidade.:");

        jComboBoxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadeActionPerformed(evt);
            }
        });

        jLabelLogradouro.setText("Logradouro.:");

        try {
            jFormattedTextFieldEntradaCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldEntradaCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldEntradaCNPJKeyReleased(evt);
            }
        });

        try {
            jFormattedTextFieldEntradaCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldEntradaCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldEntradaCEPKeyReleased(evt);
            }
        });

        jTextFieldEntradaLog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEntradaLogKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCNPJ)
                    .addComponent(jLabelCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextFieldEntradaCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldEntradaCEP))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelRazaoSocial)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jLabelCidade))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCidade, 0, 311, Short.MAX_VALUE)
                    .addComponent(jTextFieldEntradaLog)
                    .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCNPJ)
                            .addComponent(jLabelRazaoSocial)
                            .addComponent(jTextFieldEntradaRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCEP)
                            .addComponent(jLabelLogradouro)
                            .addComponent(jTextFieldEntradaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCidade)))
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldEntradaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldEntradaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        limparCampos();
        atualizarComboCidade();
        atualizarTabela();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        dispose();
        GuiFornecedorNovo fornecedor = new GuiFornecedorNovo();
        fornecedor.setVisible(true);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        alterarFornecedor();
        atualizarComboCidade();
        atualizarTabela();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        excluirFornecedor();
        atualizarComboCidade();
        atualizarTabela();
    }//GEN-LAST:event_jButtonApagarActionPerformed

    private void jTextFieldEntradaRSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEntradaRSKeyReleased
        pesquisarRazaoSocial();
    }//GEN-LAST:event_jTextFieldEntradaRSKeyReleased

    private void jComboBoxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadeActionPerformed
        pesquisarCidade((String) jComboBoxCidade.getSelectedItem());
    }//GEN-LAST:event_jComboBoxCidadeActionPerformed

    private void jFormattedTextFieldEntradaCNPJKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldEntradaCNPJKeyReleased
        pesquisarCNPJ();
    }//GEN-LAST:event_jFormattedTextFieldEntradaCNPJKeyReleased

    private void jFormattedTextFieldEntradaCEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldEntradaCEPKeyReleased
        pesquisarCEP();
    }//GEN-LAST:event_jFormattedTextFieldEntradaCEPKeyReleased

    private void jTextFieldEntradaLogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEntradaLogKeyReleased
        pesquisarLogradouro();
    }//GEN-LAST:event_jTextFieldEntradaLogKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarComboCidade();
        atualizarTabela();
    }//GEN-LAST:event_formComponentShown

    private void alterarFornecedor() {
        int resposta;
        try {
            Fornecedor fOld = listaFornecedor.get(jTableListaFornecedor.getSelectedRow());

            resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Alterar?", "", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                GuiFornecedorAlterar guiFornecedorAlterar = new GuiFornecedorAlterar();
                guiFornecedorAlterar.jFormattedTextFieldSaidaCNPJ.setText(fOld.getFornecedores_CNPJ());
                guiFornecedorAlterar.jTextFieldSaidaRS.setText(fOld.getFornecedores_RazaoSocial());
                guiFornecedorAlterar.jFormattedTextFieldSaidaCEP.setText(fOld.getEndereco().getEnderecos_CEP());
                guiFornecedorAlterar.jTextFieldSaidaLog.setText(fOld.getEndereco().getEnderecos_Logradouro());
                guiFornecedorAlterar.jFormattedTextFieldSaidaNumero.setText(String.valueOf(fOld.getFornecedores_NumeroResidencia()));
                guiFornecedorAlterar.jTextFieldSaidaCidade.setText(fOld.getEndereco().getCidade().getCidades_Nome());
                guiFornecedorAlterar.jFormattedTextFieldEntradaCNPJ.requestFocus();
                guiFornecedorAlterar.setVisible(true);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um Registro!");
        }
    }
    
    private void excluirFornecedor() {
        int resposta;

        try {
            Fornecedor f = listaFornecedor.get(jTableListaFornecedor.getSelectedRow());

            resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Apagar ?", "", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Fornecedor fConsult = fachada.consultarForCNPJ(f.getFornecedores_CNPJ());
                if (fConsult != null) {
                    fachada.excluirFornecedor(fConsult.getFornecedores_CNPJ());
                    limparCampos();
                }
            }else{
                limparCampos();
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um Registro!");
            limparCampos();
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void pesquisarCNPJ() {
        String str_cnpj;
        String fornecedores_CNPJ;
        try {
            str_cnpj = jFormattedTextFieldEntradaCNPJ.getText();
            str_cnpj = str_cnpj.replace('.', ' ');
            str_cnpj = str_cnpj.replace('/', ' ');
            str_cnpj = str_cnpj.replace('-', ' ');
            str_cnpj = str_cnpj.replaceAll(" ", "");
            fornecedores_CNPJ = str_cnpj;
            if ((fornecedores_CNPJ == null) || (fornecedores_CNPJ.equals(""))) {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedor();
            } else {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedorCNPJ(fornecedores_CNPJ);
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaFornecedor);
        jTableListaFornecedor.setModel(modelo);
    }
    
    private void pesquisarRazaoSocial() {
        try {
            if ((jTextFieldEntradaRS.getText() == null) || (jTextFieldEntradaRS.getText().equals(""))) {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedor();
            } else {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedorRazaoSocial(jTextFieldEntradaRS.getText());
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaFornecedor);
        jTableListaFornecedor.setModel(modelo);
    }
    
    private void pesquisarCEP() {
        String str_cep;
        String fornecedores_CEP;
        try {
            str_cep = jFormattedTextFieldEntradaCEP.getText();
            str_cep = str_cep.replace('-', ' ');
            str_cep = str_cep.replaceAll(" ", "");
            fornecedores_CEP = str_cep;
            if ((fornecedores_CEP == null) || (fornecedores_CEP.equals(""))) {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedor();
            } else {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedorCEP(fornecedores_CEP);
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaFornecedor);
        jTableListaFornecedor.setModel(modelo);
    }
    
    private void pesquisarLogradouro() {
        try {
            if ((jTextFieldEntradaLog.getText() == null) || (jTextFieldEntradaLog.getText().equals(""))) {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedor();
            } else {
                listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedorLog(jTextFieldEntradaLog.getText());
            }
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaFornecedor);
        jTableListaFornecedor.setModel(modelo);
    }
    
    private void pesquisarCidade(String cidades_Nome) {
        try{
            listaFornecedor = ( ArrayList<Fornecedor>)fachada.listarFornecedorCidade(cidades_Nome);
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaFornecedor);
        jTableListaFornecedor.setModel(modelo);
    }
    
    public static void atualizarTabela() {
        try {
            listaFornecedor = (ArrayList<Fornecedor>) fachada.listarFornecedor();
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaFornecedor);
        jTableListaFornecedor.setModel(modelo);
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
    
    private void limparCampos() {
        jFormattedTextFieldEntradaCNPJ.setValue(null);
        jFormattedTextFieldEntradaCEP.setValue(null);
        jTextFieldEntradaRS.setText("");
        jTextFieldEntradaLog.setText("");
        jFormattedTextFieldEntradaCNPJ.requestFocus();
    }
    
    private static DefaultTableModel geramodelo(ArrayList<Fornecedor> listaFornecedor) {
        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        modelo.addColumn("CNPJ");
        modelo.addColumn("Razão Social");
        modelo.addColumn("Logradouro");
        modelo.addColumn("Número");
        modelo.addColumn("Cidade");
        modelo.addColumn("CEP");

        ArrayList<String> valores;
        int i = 0;
        for (Fornecedor f : listaFornecedor) {
            valores = new ArrayList<String>();
            valores.add(f.getFornecedores_CNPJ());
            valores.add(f.getFornecedores_RazaoSocial());
            valores.add(f.getEndereco().getEnderecos_Logradouro());
            valores.add(String.valueOf(f.getFornecedores_NumeroResidencia()));
            valores.add(f.getEndereco().getCidade().getCidades_Nome());
            valores.add(f.getEndereco().getEnderecos_CEP());
            modelo.insertRow(i, valores.toArray());
            i++;
        }
        return modelo;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldEntradaCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldEntradaCNPJ;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JScrollPane jScrollPaneFornecedor;
    private static javax.swing.JTable jTableListaFornecedor;
    private javax.swing.JTextField jTextFieldEntradaLog;
    private javax.swing.JTextField jTextFieldEntradaRS;
    // End of variables declaration//GEN-END:variables
}
