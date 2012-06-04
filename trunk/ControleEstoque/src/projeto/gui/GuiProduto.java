package projeto.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.Marca;
import projeto.modelo.to.Produto;
import projeto.modelo.to.Segmento;
import projeto.modelo.to.Tipo;

/**
 *
 * @author diego Silva
 */
    public class GuiProduto extends javax.swing.JFrame {

    ArrayList<Produto> listaProduto = null;
    
    public static Fachada fachada = new Fachada();    

    /**
     * Creates new form GuiProduto
     */
    public GuiProduto() {
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

        jbNovo = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelaProduto = new javax.swing.JTable();
        jbApagar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jtabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Descrição", "Valor Unit.", "Qtde", "Marca", "Tipo", "Segmento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabelaProduto.setEditingColumn(0);
        jtabelaProduto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtabelaProduto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtabelaProduto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        jbApagar.setText("Excluir");
        jbApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApagarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAlterar)
                        .addGap(13, 13, 13)
                        .addComponent(jbApagar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-702)/2, (screenSize.height-542)/2, 702, 542);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        // TODO add your handling code here:
        GuiProdutoNovo gpnovo = new GuiProdutoNovo();
        gpnovo.setVisible(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void jconsulDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jconsulDescricaoActionPerformed
        // TODO add your handling code here:  
        pesquisarDescricao();
    }//GEN-LAST:event_jconsulDescricaoActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        atualizarFiltro();
        
        //MOSTRAR TODOS OS REGISTRO DE PRODUTOS
        atualizarJTabela();
    }//GEN-LAST:event_formComponentShown

    private void jbApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApagarActionPerformed
        // TODO add your handling code here:
        int resposta;

        try {
            //pegar o os dados do produto selecionado
            Produto p = listaProduto.get(jtabelaProduto.getSelectedRow());

            resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Apagar ?", "", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {

                //consulta a descrição do produto selecionado
                Produto pconsul = fachada.consultarProduto(p.getProdutos_Descricao());

                if (pconsul != null) {       //seta o codigo do produto selecionado da consulta
                    fachada.excluirProduto(pconsul.getProdutos_Codigo());
                    atualizarTabela();//atalizar a tabela
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione o produto!");
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jbApagarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        try{
       //crio o objeto Produto Alterado         
       GuiProdutoAlterar gpAlterar = new GuiProdutoAlterar();

            
       //LISTA DO SEGMENTO
       Segmento sg;
       ArrayList<Segmento> listasg;
	try{
		//Lista dos os segmentos
		listasg = (ArrayList<Segmento>)fachada.listarSegmentos("");
		for(Iterator<Segmento> it = listasg.iterator(); it.hasNext();){
                    sg = it.next();
                    gpAlterar.jSegmentoBox.addItem(sg.getSegmentos_Descricao());	
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
                    gpAlterar.jTipoBox.addItem(tp.getTipos_Descricao());
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
                    gpAlterar.jMarcaBox.addItem(ma.getMarcas_Descricao());
                }
        }catch (GeralException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}
            
            
            
            //pegar o objeto selecionado
            Produto p = pSelecionado();
            
            
            gpAlterar.jDescricaoField.setText(p.getProdutos_Descricao());
            //recebe a conversão de double para string incluindo no formato Moeda
            String valorVenda = formaMoeda(p.getProdutos_ValorVenda());
            gpAlterar.jValorUnitarioField.setText( valorVenda );
            gpAlterar.jQtdeField.setText(String.valueOf(p.getProdutos_Quantidade()));
            gpAlterar.jSegmentoField.setText(p.getSegmentos().getSegmentos_Descricao());
            gpAlterar.jSegmentoBox.setSelectedItem(p.getSegmentos().getSegmentos_Descricao());//seta o segmento do Produto
            gpAlterar.jTipoField.setText(p.getTipo().getTipos_Descricao());
            gpAlterar.jTipoBox.setSelectedItem(p.getTipo().getTipos_Descricao());//seta o tipo de Produto
            gpAlterar.jMarcaField.setText(p.getMarcas().getMarcas_Descricao());
            gpAlterar.jMarcaBox.setSelectedItem(p.getMarcas().getMarcas_Descricao());
           
            try{
            //antes de abrir lança o codigo desse produto selecionado
            Produto pconsul = fachada.consultarProduto(p.getProdutos_Descricao());
            
            //Codigo do produto lançado para um Inteiro publico em GuiProdutoAlterar
            gpAlterar.produtoCodigo = pconsul.getProdutos_Codigo();
            
            }catch(GeralException ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
 
            //chama o jframe produto alterar
            gpAlterar.setVisible(true);
                        
        } catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Selecione o produto!");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

        private void jMarcaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMarcaBoxActionPerformed
            // TODO add your handling code here:
            pesquisarMarca((String) jMarcaBox.getSelectedItem());//joga a descrição da marca selecionada
        }//GEN-LAST:event_jMarcaBoxActionPerformed

        private void jTipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoBoxActionPerformed
            // TODO add your handling code here:
            pesquisarTipo((String) jTipoBox.getSelectedItem() );
        }//GEN-LAST:event_jTipoBoxActionPerformed

        private void jSegmentoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSegmentoBoxActionPerformed
            // TODO add your handling code here:
            pesquisarSegmento((String) jSegmentoBox.getSelectedItem());
        }//GEN-LAST:event_jSegmentoBoxActionPerformed

        private void jcDescricaoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcDescricaoFieldKeyPressed
            // TODO add your handling code here:
             if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                  pesquisarDescricao();
            }  
        }//GEN-LAST:event_jcDescricaoFieldKeyPressed

        private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
            // TODO add your handling code here:
            //PROFESSOR AJUDA!
            atualizarTabela();//atualizar a tabela
        }//GEN-LAST:event_formWindowGainedFocus
    
    //CONVERTE O VALOR DOUBLE PARA SALVAR DO BD
    private String converterValorReal(String valorx) {
        String valorConvertido = "";

        for (int i = 0, x = 1; i < valorx.length(); i++, x++) {

            if (valorx.substring(i, x).equals(",")) {

                valorConvertido = valorConvertido + ".";

            } else if (!valorx.substring(i, x).equals(".")) {

                valorConvertido = valorConvertido + valorx.substring(i, x);

            }
        }

        return valorConvertido;
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
            java.util.logging.Logger.getLogger(GuiProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

           // @Override
            public void run() {
                new GuiProduto().setVisible(true);
            }
        });
        /**
         * Metodo no mão
         */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jMarcaBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jSegmentoBox;
    private javax.swing.JComboBox jTipoBox;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbApagar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JTextField jcDescricaoField;
    private javax.swing.JButton jconsulDescricao;
    private javax.swing.JTable jtabelaProduto;
    // End of variables declaration//GEN-END:variables

   
    private DefaultTableModel geramodelo(ArrayList<Produto> listaProduto) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Descrição","Valor Unit.","Qtde","Marca","Tipo","Segmento"},0){
            
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
       // modelo.addColumn("Descrição");
        //modelo.addColumn("Valor Unit.");
        //modelo.addColumn("Qtde");
        //modelo.addColumn("Marca");
        //modelo.addColumn("Tipo");
        //modelo.addColumn("Segmento");

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
    
    private String formaMoeda (double valorMoeda){
        java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
        return df.format(valorMoeda);
    }
    
    private void atualizarJTabela(){
        try {
            listaProduto = (ArrayList<Produto>) fachada.listaProdutoTudo();
        } catch (GeralException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        DefaultTableModel modelo = geramodelo(listaProduto);
        jtabelaProduto.setModel(modelo); 
    }

    public Produto pSelecionado(){
        Produto p = listaProduto.get(jtabelaProduto.getSelectedRow());
        return p;
    }
    
    public void atualizarTabela(){
         try{
            listaProduto = ( ArrayList<Produto>)fachada.listaProdutoTudo();
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jtabelaProduto.setModel(modelo); 
    }
    
    public void pesquisarDescricao(){
         try{
            listaProduto = ( ArrayList<Produto>)fachada.listarProdutoDescricao(jcDescricaoField.getText());
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jtabelaProduto.setModel(modelo); 
    }
    
    private void pesquisarMarca(String marca_Descricao){
        try{
            Marca ma = fachada.consultarMarcas(marca_Descricao);//consultar a descrição da marca
            listaProduto = ( ArrayList<Produto>)fachada.listarProdutoMarcas(ma.getMarcas_Codigo());//lista pelo codigo da Marca
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jtabelaProduto.setModel(modelo); 
    }
    
    private void pesquisarTipo(String tipo_Descricao){
        try{
            Tipo tp = fachada.consultarTipos(tipo_Descricao);//consultar a descrição da marca
            listaProduto = ( ArrayList<Produto>)fachada.listaProdutoTipos(tp.getTipos_Codigo());//lista pelo codigo da Marca
        } catch (GeralException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          DefaultTableModel modelo = geramodelo(listaProduto);
          jtabelaProduto.setModel(modelo); 
    }
    
    private void pesquisarSegmento(String segmento_Descricao){
        try{
            Segmento sg = fachada.consultarSegmentos(segmento_Descricao);
            listaProduto = (ArrayList<Produto>)fachada.listaProdutoSegmentos(sg.getSegmentos_Codigo());
        }catch (GeralException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage() );
        }
        DefaultTableModel modelo = geramodelo(listaProduto);
        jtabelaProduto.setModel(modelo);
    }
    
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
    
//fim    
}
