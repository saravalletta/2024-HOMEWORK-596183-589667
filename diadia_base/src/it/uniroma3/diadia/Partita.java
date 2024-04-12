package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Stanza stanzaCorrente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	 
	public Partita(){
		this.giocatore = new Giocatore();
		this.labirinto = new Labirinto();
		this.finita = false;
		this.labirinto.creaStanze();
		this.stanzaCorrente = labirinto.getStanzaIniziale();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente; 
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		if(this.getStanzaCorrente()==null) return false;
		else return this.getStanzaCorrente().getNome().equals(labirinto.getStanzaVincente().getNome());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || vinta() || (giocatore.getCfu()==0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}	
}
