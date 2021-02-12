#language: pt

Funcionalidade: Cadastrar Email com dados Fake
  
  Contexto: Simular um cadastro de um novo email

  @DadosFake @e2e
  Esquema do Cenario: Acessar pagina Fake para gerar dados
	Dado que estou na tela inicial do site "<site>"
	Quando gero dados fake
	
    Exemplos: 
     |site||
     |fake||
      
  @CadastrarEmail @e2e
  Esquema do Cenario: Cadastrar Email 
    Dado que estou na tela inicial do site "<site>"
	Quando preencho os dados do usuario 
	Entao valido a mensagem de erro  

    Exemplos: 
     |site || 
     |gmail||
      	
