package com.Amazon.Utilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonDataReader {
	public static List<String> getProductSearchQueries(String jsonFilePath) {
		List<String> searchQueries = new ArrayList<>();
		try (FileReader reader = new FileReader("src/test/resources/testData.json")) {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(reader);

			if (jsonElement.isJsonArray()) {
				JsonArray jsonArray = jsonElement.getAsJsonArray();
				for (JsonElement element : jsonArray) {
					JsonObject jsonObject = element.getAsJsonObject();
					String searchQuery = jsonObject.get("searchQuery").getAsString();
					searchQueries.add(searchQuery);
				}
			} else {
				System.err.println("JSON data is not an array.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchQueries;
	}
}
