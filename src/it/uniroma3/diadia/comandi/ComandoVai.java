package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {
	private String direzione;
	private final static String NOME = "vai";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro() == null) {
			this.io.mostraMessaggio("Sintassi del comando errata! Dimmi in quale direzione vuoi andare, per dubbi sulla sintassi digita <aiuto>");
		}
		if(this.getParametro()!=null ) {
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzioni.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				this.io.mostraMessaggio("Direzione inesistente");
				return;
			}
			
			if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		    }

			partita.setStanzaCorrente(prossimaStanza);
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			Giocatore giocatore = partita.getGiocatore();
			giocatore.setCfu(giocatore.getCfu() - 1);
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
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