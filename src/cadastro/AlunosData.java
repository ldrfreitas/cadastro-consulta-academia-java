package cadastro;

import java.util.HashMap;
import java.util.Map;

public class AlunosData {
    private static Map<String, Aluno> alunosMap = new HashMap<>();

    public static void adicionarAluno(String cpf, Aluno aluno) {
        alunosMap.put(cpf, aluno);
    }

    public static Aluno buscarAluno(String cpf) {
        return alunosMap.get(cpf);
    }

    public static boolean alunoCadastrado(String cpf) {
        return alunosMap.containsKey(cpf);
    }

    public static int getTotalAlunos() {
        return alunosMap.size();
    }
}
