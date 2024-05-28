import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;
 
public class testStanzaBuia {
	private StanzaBuia stanza;
	private Attrezzo lanterna; 
	 
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaBuia("StanzaBuia", "lanterna");
		lanterna = new Attrezzo("lanterna", 1);
	}

	@After 
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(lanterna);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "qui c'è un buio pesto, dammi l'attrezzo " + lanterna.getNome();
		assertEquals(e, stanza.getDescrizione());
	}
}
