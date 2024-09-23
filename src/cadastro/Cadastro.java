package cadastro;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Cadastro {

    private JFrame frame;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldCpf;
    private JTextField textFieldEmail;
    private JTextField textFieldTelefone;
    private JComboBox<String> comboBoxPlanoTreino;
    private TelaInicial telaInicial; 

    
    public Cadastro(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 353, 296);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setBounds(10, 193, 321, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String idadeStr = textFieldIdade.getText();
                String cpf = textFieldCpf.getText();
                String planoTreino = (String) comboBoxPlanoTreino.getSelectedItem();
                String email = textFieldEmail.getText();
                String telefone = textFieldTelefone.getText();

                if (nome.isEmpty() || idadeStr.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (AlunosData.alunoCadastrado(cpf)) {
                    JOptionPane.showMessageDialog(frame, "Este CPF já está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int idade;
                try {
                    idade = Integer.parseInt(idadeStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Idade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String matricula = String.valueOf(AlunosData.getTotalAlunos() + 1);

                Aluno aluno = new Aluno(nome, idade, cpf, matricula, planoTreino, email, telefone);
                AlunosData.adicionarAluno(cpf, aluno);

                JOptionPane.showMessageDialog(frame, "Aluno registrado com sucesso!\nNome: " + aluno.getNome() + "\nMatrícula: " + aluno.getMatricula());
            }
        });
        frame.getContentPane().add(btnNewButton);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(62, 8, 262, 20);
        frame.getContentPane().add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 42, 46, 14);
        frame.getContentPane().add(lblIdade);

        textFieldIdade = new JTextField();
        textFieldIdade.setBounds(62, 39, 262, 20);
        frame.getContentPane().add(textFieldIdade);
        textFieldIdade.setColumns(10);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(10, 73, 46, 14);
        frame.getContentPane().add(lblCpf);

        textFieldCpf = new JTextField();
        textFieldCpf.setBounds(62, 70, 262, 20);
        frame.getContentPane().add(textFieldCpf);
        textFieldCpf.setColumns(10);

        JLabel lblPlanoTreino = new JLabel("Plano Treino:");
        lblPlanoTreino.setBounds(10, 98, 80, 14);
        frame.getContentPane().add(lblPlanoTreino);

        String[] planosTreino = { "Treino A", "Treino B", "Treino C", "Treino D" };
        comboBoxPlanoTreino = new JComboBox<>(planosTreino);
        comboBoxPlanoTreino.setBounds(99, 101, 224, 20);
        frame.getContentPane().add(comboBoxPlanoTreino);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 134, 46, 14);
        frame.getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(62, 131, 262, 20);
        frame.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 159, 62, 14);
        frame.getContentPane().add(lblTelefone);

        textFieldTelefone = new JTextField();
        textFieldTelefone.setBounds(82, 162, 242, 20);
        frame.getContentPane().add(textFieldTelefone);
        textFieldTelefone.setColumns(10);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 222, 321, 23);
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
