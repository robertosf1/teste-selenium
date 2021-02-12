package StepDefinitions;


import PageObjects.FakePO;
import io.cucumber.java.pt.Quando;

public class FakeStepDef extends baseStepDef {

	FakePO fakePO = new FakePO(driver);
	
	@Quando("gero dados fake")
	public void gero_dados_fake()
	{
		fakePO.geroDados();
		driver.close();
	}
	
	
	
}
