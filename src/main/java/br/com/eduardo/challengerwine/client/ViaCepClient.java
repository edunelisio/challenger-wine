package br.com.eduardo.challengerwine.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ViaCepClient extends ClientAbstract {

    @Value("${cep-client.uri}")
    private String server;

    @Autowired
    private ObjectMapper jackson;

    @Override
    public String getServer() {
        return server;
    }


}
