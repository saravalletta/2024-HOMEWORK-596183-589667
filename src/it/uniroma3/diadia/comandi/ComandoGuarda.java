package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoGuarda implements Comando {
	private final static String NOME = "guarda";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		
		io.mostraMessaggio("Stanza corrente:" + stanzaCorrente.getNome());;
		io.mostraMessaggio("CFU rimasti:" + giocatore.getCfu());;
		io.mostraMessaggio(giocatore.getBorsa().toString());;
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
