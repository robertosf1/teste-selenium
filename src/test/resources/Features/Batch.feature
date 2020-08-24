#language: pt
Funcionalidade: Executar Processo Batch
  
 Contexto: Executar Processo Batch

  @Batch
  Esquema do Cenario: Executar processo Batch 
    Dado que estou na tela de login do site
    	E insiro "<usuario>" e "<senha>" e clico em CONECTAR
    	E acesso a Plataforma "<plataforma>" 
	Entao acesso a tela de Processos Batch
		E clico em executar a Batch "Base II - Elo Bulk Data"

    Exemplos: 
      | usuario     | senha        | plataforma |
      | ecavallini  | Sucesso@2032 | PAT        |

