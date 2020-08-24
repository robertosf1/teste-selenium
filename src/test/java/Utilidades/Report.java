package Utilidades;

import org.junit.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	ExtentReports report = Utilidades.Report.getReport();
	static ExtentSparkReporter test = new ExtentSparkReporter("target/Extent.html");
	//https://github.com/extent-framework/extentreports-java/blob/master/src/test/java/com/aventstack/extentreports/reporter/SparkReporterTest.java
	
	public static ExtentReports getReport() {
		
		// http://extentreports.com/docs/versions/4/java/
		
		ExtentReports report = new ExtentReports();		
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		report.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		report.setSystemInfo("So", "Windows");
		report.setSystemInfo("Browser", "Chrome");

		return report;
	}

	@AfterClass
	public static void closedReport(ExtentReports report) {

		try {
			report.attachReporter(test);
			report.flush();
			
		} catch (Exception e) {
			System.out.println(" ***** erro login test.: "+e.toString());
		}
		
	}

	public static ExtentSparkReporter formatExtentSparkReporter(ExtentSparkReporter htmlReporter)
	{
		htmlReporter.config().enableOfflineMode(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setCSS("css-string");
		htmlReporter.config().setDocumentTitle("Teste");
		htmlReporter.config().enableTimeline(true);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setReportName("Teste");
		return htmlReporter;
	}
	
	public void addStep(ExtentReports report) {
		
	}
	
	public void addFigura(ExtentReports report) {
		
	}
	
}
