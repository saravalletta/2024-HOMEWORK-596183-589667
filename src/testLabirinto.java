import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class testLabirinto {
	Labirinto l;
	Stanza N11;
	Stanza DS1;
  
	@Before
	public void setUp() {
		try {
			l = Labirinto.newBuilder("Labirinto1.txt").getLabirinto();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (FormatoFileNonValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		N11 = new Stanza("N11");
		DS1 = new Stanza("DS1");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("N11", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaIniziale(DS1);
		assertEquals("DS1", l.getStanzaIniziale().getNome());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("N10", l.getStanzaIniziale().getNome());
	}
}
