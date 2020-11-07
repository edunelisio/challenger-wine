package br.com.eduardo.challengerwine.service;

import br.com.eduardo.challengerwine.domain.dto.CepDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ICepService {

    public CepDTO buscarCep(String cep) throws JsonProcessingException;

}
