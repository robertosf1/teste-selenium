package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Utilidades.WaitManager;

public class MenuPO { // extends MenuEM {
	
	public MenuPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
		new WaitManager(driver);
	}

	public LoginPO acessarTelaDeLogin(WebDriver driver) {
		return new LoginPO(driver);
	}
	
}
