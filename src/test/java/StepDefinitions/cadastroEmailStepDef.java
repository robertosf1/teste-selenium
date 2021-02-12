package StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import PageObjects.CadastroEmailPO;
import Utilidades.Screenshot;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class cadastroEmailStepDef extends baseStepDef {

	CadastroEmailPO cadEmailPo = new CadastroEmailPO(driver);
	
	@Quando("preencho os dados do usuario")
	public void preencho_os_dados_do_usuario()
	{
		cadEmailPo.cadastrarEmail();
	}
	
	@Entao("valido a mensagem de erro")
	public void valido_a_mensagem_de_erro()
	{
		try {
			Screenshot.capturaimagem(driver, "cadastro-erro", "erro");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String msgErro = cadEmailPo.getMsgErro();
		System.out.println("erro retorno.: "+msgErro);

		Assert.assertTrue(msgErro, msgErro.contains("Este formato"));
	}
	
	
}
