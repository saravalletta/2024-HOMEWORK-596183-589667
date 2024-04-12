import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class testLabirinto {
	Labirinto labirinto = new Labirinto();
	Stanza stanza = new Stanza("stanzaTest");

	@Test
	public void testGetStanzaVincente() {
		labirinto.creaStanze();
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincenteSbagliato() {
		labirinto.creaStanze();
		assertNotEquals("Atrio", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincenteNonNullo() {
		labirinto.creaStanze();
		assertNotNull(labirinto.getStanzaVincente());
	}
	
	@Test
	public void testCreaStanze1() {
		labirinto.creaStanze();
		stanza = labirinto.getStanzaIniziale();
		assertEquals("Atrio", stanza.getNome());
	}
	
	@Test
	public void testCreaStanze2() {
		labirinto.creaStanze();
		stanza = labirinto.getStanzaIniziale();
		assertEquals("Aula N11", stanza.getStanzaAdiacente("est").getNome());
	}
	
	@Test
	public void testCreaStanzeSbagliato() {
		labirinto.creaStanze();
		stanza = labirinto.getStanzaIniziale();
		assertNotEquals("Laboratorio Campus", stanza.getNome());
	}
}
