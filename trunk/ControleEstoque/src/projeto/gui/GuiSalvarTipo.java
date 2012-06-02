package projeto.gui;


import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import projeto.erro.GeralException;
import projeto.modelo.fachada.Fachada;
import projeto.modelo.to.Tipo;

public class GuiSalvarTipo extends JFrame {

    Fachada fachada = new Fachada();
    private Button button_1;
    private JPanel contentPane;
    private JTextField jTDesTip;
    private JTextField jTcod;
    private JLabel lblCdigo;

    /**
     * Create the frame.
     */
    public GuiSalvarTipo() {
        setTitle("Salvar Tipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 308, 171);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o");

        lblNewLabel.setBounds(66, 3, 181, 31);
        contentPane.add(lblNewLabel);
        jTDesTip = new JTextField();
        jTDesTip.setBounds(66, 36, 218, 25);
        contentPane.add(jTDesTip);
        jTDesTip.setColumns(10);

        Button button = new Button("Salvar");

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Fachada fachada = new Fachada();
                String tSalvar = jTDesTip.getText();

                try {
                    @SuppressWarnings("unused")
                    int validoString = Integer.parseInt(tSalvar);

                    JOptionPane.showMessageDialog(null, "Digite apenas a descri��o do tipo!");
                } catch (NumberFormatException x) {
                    Tipo t = new Tipo();

                    t.setTipos_Descricao(tSalvar);
                    t.setTipos_Codigo(Integer.parseInt(jTcod.getText()));

                    try {
                        fachada.salvarTipo(t);
                    } catch (GeralException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }

                jTDesTip.setText(null);
              

                try {
                    jTcod.setText(String.valueOf(Fachada.Codigo()));
                } catch (GeralException e1) {

                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button.setBounds(63, 78, 70, 22);
        contentPane.add(button);
        button_1 = new Button("Sair");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        button_1.setBounds(154, 78, 70, 22);
        contentPane.add(button_1);
        lblCdigo = new JLabel("C\u00F3digo");
        lblCdigo.setBounds(10, 11, 46, 14);
        contentPane.add(lblCdigo);
        jTcod = new JTextField();
        jTcod.setEditable(false);
        jTcod.setBounds(10, 36, 46, 25);
        contentPane.add(jTcod);
        jTcod.setColumns(10);

        try {
            jTcod.setText(String.valueOf(Fachada.Codigo()));
        } catch (GeralException ex) {
            Logger.getLogger(GuiSalvarTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    GuiSalvarTipo frame = new GuiSalvarTipo();

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
