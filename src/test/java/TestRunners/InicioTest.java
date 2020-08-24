package TestRunners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Login"},
		features = "src/test/resources/Features",
		glue = {"classpath:StepDefinitions"},    //path of the step definition files
		plugin = {"pretty",
				  "html:target/cucumber-reports",
				  "json:target/cucumber.json",
				  "junit:target/cucumber.xml"},

		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper btw feature file and step defn file
		)

// mvn install e mvn test e mvn clean
// para gerar cucumber reports e 
// add essa class no pow 
// <include>**/*InicioTest.java</include>
// mvn install
//  mvn package

//erro 
//mvn dependency::tree
//mvn clean install -U

public class InicioTest {

	static ExtentReports report  =new ExtentReports();;

	@BeforeClass
	public static void beforeSuiteTest()
	{
		Utilidades.Report.getReport();
	}

	//@AfterClass
	public static void afterSuite() {

		// fechar driver
		
	}
	
}