package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import PageObjects.LoginPO;
import PageObjects.MenuPO;
import Utilidades.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginStepDef extends baseStepDef {

	ExtentReports report = Utilidades.Report.getReport();
		
	Format formatterArqHHmm = new SimpleDateFormat("yyyyMMdd-HHmm");
	String data = formatterArqHHmm.format(new Date(System.currentTimeMillis()));
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/Extent"+data+".html");

	//private static ExtentTest extFeature;
	private static ExtentTest extCenario;
	
	public WebDriver driver = baseStepDef.getDriver() ;
	private MenuPO menuPO = new MenuPO(driver);
	private LoginPO loginPO = new LoginPO(driver);

	@Dado("que estou na tela inicial do site")
	public void que_estou_na_tela_inicial_do_site() throws IOException, ClassNotFoundException {
		
 		String step = new Throwable().getStackTrace()[0].getMethodName();
		ExtentTest stepAssert = extCenario.createNode( "Dado "+step);
		
		try {
			menuPO.acessarTelaDeLogin(driver);
		
			System.out.print("titulo.: "+ this.loginPO.imgTitulo());
			assertEquals(this.loginPO.imgTitulo(), "Aprendendo a Testar");
			
			stepAssert.info("tela inicial ok");
		} catch (Exception e) {
			stepAssert.fail("Erro.: "+e.toString());
			assertTrue(false);
		} finally {
			Screenshot.capturaimagem(driver, "dado-tela-inicial", "inserir");
			stepAssert.addScreenCaptureFromPath("./print/" +"dado-tela-inicial.png");
		}
		
	}

	@Quando("insiro {string}, {string}, {string} e clico em ENVIAR")
	public void insiro_usuario_senha_nome_e_clico_em_ENVIAR(String username, String password, String nome) throws IOException {
		String step = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println("Quando "+ step);

		ExtentTest stepAssert = extCenario.createNode("Quando "+step);

		try {
			loginPO.preencherDados(username, password, nome).clicarEmEnviar();
			loginPO.moverAteTabela();
			loginPO.validoUsuarioInserido(nome);
			stepAssert.info("Usuario e senha ok");
			assertTrue(true);
		} catch (Exception e) {
			stepAssert.fail("Erro - Usuario nao inserido.: "+e.toString());
			assertFalse(true);
		} finally {
			Screenshot.capturaimagem(driver, "quando-usuario-adicionado", "conectar");
			stepAssert.addScreenCaptureFromPath( "./print/"+ "quando-usuario-adicionado.png");
		}
		
 	}

	
	@Entao("apago o usuario {string} inserido")
	public void e_apago_o_usuario_inserido(String nome) throws IOException {
		
		String step = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println("Entao "+ step);
		ExtentTest stepAssert = extCenario.createNode( "Entao " + step);
		try {
			loginPO.moverAteTabela();
			loginPO.clicoEmApagar(nome);
			loginPO.moverAteTabela();
			String campo = "//td[contains(text(),'"+ nome+"')]";
			List<WebElement> validarInsert = driver.findElements(By.xpath(campo));
			assertFalse(validarInsert.equals(campo));
			stepAssert.info("usuario excluido "+nome);
		} catch (Exception e) {
			stepAssert.fail("Erro.: "+e.toString());
			assertFalse(true);
		} finally {
			Screenshot.capturaimagem(driver, "entao-apago-usuario", "teste");
			stepAssert.addScreenCaptureFromPath( "./print/"+ "entao-apago-usuario.png");
		}
		
	}

	@Entao("valido a mensagem {string}")
	public void entao_valido_a_mensagem(String mensagem) throws IOException {
		
		String step = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println("Entao "+ step);
		ExtentTest stepAssert = extCenario.createNode( "Entao " + step);
			
		try {
 			loginPO.moverAteTabela();
			loginPO.validoMsgExibida(mensagem);
			stepAssert.info("Mensagem "+mensagem);
		} catch (Exception e) {
			stepAssert.fail("Erro.: "+e.toString());
			assertFalse(true);
		} finally {
			Screenshot.capturaimagem(driver, "entao-valido-mensagem", "mensagens");
			stepAssert.addScreenCaptureFromPath( "./print/"+ "entao-valido-mensagem.png");
		}
		
	}
	
	@E("atualizo a pagina")
	public void e_atualizo_a_pagina() throws IOException {
		
		String step = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println("Entao "+ step);
		ExtentTest stepAssert = extCenario.createNode( "E " + step);
			
		try {
 			loginPO.moverAteTabela();
 			loginPO.clicarEmAtualizar();
 			stepAssert.info("Pagina atualizada");
		} catch (Exception e) {
			stepAssert.fail("Erro.: "+e.toString());
			assertFalse(true);
		} finally {
			Screenshot.capturaimagem(driver, "e-atualizo-pagina", "atualizar");
			stepAssert.addScreenCaptureFromPath( "./print/"+ "e-atualizo-pagina.png");
		}
		
	}
	

	@Before()
	public void criaReportCenario() throws Exception
	{
		
		report.setGherkinDialect("pt");
		extCenario = report.createTest("login","Login");
		//extFeature = report.createTest(new GherkinKeyword("Funcionalidade"),"Login in Fvs");
		//extCenario = extFeature.createNode("Scenario","Login com usuario valido");
	}
	
	
	@After()
	public void fecharReport() throws IOException
	{

		htmlReporter = Utilidades.Report.formatExtentSparkReporter(htmlReporter);
		report.attachReporter(htmlReporter); 
		report.flush();
		//Utilidades.Pdf.createPdf("target/Extent.html","target/Extent.pdf");
		System.out.println("Report gerado");
		
		//driver.quit();
	}
	
}
	