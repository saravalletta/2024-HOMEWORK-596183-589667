package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	//private LabirintoBuilder labirinto;
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		//this.labirinto = new LabirintoBuilder(this);
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	private Labirinto(StringReader reader) throws FileNotFoundException, FormatoFileNonValidoException {
		//this.labirinto = new LabirintoBuilder(this);
		CaricatoreLabirinto c = new CaricatoreLabirinto(reader);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public static LabirintoBuilder newBuilder(StringReader reader) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(reader);
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
	
	public static class LabirintoBuilder {

		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> nome2stanza;

		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.nome2stanza = new HashMap<>();
		}
		
		public LabirintoBuilder(StringReader reader) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(reader);
			this.nome2stanza = new HashMap<>();
		}
		
		//public LabirintoBuilder(Labirinto labirinto) {
		//	this.labirinto = labirinto;
		//	this.nome2stanza = new HashMap<>();
		//}
		
		public Map<String, Stanza> getNome2stanza() {
			return nome2stanza;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza i = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaIniziale(i);
			this.UltimaStanzaAggiuntaEAggiorna(i);
			return this;
		}
		
		//public void setStanzaIniziale(String stanzaIniziale) {
		//	Stanza i = nome2stanza.get(stanzaIniziale);
		//	this.labirinto.setStanzaIniziale(i);
		//}

		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}
		
		//public void setStanzaVincente(String stanzaVincente) {
		//	Stanza v = nome2stanza.get(stanzaVincente);
		//	this.labirinto.setStanzaIniziale(v);
		//}

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}	

		public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
			Attrezzo a = new Attrezzo(attrezzo, peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzioni direzione) {
			Stanza c = this.nome2stanza.get(stanzaCorrente);
			Stanza a = this.nome2stanza.get(stanzaAdiecente);
			c.impostaStanzaAdiacente(direzione, a);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, Direzioni.valueOf(direzioneBloccata));
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}
		
		public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
			this.ultimaStanzaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}
	}
}
