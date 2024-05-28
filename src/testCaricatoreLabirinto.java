import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.StringReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testCaricatoreLabirinto {

	private final String monolocale = 
			"Stanze:biblioteca\n"+
			"Magica:\n"+
			"Buia:\n"+ 
			"Bloccata:\n"+
			"Inizio:biblioteca\n"+
			"Vincente:biblioteca\n"+
			"Mago:\n"+
			"Cane:\n"+ 
			"Strega:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";

	private final String bilocale = 
			"Stanze:N12,N11\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:N12\n"+
			"Vincente:N11\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:martello 3 N12\n"+
			"Uscite:\n";
	 
	private Labirinto lab;

	@Test
	public void testMonolocale() throws FormatoFileNonValidoException, FileNotFoundException {
		lab = Labirinto.newBuilder(new StringReader(monolocale)).getLabirinto();
		assertEquals("biblioteca", this.lab.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.lab.getStanzaVincente().getNome());
	}
	
	@Test
	public void testBilocale() throws FormatoFileNonValidoException, FileNotFoundException {
		lab = Labirinto.newBuilder(new StringReader(bilocale)).getLabirinto();
		assertEquals("N12", this.lab.getStanzaIniziale().getNome());
		assertEquals("N11", this.lab.getStanzaVincente().getNome());
	}
	
	
	@Test
	public void testBilocaleAttrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		lab = Labirinto.newBuilder(new StringReader(bilocale)).getLabirinto();
		Attrezzo expected = new Attrezzo("martello", 3);
		assertEquals(expected.getNome(), this.lab.getStanzaIniziale().getAttrezzo("martello").getNome());
	}
}
