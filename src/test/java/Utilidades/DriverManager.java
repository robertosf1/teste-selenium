package Utilidades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	private WebDriver driver;
	
	public WebDriver iniciarDriver() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver/chromedriver.exe");
//*************************************************************************************************************************************
		driver = new ChromeDriver();
		//driver.manage().window().maximize();  // nao utilizar com  jenkins

		//int testeHeight = driver.manage().window().getSize().height;
		//int testeWidth = driver.manage().window().getSize().width;

		//driver.close();

//*************************************************************************************************************************************
		//ChromeOptions options = new ChromeOptions();  // utilizar quando for personalizar n navegadores

		//	options.addArguments("window-size=" + testeWidth + "," + testeHeight);
		//	options.addArguments("--force-device-scale-factor=0.85");// Escalar o chrome para 85% de zoom
		//	options.addArguments("window-size=" + teste.width + "," + teste.height);
		//options.addArguments("--headless");

		//driver = new ChromeDriver();
		//driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String url ="http://www.aprendendotestar.com.br/treinar-automacao.php";
		driver.get(url);

		//waitManager = new WaitManager(driver);
				
		return driver;

	}

	public void fecharAba() {
		driver.close();
	}

	public void encerrarDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
