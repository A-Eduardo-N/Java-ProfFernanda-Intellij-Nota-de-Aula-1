import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Produto> produtos;

    public Sistema() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Código do produto:");
        String codigo = scanner.nextLine();
        System.out.println("Nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Tamanho/Peso:");
        double tamanhoPeso = scanner.nextDouble();
        System.out.println("Cor:");
        String cor = scanner.next();
        System.out.println("Valor:");
        double valor = scanner.nextDouble();
        System.out.println("Quantidade em estoque:");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Realizar Venda");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    System.out.println("Digite o código do produto:");
                    String codigo = scanner.next();
                    Produto produtoParaVenda = produtos.stream()
                            .filter(produto -> produto.getCodigo().equals(codigo))
                            .findFirst()
                            .orElse(null);

                    if (produtoParaVenda != null) {
                        Venda venda = new Venda(produtoParaVenda);
                        venda.realizarVenda();
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}
