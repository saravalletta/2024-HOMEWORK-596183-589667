import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class testComandoPrendi {

	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Comando comando; 
	Labirinto labirinto; 
	
	@Before 
	public void setUp() throws Exception {
		labirinto = Labirinto.newBuilder("Labirinto1.txt").getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 11);
		comando = new ComandoPrendi();
	}


	@After
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String s) {
		//Set<Attrezzo> set = partita.getStanzaCorrente().getAttrezzi();
		if(partita.getStanzaCorrente().getAttrezzo(s)==null)
			return false;
		return true;
		}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.esegui(partita);
		comando.setParametro("martello");
		assertTrue(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.esegui(partita);
		comando.setParametro("incudine");
		assertTrue(attrezzoPresente("incudine"));
	}
	
}
