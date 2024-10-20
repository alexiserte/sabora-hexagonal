package org.example.Utils;

import org.json.JSONObject;

import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PublicIPAddress {
    public static String getMyIP(){
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.ipify.org?format=json"))
                    .GET()
                    .build();

            // Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir la respuesta en un objeto JSON
            JSONObject jsonResponse = new JSONObject(response.body());

            // Obtener el campo "ip"
            String ip = jsonResponse.getString("ip");
            return ip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean twoConnectedToSameNetwork(String ipOne, String ipTwo){
        String[] ipOneSplitted = ipOne.split("\\."); String[] ipTwoSplitted = ipTwo.split("\\.");

        if (ipOneSplitted.length != ipTwoSplitted.length) {return false;}

        for(int i = 0; i < ipOneSplitted.length - 1;i++)
            if(!ipOneSplitted[i].equals(ipTwoSplitted[i])){return false;}

        return true;
    }

    public static void main(String[] args){
        System.out.println(twoConnectedToSameNetwork(getMyIP(),getMyIP()));
    }
}

