package br.com.eduardo.challengerwine.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ViaCepClient extends ClientAbstract {

    @Value("${cep-client.uri}")
    private String server;

    @Autowired
    private ObjectMapper jackson;

    @Override
    public String getServer() {
        return server;
    }

    public String getCep(String param) {
        String uri = server + "param" + "/json/";
        return get(uri.replace("param", param).trim());
    }
}
