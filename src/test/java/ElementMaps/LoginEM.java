package ElementMaps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginEM {

	@FindBy(xpath="//img[@title='Aprendendo a Testar']")
	protected WebElement imgTitulo;

	@FindBy(name = "form_usuario")
	protected WebElement inputUsuario;

	@FindBy(name = "form_senha")
	protected WebElement inputSenha;
	
	@FindBy(name = "form_nome")
	protected WebElement inputNome;
	
	@FindBy(xpath = "//input[@class='btn btn-info']")
	protected WebElement btnEnviar;
	
	@FindBy(xpath = "//div/table")  //  elemento fraco trocar ou colocar um id
	protected WebElement tableGrid;

	@FindBy(xpath = "//a[@href='treinar-automacao.php']")
	protected WebElement ahref;
	
}


