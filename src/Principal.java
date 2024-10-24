import modulos.ConversorMoedas;
import requisicoes.ConsultarMoeda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main (String [] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultarMoeda consulta = new ConsultarMoeda();

        int opcao = 0;
        while (opcao != 9){
            try {
            System.out.println("***-----------------------------***\n" +
                    "Bem vindo ao conversor de moedas\n\n"+
                    "Escolha o tipo de converção que deseja realizar: \n"+
                    "1- Dollar para Peso Argentino\n"+
                    "2- Peso Argentino para Dollar\n"+
                    "3- Dollar para Real Brasileiro\n"+
                    "4- Real Brasileiro para Dollar\n"+
                    "5- Dollar para Peso Colombiano\n"+
                    "6- Peso Colombiano para Dollar\n"+
                    "7- Converter Euro para Real brasileiro\n"+
                    "8- Converter outra moeda\n"+
                    "9- Sair\n"+
                    "***-----------------------------***");
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    ConversorMoedas.converter("USD", "ARS", consulta, leitura);
                    break;
                case 2:
                    ConversorMoedas.converter("ARS", "USD", consulta, leitura);
                    break;
                case 3:
                    ConversorMoedas.converter("USD", "BRL", consulta, leitura);
                    break;
                case 4:
                    ConversorMoedas.converter("BRL", "USD", consulta, leitura);
                    break;
                case 5:
                    ConversorMoedas.converter("USD", "COP", consulta, leitura);
                    break;
                case 6:
                    ConversorMoedas.converter("COP", "USD", consulta, leitura);
                    break;
                case 7:
                    ConversorMoedas.converter("EUR", "BRL", consulta, leitura);
                    break;
                case 8:
                    ConversorMoedas.converteOutraMoeda( consulta, leitura);
                    break;
                case 9:
                    System.out.println("Saindo da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente:");
                    break;
            }
        }catch (InputMismatchException e) {System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                leitura.nextLine(); // Limpa o buffer de entrada inválida
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
            }

    }

}