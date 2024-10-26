package erros;

import java.io.IOException;

public class TratadorDeErros {

    public void tratarErroEntradaInvalida() {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
    }

    public void tratarErroConexao() {
        System.out.println("Erro: Não foi possível conectar à API de conversão. Verifique sua conexão de internet e tente novamente.");
    }

    public void tratarErroRespostaInvalida() {
        System.out.println("Erro: A resposta da API é inválida ou não foi possível processá-la.");
    }

    public void tratarErroMoedaNaoSuportada() {
        System.out.println("Erro: Moeda não suportada. Por favor, escolha uma moeda válida.");
    }

    public void tratarErroGenerico(Exception e) {
        System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
    }
}
