import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consultar {
    public Moneda buscar(String base, String monedaTarget) {
        // URL corregida para usar el endpoint adecuado
        URI direccion = URI.create(
                String.format("https://v6.exchangerate-api.com/v6/abc1a2881f72f1ffa25ec52a/pair/%s/%s", base, monedaTarget)
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Debug: Imprimir la respuesta JSON para verificar
            System.out.println("Respuesta JSON: " + response.body());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage());
        }
    }
}
