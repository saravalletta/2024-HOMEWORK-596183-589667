import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testStanzaBuia {
	private StanzaBuia stanza = new StanzaBuia("StanzaBuia", "candela");
	private Attrezzo candela = new Attrezzo("candela", 1);

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(candela);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "qui c'è un buio pesto";
		assertEquals(e, stanza.getDescrizione());
	}
}
