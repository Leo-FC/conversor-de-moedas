import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Requisicao {

    static public ExchangeApi req(String cod) throws IOException, InterruptedException {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String apiKey = props.getProperty("api_key");

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + cod;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        ExchangeApi requisicao = gson.fromJson(json, ExchangeApi.class);
        return requisicao;
    }

    static public Double valorInformado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor que voce deseja converter:");
        double valorInformado = sc.nextDouble();
        return valorInformado;
    }
}
