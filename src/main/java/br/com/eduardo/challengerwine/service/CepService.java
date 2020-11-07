package br.com.eduardo.challengerwine.service;

import br.com.eduardo.challengerwine.client.ViaCepClient;
import br.com.eduardo.challengerwine.domain.TCep;
import br.com.eduardo.challengerwine.domain.dto.CepDTO;
import br.com.eduardo.challengerwine.repository.CepRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public CepDTO buscarCep(String cep) throws JsonProcessingException {

        List<TCep> cepDTOList = cepRepository.findAll();
        TCep cepCadastrado = null;
        CepDTO cepDTO = null;

        if (!cepDTOList.isEmpty()) {
            cepCadastrado = cepDTOList.stream()
                    .filter(item -> item.getCepFormatted().contains(cep.trim()))
                    .findFirst()
                    .get();
            cepDTO = mountCepDto(cepCadastrado);
        }

        if (cepCadastrado == null) {
            String object = viaCepClient.getCep(cep);
            ObjectMapper objectMapper = new ObjectMapper();
            cepDTO = objectMapper.readValue(object, CepDTO.class);

            cepCadastrado = mountTCep(cepDTO);
            cepRepository.save(cepCadastrado);
        }

        return cepDTO;
    }

    private TCep mountTCep(CepDTO cepDTO) {
        TCep tCep = new TCep();
        tCep.setBairro(cepDTO.getBairro());
        tCep.setCep(cepDTO.getCep());
        tCep.setComplemento(cepDTO.getComplemento());
        tCep.setIbge(cepDTO.getIbge());
        tCep.setLogradouro(cepDTO.getLogradouro());
        return tCep;
    }

    private CepDTO mountCepDto(TCep tCep) {
        CepDTO cepDTO = new CepDTO();
        cepDTO.setBairro(tCep.getBairro());
        cepDTO.setCep(tCep.getCep());
        cepDTO.setComplemento(tCep.getComplemento());
        cepDTO.setIbge(tCep.getIbge());
        cepDTO.setLogradouro(tCep.getLogradouro());
        return cepDTO;
    }

}
