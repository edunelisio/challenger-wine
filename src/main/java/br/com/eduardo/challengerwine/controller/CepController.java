package br.com.eduardo.challengerwine.controller;

import br.com.eduardo.challengerwine.domain.dto.CepDTO;
import br.com.eduardo.challengerwine.service.CepService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @SneakyThrows
    @GetMapping("/{cep}")
    public ResponseEntity getCep(@PathVariable String cep) {
        return ResponseEntity.ok(cepService.buscarCep(cep));
    }

}
