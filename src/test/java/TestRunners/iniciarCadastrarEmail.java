package TestRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	//tags = {"@e2e"},
	tags = {"@CadastrarEmail"},//"@DadosFake"},
	//tags = {"@DadosFake"}, //"@CadastrarEmail"},
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


public class iniciarCadastrarEmail {
		
}
