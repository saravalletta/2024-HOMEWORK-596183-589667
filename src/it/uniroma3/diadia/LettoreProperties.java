package it.uniroma3.diadia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LettoreProperties {
	private static final String DIADIA_PROPERTIES = "diadia.properties";
	
	private static final String CFU = "cfu";
	private static final String PESO_MAX = "pesoMax";
	private static final String MESSAGGIO_BENVENUTO  = "messaggioBenvenuto";
	private static final String ELENCO_COMANDI = "elencoComandi";
	private static final String MESSAGGIO_CANE = "messaggioCane";
	private static final String CIBO_PREF_CANE = "ciboPrefCane";
	private static final String MESSAGGIO_DONO_MAGO = "messaggioDonoMago";
	private static final String MESSAGGIO_SCUSE_MAGO = "messaggioScuseMago";
	private static final String MESSAGGIO_SALUTATA_STREGA = "messaggioSalStrega";
	private static final String MESSAGGIO_NON_SALUTATA_STREGA = "messaggioNonSalStrega";
	
	private static Properties properties = null;
	
	private static void carica() {
		properties = new Properties();
		
		try {
			FileInputStream input = new FileInputStream(DIADIA_PROPERTIES);
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getCFU() {
		if(properties==null) carica();
		return Integer.parseInt(properties.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(properties==null) carica();
		return Integer.parseInt(properties.getProperty(PESO_MAX));
	}
	
	public static String getMessBenvenuto() {
		if(properties==null) carica();
		return properties.getProperty(MESSAGGIO_BENVENUTO);
	}
	
	public static String getElencoComandi() {
		if(properties==null) carica();
		return properties.getProperty(ELENCO_COMANDI);
	}
	
	public static String getMessCane() {
		if(properties==null) carica();
		return properties.getProperty(MESSAGGIO_CANE);
	}
	
	public static String getCiboPrefCane() {
		if(properties==null) carica();
		return properties.getProperty(CIBO_PREF_CANE);
	}
	
	public static String getMessDonoMago() {
		if(properties==null) carica();
		return properties.getProperty(MESSAGGIO_DONO_MAGO);
	}
	
	public static String getMessScuseMago() {
		if(properties==null) carica();
		return properties.getProperty(MESSAGGIO_SCUSE_MAGO);
	}
	
	public static String getMessSalStrega() {
		if(properties==null) carica();
		return properties.getProperty(MESSAGGIO_SALUTATA_STREGA);
	}
	
	public static String getMessNonSalStrega() {
		if(properties==null) carica();
		return properties.getProperty(MESSAGGIO_NON_SALUTATA_STREGA);
	}
}
