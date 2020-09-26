package br.com.eduardo.challengerwine.service;

import br.com.eduardo.challengerwine.domain.dto.CepDTO;
import org.springframework.stereotype.Service;

@Service
public class CepService implements ICepService {

    @Override
    public CepDTO buscarCep(String cep) {

        CepDTO cepDTO = CepDTO.builder()
                .bairro("Aurora")
                .build();

        return cepDTO;
    }

}
