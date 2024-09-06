package sistema;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("BEM-VINDO AO LUCAS VEÍCULOS");
        System.out.println("Digite qualquer número para iniciar!");
        Scanner sc = new Scanner(System.in);

        ArrayList<Carro> alg = new ArrayList<>();

        int parar = 0;
        while (parar == 0) {
            System.out.println("\nO que você deseja?");
            System.out.println("1 - Cadastrar um veículo");
            System.out.println("2 - Verificar valores dos aluguéis");
            System.out.println("3 - Exibir veículos");
            System.out.println("4 - Alugar um veículo");
            System.out.println("5 - Sair");
            int opt = sc.nextInt();

            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Digite o nome do veículo: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o valor da diária: ");
                    double valorDiaria = sc.nextDouble();
                    sc.nextLine();
                    alg.add(new Carro(nome, valorDiaria));
                    System.out.println("Veículo cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.println("Digite o nome do veículo para verificar o valor da diária: ");
                    String nomeBusca = sc.nextLine();
                    boolean encontrado = false;
                    for (Carro carro : alg) {
                        if (carro.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Valor da diária do veículo " + nomeBusca + ": R$" + carro.getValorDiaria() + "\n");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Veículo não encontrado!\n");
                    }
                    break;

                case 3:
                    System.out.println("\nTodos os veículos cadastrados: \n");
                    if (alg.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado!\n");
                    } else {
                        for (Carro carro : alg) {
                            System.out.println(carro);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nSistema encerrado!");
                    sc.close();
                    parar = 1;
                    break;

                case 4:
                    System.out.println("Digite o nome do veículo para alugar: ");
                    String nomeAluguel = sc.nextLine();
                    boolean encontradoParaAluguel = false;
                    for (Carro carro : alg) {
                        if (carro.getNome().equalsIgnoreCase(nomeAluguel)) {
                            System.out.println("Quantos dias você deseja alugar?");
                            int dias;
                            try {
                                dias = sc.nextInt();
                                sc.nextLine();
                                if (dias <= 0) {
                                    System.out.println("Número de dias deve ser maior que zero.");
                                    break;
                                }
                                double valorTotal = carro.getValorDiaria() * dias;
                                System.out.println("O valor total do aluguel para " + dias + " dias é: R$" + valorTotal + "\n");
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, insira um número válido para os dias.");
                                sc.next();
                            }
                            encontradoParaAluguel = true;
                            break;
                        }
                    }
                    if (!encontradoParaAluguel) {
                        System.out.println("Veículo não encontrado para aluguel!\n");
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        }
    }
}
