package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Api {

    static String url = "https://economia.awesomeapi.com.br/last/";

    public static Map<String, Coin> findAllCurrenciesDollarEquivalent(String codes) throws Exception {

        String urlApi = url + codes;

        try {
            URL url = new URL(urlApi);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String stringOfResponseJson = convertJsonToString(response);

            Gson gson = new Gson();

            Type type = new TypeToken<Map<String, Coin>>() {
            }.getType();

            Map<String, Coin> coins = gson.fromJson(stringOfResponseJson, type);

            return coins;

        } catch (Exception e) {
            throw new Exception("Error: " + e);
        }
    }

    public static String convertJsonToString(BufferedReader buffereReader) throws IOException {
        String response = "";
        String json = "";
        while ((response = buffereReader.readLine()) != null) {
            json += response;
        }
        return json;
    }

}