package classMenagent;
public class Student {
    public String nome;
    public int idade;
    public double nota1;
    public double nota2;

    Student(String nome, int idade, double nota1, double nota2) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerEstoque(int quantidade) {
        this.quantidade -= quantidade;
    }

    public double calcularValorEstoque(){
        return preco * quantidade;
    }

    public void vender(int quantidadeVender){
        if (quantidadeVender <= quantidade){
            quantidade -= quantidadeVender;
            System.err.println("Quantidade removida com sucesso!");
        } else {
            System.err.println("Quantidade insuficiente no estoque!");
        }
    }

    public void exibirDados(){
    System.out.println("Nome: " + nome);
    System.out.println("Preço: R$ " + preco);
    System.out.println("Quantidade: " + quantidade);
    System.out.println("----------------------");
    }

}