package br.com.campanha.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude( JsonInclude.Include.NON_NULL )
public class NumeroMagicoDTO {

    List< Long[] > listaRanges;

}
