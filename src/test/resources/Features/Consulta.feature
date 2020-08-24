#language: pt
@consulta
Funcionalidade: Consulta
  
  	Eu como cliente
  	Quero utilizar o site
  	Para consultar uma categoria de produto

  Contexto: o usuario precisa estar na tela inicial do  site
    Dado que estou na tela inicial do site

  @comSucesso
  Esquema do Cenario: Consultar uma categoria de produto existente
    Quando no campo de pesquisa digito um "<produto>" pressiono ENTER
    Entao na pagina de resultado vejo "<mensagem>""<produto>" na  tela

    Exemplos: 
      | mensagem       | produto  |
      | Search result: | speakers |

  #      | Search result: | tablets  |
  #      | Search result: | laptops  |
  #      | Search result: | mice       |
  #      | Search result: | headphones |
  @semSucesso
  Esquema do Cenario: Consultar uma categoria de produto inexistente
    Quando no campo de pesquisa digito um "<produto>" pressiono ENTER
    Entao na pagina de resultado vejo "<mensagem>""<produto>" na  tela

    Exemplos: 
      | mensagem       | produto     |
      | No results for | smartphones |
