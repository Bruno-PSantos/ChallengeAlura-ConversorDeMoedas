import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultaAPI {

    private static final String API_KEY = "YOUR_API_KEY";
    private String moedaBase;
    private String moedaDesejada;
    private final Map<Integer, String[]> escolhaMoedas = new HashMap<>();

    public ConsultaAPI () {
        escolhaMoedas.put(1, new String[]{"USD", "ARS"});
        escolhaMoedas.put(2, new String[]{"ARS", "USD"});
        escolhaMoedas.put(3, new String[]{"USD", "BRL"});
        escolhaMoedas.put(4, new String[]{"BRL", "USD"});
        escolhaMoedas.put(5, new String[]{"USD", "COP"});
        escolhaMoedas.put(6, new String[]{"COP", "USD"});
        escolhaMoedas.put(7, new String[]{"USD", "EUR"});
        escolhaMoedas.put(8, new String[]{"EUR", "USD"});
    }

    public void conversao (int conversao, double valor) {
        String[] pair = escolhaMoedas.get(conversao);
        moedaBase = pair[0];
        moedaDesejada = pair[1];

        consumindoAPI(valor);
    }

    public void consumindoAPI (double valor) {
        String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL + moedaBase)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject taxasMoedas = jsonResponse.get("conversion_rates").getAsJsonObject();

            if (taxasMoedas.has(moedaDesejada)) {
                String taxaConversao = taxasMoedas.get(moedaDesejada).getAsString();
                System.out.printf("A conversão de %.2f %s para %s: ", valor, moedaBase, moedaDesejada);
                System.out.println(valor * Double.parseDouble(taxaConversao));
            } else {
                System.out.println("Moeda de conversão inválida. Verifique o código da moeda e tente novamente.");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> getEscolhaMoedas() {
        return new ArrayList<>(escolhaMoedas.keySet());
    }

}
