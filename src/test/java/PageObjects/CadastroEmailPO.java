package PageObjects;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ElementMaps.CadastroEmailEM;
import Utilidades.Screenshot;
import Utilidades.Tools;
import Utilidades.WaitManager;

public class CadastroEmailPO extends CadastroEmailEM{
	public WebDriver driver;

	public CadastroEmailPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new WaitManager(driver);
		
	}
	
	
	public CadastroEmailPO cadastrarEmail() {
		
		Random gerador = new Random();
		
		String[] parametros = Tools.lerMassa();
		
		this.inputFirstName.sendKeys(parametros[0]);
		this.inputLastName.sendKeys(parametros[2]);
		this.inputUserName.sendKeys(parametros[2]+gerador.nextInt());
		this.inputPasswd.sendKeys(parametros[1]);
		this.inputConfirmPasswd.sendKeys(parametros[1]);
		
		try {
			Screenshot.capturaimagem(driver, "cadastro-email", "cadastrar");
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(this.buttonProxima));
		this.buttonProxima.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(this.inputPhoneNumberId));
		this.inputPhoneNumberId.sendKeys(parametros[3]);
		this.buttonProxima.click();
	
		return this;
		
	}

	public String getMsgErro() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(this.textErro));
		return this.textErro.getText();
	}

}
