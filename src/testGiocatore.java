import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class testGiocatore {
	Giocatore giocatore = new Giocatore();
 
	@Test
	public void testGetCfu() { 
		giocatore.setCfu(10); 
		assertEquals(giocatore.getCfu(), 10);
	}
	
	@Test
	public void testGetCfuFalso() {
		giocatore.setCfu(8);
		assertNotEquals(giocatore.getCfu(), 5);
	}
	
	@Test
	public void testGetCfuNonNullo() {
		giocatore.setCfu(6);
		assertNotNull(giocatore.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		new Borsa();
		assertNotNull(giocatore.getBorsa());
	}

}
