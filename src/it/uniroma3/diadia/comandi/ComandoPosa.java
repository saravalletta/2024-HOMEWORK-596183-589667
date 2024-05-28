package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private String attrezzo;
	private final static String NOME = "posa";
	private IO io;
	
	public ComandoPosa(String attrezzo) {
		this.attrezzo = attrezzo;
	}
	
	public ComandoPosa() {
		this.attrezzo = null;
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanza = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo a = borsa.getAttrezzo(this.attrezzo);
		
		if(a != null) {
			borsa.removeAttrezzo(a);
			stanza.addAttrezzo(a); 
			io.mostraMessaggio("POSATO!");
			
			if(partita.getStanzaCorrente().isStanzaBuia()) {
				io.mostraMessaggio(partita.getStanzaCorrente().toString());
			}
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
