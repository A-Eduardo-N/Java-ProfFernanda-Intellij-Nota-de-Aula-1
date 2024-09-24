public class Produto {
    private String codigo;
    private String nome;
    private double tamanhoPeso;
    private String cor;
    private double valor;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, double tamanhoPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoPeso = tamanhoPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getTamanhoPeso() {
        return tamanhoPeso;
    }

    public String getCor() {
        return cor;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", tamanhoPeso=" + tamanhoPeso +
                ", cor='" + cor + '\'' +
                ", valor=" + valor +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
}
