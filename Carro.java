package sistema;

class Carro {
    private String nome;
    private double valorDiaria;

    public Carro(String nome, double valorDiaria) {
        this.nome = nome;
        this.valorDiaria = valorDiaria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Valor da diária: R$" + valorDiaria;
    }
}