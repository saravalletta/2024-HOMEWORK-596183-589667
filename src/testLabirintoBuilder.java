import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testLabirintoBuilder {

	LabirintoBuilder lb;
 
	@Before
	public void setUp() throws Exception {
		lb = Labirinto.newBuilder("Labirinto1.txt");
	} 
 
	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetLabirinto() {
		assertNotNull(lb);
	}

	@Test
	public void testAddStanza() {
		lb.addStanza("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		assertEquals(expected.getNome(), lb.getNome2stanza().get("stanzetta").getNome());
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta(){
		
		//lb.addAttrezzo("cacciavite", 3);
		//Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("cacciavite", 3).getClass());
	} 
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		assertTrue(lb.getLabirinto().getStanzaIniziale().hasAttrezzo("cacciavite"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
        lb.addStanza("stanzetta");
        lb.addAttrezzo("cacciavite", 3);
        assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}