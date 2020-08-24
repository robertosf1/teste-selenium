package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import ElementMaps.LoginEM;
import Utilidades.WaitManager;

public class LoginPO extends LoginEM {
	
	public WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new WaitManager(this.driver);
	}
		
	public LoginPO preencherDados(String username, String password, String nome) {
		//waitManager.aguardarElementoSerVisivel();
		this.inputUsuario.sendKeys(username);
		this.inputSenha.sendKeys(password);
		this.inputNome.sendKeys(nome);
		
		return this;
	}

	public MenuPO clicarEmEnviar() {
		this.btnEnviar.click();
		return new MenuPO(driver);
	}

	public String imgTitulo() {
		return this.imgTitulo.getAttribute("title");
	}
	
	public void clicoEmApagar(String nome) {
	
		 List<WebElement> tr = this.tableGrid.findElements(By.cssSelector("tr"));
		 for (WebElement linha : tr) {
			 if (linha.getText().contains(nome)) {
				 List<WebElement> td = linha.findElements(By.cssSelector("td"));
				 for (WebElement coluna : td) {
					 System.out.println(coluna.getText());
					 if (coluna.getText().contains("Apagar"))
					 {
						 Actions builderActions = new Actions(driver);
						 builderActions.moveToElement(coluna).perform();
						 builderActions.click(coluna).perform();
						 return;
					 }
				 }
			 }
		 }
	}

	public void moverAteTabela() {
		 Actions builderActions = new Actions(driver);
		 builderActions.moveToElement(this.tableGrid).perform();
	}

	public void validoUsuarioInserido(String nome) {
		// localizo usuario inserido
		String campo = "//td[contains(text(),'"+ nome+"')]";
		WebElement validarInsert = driver.findElement(By.xpath(campo));
		Actions builderActions = new Actions(driver);
		builderActions.moveToElement(validarInsert).perform();
	}
	
	public void validoMsgExibida(String msg) {
		// localizo msg
		String campo = "//td[contains(text(),'"+ msg+"')]";
		WebElement validarInsert = driver.findElement(By.xpath(campo));
		Actions builderActions = new Actions(driver);
		builderActions.moveToElement(validarInsert).perform();
	}

	public void clicarEmAtualizar() {
		this.ahref.click();
	}

}
