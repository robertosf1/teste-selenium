package Utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Logger;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Tools {

	public static java.util.Properties getProp() throws IOException {
		
		java.util.Properties props = System.getProperties();
	    try {
			String diretorio = System.getProperty("user.dir");
			System.out.println(diretorio);
			diretorio = "src\\test\\java\\config.properties";
			System.out.println(diretorio);
			
			//FileInputStream file = new FileInputStream(diretorio);
			InputStream arquivo = new FileInputStream(diretorio);
		
			props.load(arquivo );
			
		} catch (IOException e) {
			System.out.println("Nao foi possivel ler arquivo properties! "+ e );
		}

        return props;
    }
	
	public static String carregaUrl(String tipo) {
		
		String url = "";

		java.util.Properties prop = System.getProperties();
		try {
			prop = Tools.getProp();
			
			if (tipo.contains("fake"))
				 url = prop.getProperty("urlfake");
			else if (tipo.contains("gmail"))
				url = prop.getProperty("urlgmail");
			else 
				url = prop.getProperty("url");
				
			Logger logger = Logger.getLogger("br.com.MinhaClasse");
			logger.info("url................: "+url);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return url;
		
	}
	
	public static void salvarMassa(String args[]) {
		
		try {
		
			String arquivo = "massa_cadastro.properties";
			File file = new File(arquivo);
			BufferedWriter writer = new BufferedWriter (new FileWriter(file));
			
			for (String linha : args) {
				writer.write(linha);
				writer.newLine();
			}
			
			writer.flush();
			writer.close();
			
			
		} catch (IOException e) {
			System.out.println("Nao foi possivel ler arquivo properties! "+ e );
		}

    }
	
	public static String[] lerMassa() {
		
		String arquivo = "massa_cadastro.properties";
		String massa[] = new String[4];

		try {

			int i =0;
			Scanner in = new Scanner(new FileReader(arquivo));
			while (in.hasNextLine()) {
			    String line = in.nextLine(); 
			    line = line.replace("nome=", "");
			    line = line.replace("senha=", "");
			    line = line.replace("usuario=", "");
			    line = line.replace("telefone=", "");
			    
			    massa[i] = line; 
			    System.out.println(line);
			    i++;
			}
			
		} catch (IOException e) {
			System.out.println("Nao foi possivel ler arquivo properties! "+ e );
		}
		return massa;

    }
	
}
