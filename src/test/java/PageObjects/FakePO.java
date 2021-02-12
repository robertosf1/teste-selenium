package PageObjects;

import org.openqa.selenium.WebDriver;

import ElementMaps.FakeEM;
import TestRunners.cadastroEmail;
import Utilidades.Tools;
import Utilidades.WaitManager;
import org.openqa.selenium.support.PageFactory;

public class FakePO extends FakeEM{

	public WebDriver driver;
	cadastroEmail cad= new cadastroEmail();
	
	public FakePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new WaitManager(driver);
	}
	
	public FakePO telaInicial(WebDriver driver) {
		return new FakePO(driver);
	}
	
	public FakePO geroDados( ) {
		String massa[] = new String[4];
		//this.btnGenerate.click();
		String nome = this.textNome.getText();
		System.out.println("nome.: "+nome);
		massa[0]="nome="+nome;
		String senha=  this.textSenha.getText();
		massa[1]="senha="+senha;
		System.out.println("senha.: "+senha);
		String usuario = this.textUserName.getText();
		massa[2]="usuario="+usuario;
		System.out.println("usuario.: "+usuario);
		String telefone = this.textPhone.getText();
		System.out.println("telefone.: "+telefone);
		massa[3]="telefone="+telefone;
		
		Tools.salvarMassa(massa);
		
		return this;
		
	}
	
	
}
