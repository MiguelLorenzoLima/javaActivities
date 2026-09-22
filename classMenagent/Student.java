package classMenagent;

public class Student {
    public String nome;
    public int idade;
    public double nota1;
    public double nota2;
    public double media;
    public boolean situacao = false;

    Student(String nome, int idade, double nota1, double nota2) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double calcularMedia() {
        return (this.nota1 + this.nota2) / 2;
    }

    public String estaAprovado() {
        if (calcularMedia() < 7) {
            return ("Reprovado");
        }
        return ("Aprovado");
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Situação: " + estaAprovado());
        System.out.println("Média " + calcularMedia());
        System.out.println("----------------------");
    }

}