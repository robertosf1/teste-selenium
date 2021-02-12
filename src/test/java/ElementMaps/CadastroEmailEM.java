package ElementMaps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroEmailEM {

 	
		//$x('//input[@id="firstName"]')
		@FindBy(id="firstName")
		protected WebElement inputFirstName;
		
		@FindBy(id="lastName")
		protected WebElement inputLastName;
		
		@FindBy(id="username")
		protected WebElement inputUserName;

		//$x('//input[@name="Passwd"]')
		@FindBy(name="Passwd")
		protected WebElement inputPasswd;
		
		@FindBy(name="ConfirmPasswd")
		protected WebElement inputConfirmPasswd;
		
		//$x('//button[contains(.,"Pr�xima")]')
		@FindBy(xpath="//button[contains(.,\"Próxima\")]")
		protected WebElement buttonProxima;
		
		@FindBy(id="phoneNumberId")
		protected WebElement inputPhoneNumberId;
		
		//$x('//div[contains(.,"Este formato de")]')
		@FindBy(xpath="//div[contains(.,\"Este formato de\")]")
		protected WebElement textErro;
	
}
