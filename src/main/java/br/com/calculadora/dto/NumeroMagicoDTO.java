package br.com.calculadora.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class NumeroMagicoDTO {

    List< Long[] > listaRanges;

    public NumeroMagicoDTO() {
    }

    public NumeroMagicoDTO( List< Long[] > listaRanges ) {
        this.listaRanges = listaRanges;
    }
}
