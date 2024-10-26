package requisicoes;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import modulos.Moeda;
import erros.TratadorDeErros;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoeda {

    private final TratadorDeErros tratadorDeErros = new TratadorDeErros();

    public Moeda buscarMoeda(String moedaBase, String moedaDestino) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/291bf84998eb537f9c3dd1ac/pair/" + moedaBase + "/" + moedaDestino);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica o status de resposta da API
            if (response.statusCode() != 200) {
                tratadorDeErros.tratarErroRespostaInvalida();
                return null;
            }

            return new Gson().fromJson(response.body(), Moeda.class);

        } catch (IOException e) {
            tratadorDeErros.tratarErroConexao();
            return null;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserva o status de interrupção
            tratadorDeErros.tratarErroConexao();
            return null;

        } catch (JsonSyntaxException e) {
            tratadorDeErros.tratarErroRespostaInvalida();
            return null;

        } catch (Exception e) {
            tratadorDeErros.tratarErroGenerico(e);
            return null;
        }
    }
}
