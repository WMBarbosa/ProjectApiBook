package br.com.projectApi.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public record Item(String id, volumeInfo volumeInfo) {
    public static void printBookDetails(JsonArray itemsArray) {
        for (JsonElement itemElement : itemsArray) {
            if (itemElement.isJsonObject()) {
                JsonObject itemObject = itemElement.getAsJsonObject();
                JsonObject volumeInfo = itemObject.getAsJsonObject("volumeInfo");
                System.out.println("Titulo: " + volumeInfo.get("title").getAsString());
                System.out.println("Autor: " + volumeInfo.getAsJsonArray("authors"));
                System.out.println("Data de Publicação: " + volumeInfo.get("publishedDate").getAsString());
                System.out.println("-----------------------");
            }
        }
    }
}
