import java.util.Scanner;

public class ImpostoDeRenda {

    // Função para calcular o imposto sobre o salário
    public static double calcularImpostoSalario(double rendaAnualSalario) {
        double salarioMensal = rendaAnualSalario / 12;
        if (salarioMensal < 3000) {
            return 0;
        } else if (salarioMensal < 5000) {
            return rendaAnualSalario * 0.10;
        } else {
            return rendaAnualSalario * 0.20;
        }
    }

    // Função para calcular o imposto sobre a prestação de serviços
    public static double calcularImpostoServicos(double rendaAnualServico) {
        return rendaAnualServico * 0.15;
    }

    // Função para calcular o imposto sobre ganho de capital
    public static double calcularImpostoGanhoCapital(double rendaAnualGanhoCapital) {
        return rendaAnualGanhoCapital * 0.20;
    }

    // Função para calcular o valor máximo dedutível (30% do imposto bruto)
    public static double calcularMaximoDedutivel(double impostoBruto) {
        return impostoBruto * 0.30;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados do usuário
        System.out.print("Renda anual com salário: ");
        double rendaAnualSalario = scanner.nextDouble();

        System.out.print("Renda anual com prestação de serviços: ");
        double rendaAnualServico = scanner.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double rendaAnualGanhoCapital = scanner.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        // Cálculo do imposto sobre salário, serviços e ganho de capital
        double impostoSalario = calcularImpostoSalario(rendaAnualSalario);
        double impostoServico = calcularImpostoServicos(rendaAnualServico);
        double impostoGanhoCapital = calcularImpostoGanhoCapital(rendaAnualGanhoCapital);

        // Cálculo do imposto bruto total
        double impostoBruto = impostoSalario + impostoServico + impostoGanhoCapital;

        // Cálculo do valor máximo dedutível
        double maximoDedutivel = calcularMaximoDedutivel(impostoBruto);

        // Cálculo dos gastos dedutíveis (máximo entre o valor permitido e o real)
        double gastosDedutiveis = Math.min(gastosMedicos + gastosEducacionais, maximoDedutivel);

        // Cálculo do imposto devido
        double impostoDevido = impostoBruto - gastosDedutiveis;

        // Exibição do relatório de imposto de renda
        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoGanhoCapital);

        System.out.println("* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);

        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
        System.out.printf("Abatimento: %.2f\n", gastosDedutiveis);
        System.out.printf("Imposto devido: %.2f\n", impostoDevido);

        scanner.close();
    }
}
