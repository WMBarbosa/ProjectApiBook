package br.com.projectApi.model;

import br.com.projectApi.excecao.ErroDeConversao;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static br.com.projectApi.model.Item.printBookDetails;

public class ConsumoApi {
    private Scanner leitura = new Scanner(System.in);
    private String busca;
    private final String API_KEY = "AIzaSyCX5L92HYujHpn-AyOl8DPPk_gqHbKcZFw";

    public void obterDados() throws IOException, InterruptedException {

        while (true) {
            System.out.println("Digite um filme para busca (ou 'sair' para sair): ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando programa...");
                break;
            }
            String endereco = "https://www.googleapis.com/books/v1/volumes?q="
                    + busca.replace(" ", "+++++++")
                    + "&key=" + API_KEY;
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                JsonElement rootElement = JsonParser.parseString(json);
                if (rootElement.isJsonObject()) {
                    JsonObject rootObject = rootElement.getAsJsonObject();
                    if (rootObject.has("items") && rootObject.get("items").isJsonArray()) {
                        JsonArray itemsArray = rootObject.getAsJsonArray("items");
                        printBookDetails(itemsArray);
                    } else {
                        System.out.println("Detalhes do livro não encontrado.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro do argumento na busca, verifique o endereço");
            } catch (ErroDeConversao e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
