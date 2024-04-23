import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class testPartita {
	Partita partita = new Partita();
	Labirinto labirinto = new Labirinto();
	Giocatore giocatore = new Giocatore();
	Stanza stanzaTest1 = new Stanza("Stanza1");
	Stanza stanzaTest2 = new Stanza("Stanza2");

	@Test
	public void testSetStanzaCorrente() {
		partita.setStanzaCorrente(stanzaTest1);
		assertEquals(stanzaTest1, partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrenteSbagliata() {
		partita.setStanzaCorrente(stanzaTest1);
		assertNotEquals(stanzaTest2, partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrenteVuota() {
		partita.setStanzaCorrente(null);
		assertNull(partita.getStanzaCorrente());
	}
	
	@Test
	public void testVinta() { 
		labirinto.creaStanze();
		Stanza stanzaWin = labirinto.getStanzaVincente();
		labirinto.setStanzaVincente(stanzaWin); 
		partita.setStanzaCorrente(stanzaWin);
		assertTrue(partita.vinta()); 
	}
	
	@Test
	public void testVintaFalso() {
		labirinto.creaStanze();
		partita.setStanzaCorrente(stanzaTest1);
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testVintaNullo() {
		labirinto.creaStanze();
		partita.setStanzaCorrente(null);
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testIsFinita1() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaNonNullo() { 
		assertNotNull(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaFalso() {
		assertFalse(partita.isFinita());
	}
}
