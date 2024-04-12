import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.*;

public class testBorsa {
	Borsa borsa = new Borsa();
	Attrezzo attrezzo1 = new Attrezzo("attrezzo1",1);
	Attrezzo attrezzo2 = new Attrezzo("attrezzo2",1);
	Attrezzo attrezzo3 = new Attrezzo("attrezzo3",1);

	
	@Test
	public void test1AddAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		assertTrue(borsa.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test2AddAttrezzo() {
		for(int i=0;i<10;i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo" + Integer.toString(i),1);
			borsa.addAttrezzo(attrezzo);
		}
		Attrezzo attrezzo11 = new Attrezzo("attrezzo11",1);
		assertFalse(borsa.addAttrezzo(attrezzo11));
	}
	
	@Test
	public void test3AddAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		assertFalse(borsa.addAttrezzo(attrezzo1));
	}
	
	
	@Test
	public void test1RemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		borsa.removeAttrezzo(attrezzo1);
		assertFalse(borsa.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test2RemoveAttrezzo(){
		borsa.removeAttrezzo(attrezzo1);
		assertFalse(borsa.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test3RemoveAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.removeAttrezzo(attrezzo1);
		assertTrue(borsa.hasAttrezzo("attrezzo2"));
		
	}
	
	@Test
	public void test1HasAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		assertTrue(borsa.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test2HasAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		assertFalse(borsa.hasAttrezzo("attrezzo2"));
	}
	
	@Test
	public void test3HasAttrezzo() {
		assertFalse(borsa.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	public void test4HasAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		assertTrue(borsa.hasAttrezzo("attrezzo1"));
		assertTrue(borsa.hasAttrezzo("attrezzo2"));
	}
}
