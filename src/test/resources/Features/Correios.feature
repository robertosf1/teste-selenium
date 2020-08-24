# language: pt
# utf-8

  @correios
  Funcionalidade: Validar as apis Cep

  - Eu gostaria de realizar o teste de apis Cep,
  validando alguns de seus parâmetros.

  Esquema do Cenário: Validar a api Correios
  Dado que eu acesso a api Correios cep ""<cep>
  Quando o http status code da api people for <status_code>
  Então o parâmetro nome da personagem deverá ser <nome>
  E o gênero deverá ser <genero>
  Exemplos:
      | cep      | status_code | 
      | 09931400 | 200         | 
