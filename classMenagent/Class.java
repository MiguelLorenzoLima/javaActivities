package classMenagent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Class {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Student> produtos = new ArrayList<>();
        int opt = -1;
        do {
            System.out.println("==== REVENDA ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Exibir os dados de todos os produtos");
            System.out.println("3. Remover Quantidade");
            System.out.println("4. Remover Produto");
            System.out.println("5. Calcular valor total no estoque");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
            switch (opt) {
                case 0:
                    System.out.println("Adeus!");
                    break;
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String nome = s.next();
                    System.out.println("Digite o valor do produto");
                    double preco = s.nextDouble();
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = s.nextInt();
                    Student produto = new Student(
                            nome,
                            preco,
                            quantidade
                        );
                    produtos.add(produto);
                    break;
                case 2:
                    System.out.println("Detalhes dos Produtos: ");
                    for (Student produtoDetalhes : produtos ) {
                        produtoDetalhes.exibirDados();
                    }
                    break;
                case 3:
                   System.out.println("Digite o nome do produto que deseja editar a quantidade: ");
                    String nomeProduto = s.next();
                   System.out.println("Digite a quantidade da venda");
                    int qtddVendida = s.nextInt();
                    for (Student produtoVenda : produtos){
                            if (produtoVenda.nome.equals(nomeProduto)){
                                produtoVenda.vender(qtddVendida);
                            }
                    }
                    break;
                case 4:
                   System.out.println("Digite o nome do produto que deseja remover do estoque: ");
                    String removerProduto = s.next();

                    for (int i = 0; i < produtos.size(); i++){
                            if (produtos.get(i).nome.equals(removerProduto)){
                                produtos.remove(i);
                                System.out.println("O produto foi removido companheir  o");
                            }
                    }
                    break;
                case 5:
                    double valorTotal = 0;
                    for (Student produtoEstoque : produtos){
                        valorTotal += produtoEstoque.calcularValorEstoque(); 
                    }
                    System.out.println("O valor total do estoque atual é de: " + valorTotal);
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
