public class Product {
    public String nome;
    public double preco;
    public int quantidade;
    public boolean estoque;

    Product(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoque = true;
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