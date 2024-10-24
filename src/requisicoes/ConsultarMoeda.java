package requisicoes;

import com.google.gson.Gson;
import modulos.Moeda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoeda{

    public Moeda buscarMoeda(String moedaBase, String moedaDestino){

    URI endereco = URI.create("https://v6.exchangerate-api.com/v6/291bf84998eb537f9c3dd1ac/pair/"+moedaBase+"/"+ moedaDestino);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(endereco)
            .build();

        try {
            HttpResponse<String> response  = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);
        }
        catch (Exception e) {
            throw new RuntimeException("Não consegui identificar a moeda desejada. ");
        }
    }
}
