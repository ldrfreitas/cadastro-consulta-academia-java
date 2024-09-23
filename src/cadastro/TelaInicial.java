package cadastro;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

public class TelaInicial {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial window = new TelaInicial();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaInicial() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); 
        
        JLabel lblTitulo = new JLabel("Sistema de Cadastro de Alunos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));  
        frame.getContentPane().add(lblTitulo);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14)); 
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cadastro cadastro = new Cadastro(TelaInicial.this);
                cadastro.getFrame().setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.getContentPane().add(btnCadastrar);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Consultar consultar = new Consultar(TelaInicial.this);
                consultar.getFrame().setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.getContentPane().add(btnConsultar);
    }

    public JFrame getFrame() {
        return frame;
    }
}
