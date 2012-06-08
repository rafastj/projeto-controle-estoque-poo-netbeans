/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.*;

/**
 *
 * @author diego
 */
public class GuiNotaFiscal_Produto extends javax.swing.JDialog {
    
    ArrayList<Produto> listaProduto = null;
    
    Fachada fachada = new Fachada(); 
    /**
     * Creates new form GuiNotaFiscal_Produto
     */
    public GuiNotaFiscal_Produto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);//mostra no centro da tela
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jcDescricaoField = new javax.swing.JTextField();
        jconsulDescricao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSegmentoBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTipoBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jMarcaBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jQTDEField = new projeto.modelo.componente.SoNumero();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaProduto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        JcProdutoselecionado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JcMarca = new javax.swing.JTextField();
        jPNF = new javax.swing.JPanel();
        jLNotaFiscal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel8.setText("Descrição.:");

        jcDescricaoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcDescricaoFieldKeyPressed(evt);
            }
        });

        jconsulDescricao.setText("...");
        jconsulDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jconsulDescricaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Segmento.:");

        jSegmentoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSegmentoBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo.:");

        jTipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTipoBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca.:");

        jMarcaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMarcaBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMarcaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSegmentoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcDescricaoField)
                        .addGap(18, 18, 18)
                        .addComponent(jconsulDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcDescricaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jconsulDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jSegmentoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jMarcaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jTabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Descição", "Valor Unit.", "Qtde Disp.", "Marca", "Tipo", "Segmento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTabelaProduto.getTableHeader().setReorderingAllowed(false);
        jTabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaProdutoMouseClicked(evt);
            }
        });
        jTabelaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabelaProdutoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaProduto);
        jTabelaProduto.getColumnModel().getColumn(0).setResizable(false);
        jTabelaProduto.getColumnModel().getColumn(1).setResizable(false);
        jTabelaProduto.getColumnModel().getColumn(2).setResizable(false);
        jTabelaProduto.getColumnModel().getColumn(3).setResizable(false);
        jTabelaProduto.getColumnModel().getColumn(4).setResizable(false);
        jTabelaProduto.getColumnModel().getColumn(5).setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("Produto selecionado.:");

        JcProdutoselecionado.setBackground(new java.awt.Color(204, 204, 204));
        JcProdutoselecionado.setEditable(false);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Quantidade.:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("Marca.:");

        JcMarca.setBackground(new java.awt.Color(204, 204, 204));
        JcMarca.setEditable(false);

        jPNF.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota Fiscal"));

        jLNotaFiscal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLNotaFiscal.setForeground(new java.awt.Color(0, 153, 0));
        jLNotaFiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLNotaFiscal.setText("NF");

        javax.swing.GroupLayout jPNFLayout = new javax.swing.GroupLayout(jPNF);
        jPNF.setLayout(jPNFLayout);
        jPNFLayout.setHorizontalGroup(
            jPNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLNotaFiscal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPNFLayout.setVerticalGroup(
            jPNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLNotaFiscal)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jQTDEField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JcProdutoselecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcMarca)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JcMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(JcProdutoselecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jQTDEField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jLabel3))
                    .addComponent(jPNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        //ATIVAR O FILTRO
        atualizarFiltro();
        
        //ATUALIZAR A TABELA
        atualizarTabela();
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void jconsulDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jconsulDescricaoActionPerformed
        // TODO add your handling code here:
        pesquisarDescricao();
    }//GEN-LAST:event_jconsulDescricaoActionPerformed

    private void jcDescricaoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcDescricaoFieldKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisarDescricao();
        }
    }//GEN-LAST:event_jcDescricaoFieldKeyPressed

    private void jMarcaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMarcaBoxActionPerformed
        // TODO add your handling code here:
         pesquisarMarca((String) jMarcaBox.getSelectedItem());//joga a descrição da marca selecionada
    }//GEN-LAST:event_jMarcaBoxActionPerformed

    private void jTipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoBoxActionPerformed
        // TODO add your handling code here:
        pesquisarTipo((String) jTipoBox.getSelectedItem());
    }//GEN-LAST:event_jTipoBoxActionPerformed

    private void jSegmentoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSegmentoBoxActionPerformed
        // TODO add your handling code here:
        pesquisarSegmento((String) jSegmentoBox.getSelectedItem());
    }//GEN-LAST:event_jSegmentoBoxActionPerformed

    private void jTabelaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabelaProdutoKeyPressed
        // TODO add your handling code here:
        itemSelecionado();
    }//GEN-LAST:event_jTabelaProdutoKeyPressed

    private void jTabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaProdutoMouseClicked
        // TODO add your handling code here:
        itemSelecionado();
    }//GEN-LAST:event_jTabelaProdutoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int resposta;//se vai YES ou NO
        
        try{
            //PEGAR O CODIGO DO PRODUTO NA CONSULTA
            Produto p = fachada.consultarProduto(JcProdutoselecionado.getText());
            //SALVAR ESSE PRODUTO NESTA NOTA
            fachada.salvarNotaFiscal_Produto(Integer.parseInt(jLNotaFiscal.getText()), p.getProdutos_Codigo(),Integer.parseInt(jQTDEField.getText()));
            
            //PEGUNTA!
            resposta = JOptionPane.showConfirmDialog(null, "Deseja incluir outro produto ?", "", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                limparcamposelecionado();
            }else{
            dispose();//fecha a tela!
            }
        }catch (GeralException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());  
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GuiNotaFiscal_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiNotaFiscal_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiNotaFiscal_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiNotaFiscal_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GuiNotaFiscal_Produto dialog = new GuiNotaFiscal_Produto(new javax.swing.JFrame(), true);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField JcMarca;
    public javax.swing.JTextField JcProdutoselecionado;
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLNotaFiscal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jMarcaBox;
    private javax.swing.JPanel jPNF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jQTDEField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jSegmentoBox;
    private javax.swing.JTable jTabelaProduto;
    private javax.swing.JComboBox jTipoBox;
    private javax.swing.JTextField jcDescricaoField;
    private javax.swing.JButton jconsulDescricao;
    // End of variables declaration//GEN-END:variables

    //MODELO DA TABELA DE ITEM DA NOTA FISCAL
    private DefaultTableModel geramodelo(ArrayList<Produto> listaProduto) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Descrição","Valor Unit.","Qtde","Marca","Tipo","Segmento"},0){
            
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        ArrayList<String> valores;
        int i = 0;
        for (Produto p : listaProduto) {
            valores = new ArrayList<String>();
            valores.add(p.getProdutos_Descricao());
            //recebe a conversão de double para string incluindo no formato Moeda
            String valorVenda = formaMoeda(p.getProdutos_ValorVenda());
            valores.add(valorVenda);
            valores.add(Integer.toString(p.getProdutos_Quantidade()));
            valores.add(p.getMarcas().getMarcas_Descricao());
            valores.add(p.getTipo().getTipos_Descricao());
            valores.add(p.getSegmentos().getSegmentos_Descricao());
            modelo.insertRow(i, valores.toArray());
            i++;
        }
        return modelo;
    }
    
    //FORMATA O VALOR PARA VALOR REAL
    private String formaMoeda (double valorMoeda){
        java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
        return df.format(valorMoeda);
    }
    
    //LISTAR TODOS OS PRODUTOS
     public void atualizarTabela(){
         try{
            listaProduto = ( ArrayList<Produto>)fachada.listaProdutoTudo();
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jTabelaProduto.setModel(modelo); 
    }
     
    //ATIVAR O FILTRO E LISTAR TODOS OS POSSIVEIS (SEGMENTOS, MARCAS E TIPOS)
    private void atualizarFiltro(){

        //LISTA DO SEGMENTO
       Segmento sg;
       ArrayList<Segmento> listasg;
	try{
		//Lista dos os segmentos
		listasg = (ArrayList<Segmento>)fachada.listarSegmentos("");
		for(Iterator<Segmento> it = listasg.iterator(); it.hasNext();){
                    sg = it.next();
                    jSegmentoBox.addItem(sg.getSegmentos_Descricao());	
		}
	}catch (GeralException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}
        //LISTAR OS TIPOS
        Tipo tp;
        ArrayList<Tipo> listatp;
        try{
                listatp = (ArrayList<Tipo>) fachada.listarTipo();
                for(Iterator<Tipo> it = listatp.iterator(); it.hasNext();){
                    tp = it.next();
                    jTipoBox.addItem(tp.getTipos_Descricao());
                }
        }catch (GeralException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}
        //LISTAR MARCA
        Marca ma;
        ArrayList<Marca> listama;
        try{
                listama = (ArrayList<Marca>) fachada.listarMarca();
                for(Iterator<Marca> it = listama.iterator(); it.hasNext();){
                    ma = it.next();
                    jMarcaBox.addItem(ma.getMarcas_Descricao());
                }
        }catch (GeralException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}
    } 
    
    //PROCURAR PELA DESCRIÇÃO DO PRODUTO
    public void pesquisarDescricao(){
         try{
            listaProduto = ( ArrayList<Produto>)fachada.listarProdutoDescricao(jcDescricaoField.getText());
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jTabelaProduto.setModel(modelo); 
    }
    
    //PESQUISAR PELA MARCA SELECIONADA
    private void pesquisarMarca(String marca_Descricao){
        try{
            Marca ma = fachada.consultarMarcas(marca_Descricao);//consultar a descrição da marca
            listaProduto = ( ArrayList<Produto>)fachada.listarProdutoMarcas(ma.getMarcas_Codigo());//lista pelo codigo da Marca
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jTabelaProduto.setModel(modelo); 
    }
    
     //PESQUISAR PELO TIPO SELECIONADO   
     private void pesquisarTipo(String tipo_Descricao){
        try{
            Tipo tp = fachada.consultarTipos(tipo_Descricao);//consultar a descrição da marca
            listaProduto = ( ArrayList<Produto>)fachada.listaProdutoTipos(tp.getTipos_Codigo());//lista pelo codigo da Marca
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jTabelaProduto.setModel(modelo); 
    }
    
     //PESQUISAR PELO SEGMENTO SELECIONADO
     private void pesquisarSegmento(String segmento_Descricao){
        try{
            Segmento sg = fachada.consultarSegmentos(segmento_Descricao);
            listaProduto = (ArrayList<Produto>)fachada.listaProdutoSegmentos(sg.getSegmentos_Codigo());
        }catch (GeralException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage() );
        }
        DefaultTableModel modelo = geramodelo(listaProduto);
        jTabelaProduto.setModel(modelo);
    }
    
     //PEGAR OS DADOS DO PRODUTO SELECIONADO
      private Produto pSelecionado(){
        Produto p = listaProduto.get(jTabelaProduto.getSelectedRow());
        return p;
    }
     
    //PEGAR O ITEM SELECIONADO E SETAR ELE NOS CAMPOS ABAIXO
    private void itemSelecionado(){
        //pegar o objeto selecionado
        Produto p = pSelecionado();
        //jogar o produto selecionado
        JcProdutoselecionado.setText(p.getProdutos_Descricao());
        JcMarca.setText(p.getMarcas().getMarcas_Descricao());
    } 
    
    //LIMPAR CAMPO DO ITEM SELECIONADO
    private void limparcamposelecionado(){
        JcProdutoselecionado.setText("");
        JcMarca.setText("");
        jQTDEField.setText("");
    }
     
    //fim
}
