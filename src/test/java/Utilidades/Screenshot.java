package Utilidades;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void capturaimagem(WebDriver driver, String bug_name, String log) throws IOException{

		try {
			String diretoriorelatorio =  "target/print";

			File srcFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String figura = diretoriorelatorio+"\\" + bug_name + ".png";

			FileUtils.copyFile(srcFile, new File(figura));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
