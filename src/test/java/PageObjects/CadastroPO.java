package PageObjects;

import org.openqa.selenium.WebDriver;

import ElementMaps.CadastroEM;
import Utilidades.WaitManager;
import org.openqa.selenium.support.PageFactory;

public class CadastroPO extends CadastroEM{

	public WebDriver driver;
	
	public CadastroPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		new WaitManager(driver);
		
	}
	
	public CadastroPO telaInicial(WebDriver driver) {
		return new CadastroPO(driver);
	}
	
	
	
}
