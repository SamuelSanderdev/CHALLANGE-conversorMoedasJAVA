package modulos;

import requisicoes.ConsultarMoeda;

import java.util.Scanner;

public class ConversorMoedas{

    public static void converter(String moedaBase, String moedaDestino, ConsultarMoeda consulta, Scanner leitura) {
        double quantidade;
        double quantidadeConvertida;


        Moeda moeda = consulta.buscarMoeda(moedaBase, moedaDestino);
        System.out.println("<<<--------------------->>>");
        System.out.println("Taxa de converção de hoje  \n1 " + moedaBase + " = " +moeda.conversion_rate()+ " " + moedaDestino);
        System.out.println("Digite o valor que nescessita converter " + moedaBase);
        quantidade = Double.parseDouble(leitura.nextLine());
        quantidadeConvertida = (quantidade * moeda.conversion_rate());
        System.out.println(quantidade + " " + moedaBase + " = " + quantidadeConvertida + " " + moedaDestino);
        System.out.println("<<<--------------------->>> \n");
    }
    public static void converteOutraMoeda(ConsultarMoeda consulta, Scanner leitura){
        System.out.println("<<<----------------->>>");
        System.out.println("Digite qual moeda você quer trocar:");
        String moedaBase = leitura.nextLine().toUpperCase();
        System.out.println("Digite por qual moeda você quer trocar: ");
        String moedaDestino = leitura.nextLine().toUpperCase();
        converter(moedaBase, moedaDestino, consulta, leitura);


    }
}
