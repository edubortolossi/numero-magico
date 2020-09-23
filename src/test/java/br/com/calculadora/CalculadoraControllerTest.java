package br.com.calculadora;

import br.com.calculadora.dto.NumeroMagicoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringRunner.class )
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles( "test" )
public class CalculadoraControllerTest {

    private static final String CRIAR_CAMPANHA_PATH = "/campanhas";
    private static final String DELETAR_CAMPANHA_PATH = "/campanhas/{id}";

    @Autowired
    public MockMvc mockMvc;

    private static final String NUMERO_MAGICO_PATH = "/calculadora/numero-magico";

    @Test
    public void calculaNumMagicoSucess() throws Exception {

        long [] range1 = { 8,27 };
        long [] range2 = { 49,49 };

        List listaRanges = new ArrayList();
        listaRanges.add( range1 );
        listaRanges.add( range2 );

        NumeroMagicoDTO numeroMagicoDTO = NumeroMagicoDTO
                .builder()
                .listaRanges( listaRanges )
                .build();

        mockMvc.perform( post( NUMERO_MAGICO_PATH )
                .contentType( MediaType.APPLICATION_JSON )
                .content( objectToJson( numeroMagicoDTO ) ) )
                .andExpect( status().is2xxSuccessful() );
    }



    protected String objectToJson( Object object ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString( object );
        } catch( JsonProcessingException var3 ) {
            return null;
        }
    }
}
