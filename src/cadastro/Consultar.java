package cadastro;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.FlowLayout;

public class Consultar {

    private JFrame frame;
    private JTextField textFieldCpf;
    private TelaInicial telaInicial;

    public Consultar(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel lblTitulo = new JLabel("Consultar Aluno");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        frame.getContentPane().add(lblTitulo);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Arial", Font.PLAIN, 14)); 
        frame.getContentPane().add(lblCpf);

        textFieldCpf = new JTextField();
        textFieldCpf.setColumns(20); 
        frame.getContentPane().add(textFieldCpf);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));  
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = textFieldCpf.getText();
                if (cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira o CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Aluno aluno = AlunosData.buscarAluno(cpf);
                if (aluno == null) {
                    JOptionPane.showMessageDialog(frame, "Aluno não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String detalhes = "Nome: " + aluno.getNome() + "\n" +
                                      "Idade: " + aluno.getIdade() + "\n" +
                                      "CPF: " + aluno.getCpf() + "\n" +
                                      "Matrícula: " + aluno.getMatricula() + "\n" +
                                      "Plano Treino: " + aluno.getPlanoTreino() + "\n" +
                                      "Email: " + aluno.getEmail() + "\n" +
                                      "Telefone: " + aluno.getTelefone();
                    JOptionPane.showMessageDialog(frame, detalhes, "Detalhes do Aluno", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.getContentPane().add(btnBuscar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14)); 
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaInicial.getFrame().setVisible(true); 
                frame.setVisible(false); 
            }
        });
        frame.getContentPane().add(btnVoltar);
    }

    public JFrame getFrame() {
        return frame;
    }
}
