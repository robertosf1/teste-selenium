package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Utilidades.DriverManager;

public class baseStepDef {
	
	protected static WebDriver driver;
	protected static DriverManager dManager = new DriverManager();

	protected static WebDriver getDriver() {
		if (driver == null) {
			driver = dManager.iniciarDriver();
		}
		return driver;
	}

	protected void closeDriver() {
		if (driver != null) {
			dManager.encerrarDriver();
			driver = null;
		}
	}

}
