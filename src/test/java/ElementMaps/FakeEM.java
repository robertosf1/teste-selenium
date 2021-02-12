package ElementMaps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FakeEM {


	//$x('//input[@id="genbtn"]')
	@FindBy(id="//input[@id='genbtn']")
	protected WebElement btnGenerate;
	
	@FindBy(xpath="//div[@class=\"address\"]//h3")
	protected WebElement textNome;
	
	@FindBy(xpath="//dl[contains(.,\"maiden\")]//dd")
	protected WebElement textMotherName;

	@FindBy(xpath="	//dl[contains(.,\"Username\")]//dd")
	protected WebElement textUserName;

	@FindBy(xpath="	//dl[contains(.,\"Password\")]//dd")
	protected WebElement textSenha;
	
	@FindBy(xpath="	//dl[contains(.,\"Phone\")]//dd")
	protected WebElement textPhone;
}
