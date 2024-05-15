package it.uniroma3.diadia.ambienti;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		this.stanzaIniziale = new Stanza("appoggio1");
		this.stanzaVincente = new Stanza("appoggio2");
	}
	
	public static LabirintoBuilder Builder() {
		return new LabirintoBuilder();
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente; 
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale; 
	}
	
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
}
