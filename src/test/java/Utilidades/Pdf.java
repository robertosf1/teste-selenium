package Utilidades;

import java.io.File;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;

public class Pdf {

	//public static final String SRC = "src/main/resources/html/sample.html";
	//public static final String DEST = "target/results/sample.pdf";
	//https://search.maven.org/artifact/com.itextpdf/html2pdf/3.0.0/jar
	public static void createPdf(String src, String dest) throws IOException {
		
	    HtmlConverter.convertToPdf(new File(src), new File(dest));
	}
		
	
}
