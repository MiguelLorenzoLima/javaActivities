package classMenagent;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Class {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Student> estudantes = new ArrayList<>();
        int opt = -1;
        do {
            System.out.println("==== REVENDA ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Exibir situação dos alunos");
            System.out.println("3. Quantidade de alunos aprovados");
            System.out.println("4. Media da turma");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
            switch (opt) {
                case 0:
                    System.out.println("Adeus!");
                    break;
                case 1:
                    System.out.println("Digite o nome do aluno: ");
                    String nome = s.next();
                    System.out.println("Digite a idade do aluno");
                    int idade = s.nextInt();
                    System.out.println("Digite a primeira nota do aluno: ");
                    double nota1 = s.nextDouble();
                    System.out.println("Digite a segunda nota do aluno: ");
                    double nota2 = s.nextDouble();
                    Student estudante = new Student(
                            nome,
                            idade,
                            nota1,
                            nota2);
                    estudantes.add(estudante);
                    break;
                case 2:
                    System.out.println("------------------------");
                    System.out.println("Situação dos alunos: ");
                    for (Student situacaoAlunos : estudantes) {
                        situacaoAlunos.exibirDados();
                    }
                    break;
                case 3:
                    int aprovados = 0;
                    for (Student estudanteSituacao : estudantes) {
                        if (estudanteSituacao.calcularMedia() >= 7) {
                            aprovados++;
                        }
                    }
                    System.out.println("Quantidade de alunos aprovados: " + aprovados);
                    break;
                case 4:
                    double mediaTurma = 0;

                    for (Student estudanteMedia : estudantes) {

                        mediaTurma += estudanteMedia.calcularMedia();

                    }

                    mediaTurma = mediaTurma / estudantes.size();

                    System.out.println("A média da turma é: " + mediaTurma);

                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (opt != 0);
    }

    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);

        return opt;
    }
}
