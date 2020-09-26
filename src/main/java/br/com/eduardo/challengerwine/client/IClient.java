package br.com.eduardo.challengerwine.client;

import org.springframework.http.HttpStatus;

public interface IClient {
    String get(String uri);

    String post(String uri, String json);

    HttpStatus getStatus();
}
