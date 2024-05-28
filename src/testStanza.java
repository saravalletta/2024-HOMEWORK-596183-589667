import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
 
public class testStanza{
	Stanza stanza1 = new Stanza ("stanza1");
	Stanza stanza2 = new Stanza ("stanza2");
	Stanza stanza3 = new Stanza ("stanza3");
	Attrezzo attrezzo1 = new Attrezzo("attrezzo1",1);
	Attrezzo attrezzo2 = new Attrezzo("attrezzo2",1);
	Attrezzo attrezzo3 = new Attrezzo("attrezzo3",1);

	@Test
	public void test1ImpostaStanzaAdiacente() {
		stanza2.impostaStanzaAdiacente(Direzioni.nord, stanza1);
		assertSame(stanza1,stanza2.getStanzaAdiacente(Direzioni.nord));
	}
	
	@Test
	public void test2ImpostaStanzaAdiacente() {
		stanza3.impostaStanzaAdiacente(Direzioni.sud, stanza1);
		stanza3.impostaStanzaAdiacente(Direzioni.est, stanza2);
		assertNotSame(stanza1,stanza3.getStanzaAdiacente(Direzioni.ovest));
		assertSame(stanza2,stanza3.getStanzaAdiacente(Direzioni.est));
	}
	
	@Test
	public void test3ImpostaStanzaAdiacente() {
		stanza3.impostaStanzaAdiacente(Direzioni.ovest, stanza1);
		stanza3.impostaStanzaAdiacente(Direzioni.est, stanza2);
		assertSame(stanza1,stanza3.getStanzaAdiacente(Direzioni.ovest));
		assertSame(stanza2,stanza3.getStanzaAdiacente(Direzioni.est));
	}
	
	@Test
	public void test1AddAttrezzo() {
		assertTrue(stanza1.addAttrezzo(attrezzo1));
		assertTrue(stanza1.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test2AddAttrezzo() {
		for(int i=0;i<10;i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo" + Integer.toString(i),1);
			assertTrue(stanza1.addAttrezzo(attrezzo));
		}
		Attrezzo attrezzo11 = new Attrezzo("attrezzo11",1);
		assertFalse(stanza1.addAttrezzo(attrezzo11));
	}
	
	@Test
	public void test3AddAttrezzo() {
		assertTrue(stanza1.addAttrezzo(attrezzo1));
		assertFalse(stanza1.addAttrezzo(attrezzo1));
	}
	
	@Test
	public void test1RemoveAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		assertTrue(stanza1.hasAttrezzo("attrezzo1"));

	}
	
	@Test
	public void test2RemoveAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
		assertFalse(stanza1.hasAttrezzo("attrezzo"));

	}
	
	@Test
	public void test3RemoveAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		stanza1.addAttrezzo(attrezzo3);
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
		assertTrue(stanza1.hasAttrezzo("attrezzo2"));
		assertTrue(stanza1.hasAttrezzo("attrezzo3"));
	}
	
	@Test
	public void testHasAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		assertTrue(stanza1.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test2HasAttrezzo() {
		assertFalse(stanza1.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test3HasAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		assertTrue(stanza1.hasAttrezzo("attrezzo1"));
		assertTrue(stanza1.hasAttrezzo("attrezzo2"));
	}
	
	@Test
	public void test4HasAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		assertFalse(stanza1.hasAttrezzo("attrezzo2"));
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(stanza1.getStanzaAdiacente(Direzioni.sud));
	}
	

	@Test
	public void testImpostaStanzaAdiacente() {
		stanza1.impostaStanzaAdiacente(Direzioni.nord, stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente(Direzioni.nord));
	}
}
