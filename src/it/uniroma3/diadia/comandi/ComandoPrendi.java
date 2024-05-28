package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String attrezzo;
	private final static String NOME = "prendi";
	private IO io;
	
	public ComandoPrendi(String attrezzo) {
		this.attrezzo = attrezzo;
	}
	
	public ComandoPrendi() {
		this.attrezzo = null;
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanza = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo a = stanza.getAttrezzo(attrezzo);
		if(a != null) {
			stanza.removeAttrezzo(a);
			borsa.addAttrezzo(a);
			io.mostraMessaggio("PRESO!");
		}
	}
	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.attrezzo;
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