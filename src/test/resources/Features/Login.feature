#language: pt

Funcionalidade: Projeto Aprendendo a Testar
  
	EU COMO detentor de conhecimentos de automa��o de testes.
	DESEJO acesso a uma p�gina para a automa��o de testes.
	PARA QUE seja poss�vel demonstrar e aprimorar meus conhecimentos com automa��o de testes.

  Contexto: Acessar a tela de inicial e inserir um usuario

  @Login
  Esquema do Cenario: Validar campos e botao Inserir e Apagar
	Dado que estou na tela inicial do site
    Quando insiro "<usuario>", "<senha>", "<nome>" e clico em ENVIAR
	Entao apago o usuario "<nome>" inserido
	E atualizo a pagina
	
    Exemplos: 
      | usuario | senha  | nome |
      | teste1  | 123456 | rob  |
      
  @Login
  Esquema do Cenario: Validar msg dos campos Usuario, Senha e Nome 
    Dado que estou na tela inicial do site
	Quando insiro "<usuario>", "<senha>", "<nome>" e clico em ENVIAR
	Entao valido a mensagem "<mensagem>" 

    Exemplos: 
      | usuario | senha    | nome | mensagem                  |janela 				|
      | teste   | 123senha |      | Existem campos em branco. |          			|
      | teste   |          | rob  | 					      |Preencha este campo. |
      | 		| 123senha | rob  | 						  |Preencha este campo. |
      	
