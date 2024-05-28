package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.LettoreProperties;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String elencoComandi = LettoreProperties.getElencoComandi();
	private final static String NOME = "aiuto";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(elencoComandi);
	}
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}