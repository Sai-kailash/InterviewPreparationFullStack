package com.example.reactivestream.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class SampleHttpInvocation {
    private HttpClient httpClient;

    public String invokeApi(Map<String, String> body, String url, String token) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();

        String json_body = objectMapper.writeValueAsString(body);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer "+token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json_body))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if(httpResponse.statusCode() != 200){
            throw new RuntimeException("Failed to invoke API "+ httpResponse.statusCode() + httpResponse.body());
        }

        var jsonNode = objectMapper.readTree(httpResponse.body());
        return jsonNode.path("Tenant")
                .path("Feature").toString();

    }
}
