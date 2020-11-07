package br.com.eduardo.challengerwine.client;

import br.com.eduardo.challengerwine.exception.CepException;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public abstract class ClientAbstract implements IClient {

    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public abstract String getServer();

    public ClientAbstract() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public String get(String uri) {
        try {
            HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
            ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET,
                    requestEntity, String.class);
            status = responseEntity.getStatusCode();
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new CepException(e.getResponseBodyAsString());
        }

    }

    @Override
    public String post(String uri, String json) {
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        try {
            ResponseEntity<String> responseEntity = rest.exchange(getServer() + uri,
                        HttpMethod.POST, entity, String.class);
            status = responseEntity.getStatusCode();
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new CepException(e.getResponseBodyAsString());
        }
    }

    @Override
    public HttpStatus getStatus(){
        return this.status;
    }

}
