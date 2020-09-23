package br.com.calculadora.service;

import br.com.calculadora.dto.NumeroMagicoDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CalculadoraService {

    public NumeroMagicoDTO quantidadeNumeroMagico( NumeroMagicoDTO numeroMagicoDTO ) {
        AtomicInteger totalPrimos = new AtomicInteger();

        numeroMagicoDTO.getListaRanges().forEach( range ->
                {
                    long rangeInicial = range[ 0 ];
                    long rangeFinal = range[ 1 ];
                    for( ; rangeInicial <= rangeFinal; rangeInicial++ ) {
                        if( validaRaizInteira( rangeInicial ) ) {
                            if ( validaNumeroPrimo( (int)(Math.sqrt(rangeInicial) ) ) ) {
                                totalPrimos.getAndIncrement();
                            }
                        }
                    }
                }
        );
        return numeroMagicoDTO;
    }

    private static boolean validaNumeroPrimo( int numero ) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }

    public final static boolean validaRaizInteira(long n) {
        if (n < 0)
            return false;

        long raiz = (long)(Math.sqrt(n) + 0.5);
        return raiz*raiz == n;
    }

}
