package Utilidades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {
	private WebDriver driver;

	public WaitManager(WebDriver driver) {
		this.driver = driver;
	}

	public void aguardarElementoSerVisivel(WebElement webElement) {
		new WebDriverWait( driver, 30);
	}

	public void aguardarTextoMudar(WebElement webElement, String message) {
		new WebDriverWait( driver, 30);
	}
	
}
