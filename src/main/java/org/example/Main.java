package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String entradaUsuario = "";
        Scanner scanner = new Scanner(System.in);

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI
                        .create("https://v6.exchangerate-api.com/v6/71398809a4fb7757ef99cdab/latest/USD"))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();

        JsonObject jsonObject =gson.fromJson(response.body(), JsonObject.class);
        JsonElement jsonElementRates = jsonObject.get("conversion_rates");
        Cotacao cotacao = gson.fromJson(jsonElementRates, Cotacao.class);

        while (true) {
            enfeite();
            System.out.println("\nBem vindo ao conversor de moeda!\n" +
                    "1-) Dólar -> Peso argentino\n" +
                    "2-) Peso argentino -> Dólar\n" +
                    "3-) Dólar -> Real brasileiro\n" +
                    "4-) Real brasileiro -> Dólar\n" +
                    "5-) Dólar -> Peso colombiano\n" +
                    "6-) Peso colombiano -> Dólar\n" +
                    "7-) Sair");

            entradaUsuario = scanner.nextLine();

            if (entradaUsuario.equals("7")) {
                System.out.println("Obrigado por utilizar nosso serviço!!");
                return;
            }

            System.out.println("Digite o valor a ser convertido:");

            double valorASerConvertido = scanner.nextDouble();
            scanner.nextLine();

            espaco();
            System.out.print("O valor final foi ");

            switch (entradaUsuario) {
                case "1":
                    System.out.println(cotacao.ARS * valorASerConvertido);
                    break;
                case "2":
                    System.out.println((cotacao.USD/cotacao.ARS) * valorASerConvertido);
                    break;
                case "3":
                    System.out.println(cotacao.BRL*valorASerConvertido);
                    break;
                case "4":
                    System.out.println((cotacao.USD/cotacao.BRL) * valorASerConvertido);
                    break;
                case "5":
                    System.out.println(cotacao.COP);
                    break;
                case "6":
                    System.out.println((cotacao.USD/cotacao.COP) * valorASerConvertido);
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
            espaco();

        }

    }
    public static void enfeite() {
        for (int i = 0;i < 300;i++) {
            System.out.print("*");
        }
    }

    public static void espaco() {
        for (int i = 0;i < 2;i++) {
            System.out.println();
        }
    }

}