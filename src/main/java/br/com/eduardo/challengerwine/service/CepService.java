package br.com.eduardo.challengerwine.service;

import br.com.eduardo.challengerwine.client.ViaCepClient;
import br.com.eduardo.challengerwine.domain.TCep;
import br.com.eduardo.challengerwine.domain.dto.CepDTO;
import br.com.eduardo.challengerwine.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CepService implements ICepService {

    @Autowired
    private CepRepository cepRepository;

    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public CepDTO buscarCep(String cep) {

        List<TCep> cepDTOList = cepRepository.findAll();

        TCep cepCadastrado = cepDTOList.stream()
                .filter( item -> item.getCep().contains(cep.trim()))
                .findFirst()
                .get();

    	CepDTO cepDTO = CepDTO.builder()
                .bairro("COHAMA")
                .build();

        return cepDTO;
    }

}
