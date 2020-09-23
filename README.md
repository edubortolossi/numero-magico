# API Calculadora

Foi criada uma API com um serviço REST para trazer a quantidade de numeros Magicos dentro da lista range informado.

# End Point

Foi criado um end-point POST com o nome /calculadora/numero-magico dentro da calculadora-controller

# Intruções

Baixar o repositorio executando um git clone https://github.com/edubortolossi/numero-magico.git

Após baixar ir na classe CalculadoraApplication e executa-lá

Após executa-lá estará disponivel o Swagger para teste na URL http://localhost:8080/swagger-ui.html

Onde irá entrar em calculadora-controller -> /calculadora/numero-magico

#Exemplo de chamada

O corpo do end point está configurado para receber uma lista de arrays em formato JSON.
    Exemplo: 
    {
      "listaRanges": [
        [8,27],
        [49,49]
      ]
    }
    
O resultado será obtido logo abaixo na area chamada Server response
com o codigo de sucesso e a quantidade de numeros magicos dentro da lista de ranges


