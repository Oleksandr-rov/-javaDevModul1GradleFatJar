package com.goit;

import com.goit.dto.UserNameDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("users.json")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
            UserNameDto dto = gson.fromJson(new String(stream.readAllBytes()), UserNameDto.class);
            String toJson = gson.toJson(dto);
            System.out.println(toJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}