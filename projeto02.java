import java.util.Scanner;

public class Bar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados do cliente
        System.out.print("Sexo (F ou M): ");
        char sexo = scanner.next().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int qtdCervejas = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int qtdRefrigerantes = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int qtdEspetinhos = scanner.nextInt();

        // Definição dos preços
        double precoIngresso = (sexo == 'F' || sexo == 'f') ? 8.00 : 10.00;
        double precoCerveja = 5.00;
        double precoRefrigerante = 3.00;
        double precoEspetinho = 7.00;
        double couvert = 4.00;

        // Cálculo do consumo
        double consumo = (qtdCervejas * precoCerveja) + (qtdRefrigerantes * precoRefrigerante) + (qtdEspetinhos * precoEspetinho);

        // Cálculo do couvert (isento se o consumo for maior que 30 reais)
        if (consumo > 30.00) {
            couvert = 0.00;
        }

        // Cálculo do valor total a pagar
        double valorTotal = consumo + couvert + precoIngresso;

        // Exibição do relatório
        System.out.println("\n### RELATÓRIO ###");
        System.out.printf("Consumo = R$ %.2f\n", consumo);
        if (couvert == 0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f\n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f\n", precoIngresso);
        System.out.printf("Valor a pagar = R$ %.2f\n", valorTotal);

        scanner.close();
    }
}
