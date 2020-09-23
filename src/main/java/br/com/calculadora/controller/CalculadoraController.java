package br.com.calculadora.controller;

import br.com.calculadora.dto.NumeroMagicoDTO;
import br.com.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping( value = "/calculadora", produces = MediaType.APPLICATION_JSON_VALUE )
public class CalculadoraController {

    @Autowired
    CalculadoraService calculadoraService;

    @PostMapping( "numero-magico" )
    public ResponseEntity< NumeroMagicoDTO > calcularNumeroMagico( @Valid @RequestBody NumeroMagicoDTO listaRanges ) throws Exception {
        return ResponseEntity.status( HttpStatus.OK ).body( calculadoraService.quantidadeNumeroMagico( listaRanges ) );
    }

}
