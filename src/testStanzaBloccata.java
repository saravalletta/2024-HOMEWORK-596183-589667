import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testStanzaBloccata {
	private StanzaBloccata sb = new StanzaBloccata("StanzaBloccata", "ovest", "piede di porco");
	private Stanza s = new Stanza("Stanzetta");
	private Attrezzo a = new Attrezzo("piede di porco", 1);

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		sb.impostaStanzaAdiacente("ovest", s);
		assertEquals(sb, sb.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.impostaStanzaAdiacente("ovest", s);
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("ovest"));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.impostaStanzaAdiacente("ovest", s);
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Stanza bloccata nella direzione: ovest"+"\nPrendi il piede di porco e posalo nella stanza";
		assertEquals(e, sb.getDescrizione());
		
	}

}
