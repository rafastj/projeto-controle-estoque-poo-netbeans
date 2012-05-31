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
import projeto.modelo.to.Endereco;

/**
 *
 * @author Daniel
 */
public class GuiEndereco extends javax.swing.JFrame {

    ArrayList<Endereco> listaEndereco = null;
    public static Fachada fachada = new Fachada();

    /**
     * Creates new form GuiEndereco
     */
    public GuiEndereco() {
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
        jLabelCEP = new javax.swing.JLabel();
        jTextFieldEntradaCep = new javax.swing.JTextField();
        jLabelLogradouro = new javax.swing.JLabel();
        jTextFieldEntradaLog = new javax.swing.JTextField();
        jLabelCidade = new javax.swing.JLabel();
        jButtonPesquisaLog = new javax.swing.JButton();
        jButtonPesquisaCEP = new javax.swing.JButton();
        jButtonPesquisaCidade = new javax.swing.JButton();
        jComboBoxCidade = new javax.swing.JComboBox();
        jPanelEndereco = new javax.swing.JPanel();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaEndereco = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Endereço");
        setName("frameEndereco");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabelCEP.setText("CEP.:");

        jLabelLogradouro.setText("Logradouro.:");

        jLabelCidade.setText("Cidade.:");

        jButtonPesquisaLog.setText("Filtrar");
        jButtonPesquisaLog.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonPesquisaLog.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonPesquisaLog.setPreferredSize(new java.awt.Dimension(75, 23));
        jButtonPesquisaLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaLogActionPerformed(evt);
            }
        });

        jButtonPesquisaCEP.setText("Filtrar");
        jButtonPesquisaCEP.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonPesquisaCEP.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonPesquisaCEP.setPreferredSize(new java.awt.Dimension(75, 23));
        jButtonPesquisaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCEPActionPerformed(evt);
            }
        });

        jButtonPesquisaCidade.setText("Filtrar");
        jButtonPesquisaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaCidadeActionPerformed(evt);
            }
        });

        jComboBoxCidade.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCEP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCidade)
                            .addComponent(jLabelLogradouro))
                        .addGap(8, 8, 8)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEntradaCep, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jTextFieldEntradaLog)
                            .addComponent(jComboBoxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonPesquisaLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jButtonPesquisaCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPesquisaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCEP)
                    .addComponent(jTextFieldEntradaCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jTextFieldEntradaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPesquisaCidade)
                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCidade))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonNovo.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonAlterar.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonAlterar.setPreferredSize(new java.awt.Dimension(75, 23));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonApagar.setText("Apagar");
        jButtonApagar.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonApagar.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonApagar.setPreferredSize(new java.awt.Dimension(75, 23));
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        jTableListaEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "CEP", "Logradouro", "Cidade"
            }
        ));
        jTableListaEndereco.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableListaEndereco);

        javax.swing.GroupLayout jPanelEnderecoLayout = new javax.swing.GroupLayout(jPanelEndereco);
        jPanelEndereco.setLayout(jPanelEnderecoLayout);
        jPanelEnderecoLayout.setHorizontalGroup(
            jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonApagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEnderecoLayout.setVerticalGroup(
            jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                        .addComponent(jButtonAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(GuiEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GuiEndereco().setVisible(true);
            }
        });
    }
    
    /**
     * Ao ser exibido, o formulário seta o foco no 'jTextField' do CEP, e atualiza a tabela e o comboBox;
     * @param evt 
     */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jTextFieldEntradaCep.requestFocus();
        atualizarComboCidade();
        listaTabelaEndereco();
    }//GEN-LAST:event_formComponentShown
    
    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        jTextFieldEntradaCep.requestFocus();
        listaTabelaEndereco();
        atualizarComboCidade();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed
    
    /**
     * Chama a GuiEnderecoNovo;
     */
    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        GuiEnderecoNovo novoEnd = new GuiEnderecoNovo();
        novoEnd.setVisible(true);
    }//GEN-LAST:event_jButtonNovoActionPerformed
    
    /**
     * Chama o método 'apagarEndereco();'
     */
    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        jTextFieldEntradaCep.requestFocus();
        apagarEndereco();
        listaTabelaEndereco();
        atualizarComboCidade();
    }//GEN-LAST:event_jButtonApagarActionPerformed
    
    /**
     * Filtra os registros da tabela pelo CEP;
     */
    private void jButtonPesquisaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisaCEPActionPerformed
    
    /**
     * Filtra os registros da tabela pelo nome da Cidade;
     */
    private void jButtonPesquisaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisaCidadeActionPerformed
    
    /**
     * Filtra os registros da tabela pelo Logradouro;
     */
    private void jButtonPesquisaLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisaLogActionPerformed
    
    /**
     * Chama a GuiEnderecoAlterar;
     */
    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        GuiEnderecoAlterar altEnd = new GuiEnderecoAlterar();
        altEnd.setVisible(true);
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    /**
     * Define o padrão da tabela e insere os dados da tabela Endereco em um ArrayList;
     * @param listaEndereco
     * @return 
     */
    private DefaultTableModel geramodelo(ArrayList<Endereco> listaEndereco) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CEP");
        modelo.addColumn("Logradouro");
        modelo.addColumn("Cidade");

        ArrayList<String> valores;
        int i = 0;
        for (Endereco end : listaEndereco) {
            valores = new ArrayList<String>();
            valores.add(end.getEnderecos_CEP());
            valores.add(end.getEnderecos_Logradouro());
            valores.add(end.getCidades_Nome());
            modelo.insertRow(i, valores.toArray());
            i++;
        }
        return modelo;
    }

    /**
     * Método para atualizar a lista de cidades no 'jComboBoxCidade';
     */
    public void atualizarComboCidade () {
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
    
    /**
     * Método para listar todos os registros da tabela Endereco;
     */
    public void listaTabelaEndereco() {
         //MOSTRAR TODOS OS REGISTRO DE PRODUTOS
        //ArrayList<Produto> listaProduto = null;
        try {
            listaEndereco = (ArrayList<Endereco>) fachada.listarEndereco();
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaEndereco);
        jTableListaEndereco.setModel(modelo);
    }
    
    /**
     * Método para apagar um registro selecionado na tabela;
     */
    private void apagarEndereco() {
        int resposta;
        try {
            Endereco end = listaEndereco.get(jTableListaEndereco.getSelectedRow());

            resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Apagar ?", "", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Endereco endConsult = fachada.consultarEndCep(end.getEnderecos_CEP());
                if (endConsult != null) {
                    fachada.excluirEndereco(endConsult.getEnderecos_CEP());
                    JOptionPane.showMessageDialog(null, "Registro excluído!");
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione o endereço!");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisaCEP;
    private javax.swing.JButton jButtonPesquisaCidade;
    private javax.swing.JButton jButtonPesquisaLog;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JPanel jPanelEndereco;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaEndereco;
    private javax.swing.JTextField jTextFieldEntradaCep;
    private javax.swing.JTextField jTextFieldEntradaLog;
    // End of variables declaration//GEN-END:variables
}