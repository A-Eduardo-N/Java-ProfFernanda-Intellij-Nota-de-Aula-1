import java.util.Scanner;

public class Venda {
    private Produto produto;

    public Venda(Produto produto) {
        this.produto = produto;
    }

    public void realizarVenda() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantidade a vender:");
        int quantidade = scanner.nextInt();

        if (quantidade > produto.getQuantidadeEstoque()) {
            System.out.println("Quantidade em estoque insuficiente!");
            return;
        }

        System.out.println("Forma de pagamento (1-Pix/Espécie/Transferência/Débito, 2-Crédito):");
        int formaPagamento = scanner.nextInt();

        double valorFinal;
        if (formaPagamento == 1) {
            valorFinal = produto.getValor() * 0.95; // 5% desconto
        } else {
            valorFinal = produto.getValor(); // sem desconto para crédito
        }

        System.out.println("Valor a ser pago: R$" + valorFinal);

        if (formaPagamento == 1) {
            System.out.println("Valor pago:");
            double valorPago = scanner.nextDouble();
            if (valorPago > valorFinal) {
                double troco = valorPago - valorFinal;
                System.out.println("Troco: R$" + troco);
            }
        }

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        System.out.println("Venda realizada com sucesso!");
    }
}
