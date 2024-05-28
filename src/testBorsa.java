import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
 
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.*;

public class testBorsa {
	Borsa b;
	Borsa b1;
	Borsa b2;
	Attrezzo falce;
	Attrezzo pala;
	Attrezzo sega;
	Attrezzo martello;
	Attrezzo computer;
	Attrezzo laptop;
	Attrezzo racchetta;

	
	@Before
	public void setUp() {
		b = new Borsa();
		b1 = new Borsa();
		b2 = new Borsa();
		falce = new Attrezzo("falce", 2);
		pala = new Attrezzo("pala", 3);
		racchetta = new Attrezzo("racchetta", 3);
		martello = new Attrezzo("martello", 2);
		sega = new Attrezzo("sega", 16);
		computer = new Attrezzo("computer", 2);
		laptop = new Attrezzo("laptop", 4);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(sega));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));

	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		b1.addAttrezzo(falce);
		b1.addAttrezzo(martello);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(falce);
		expected.add(martello);
		assertArrayEquals(expected.toArray(), b1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(falce);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(falce);
		ex.add(martello);
		assertTrue(this.controllaList(ex, b2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoPesiDiversi() {
		b2.addAttrezzo(computer);
		b2.addAttrezzo(laptop);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(computer);
		ex.add(laptop);
		//System.out.println(b2.getContenutoOrdinatoPerPeso());
		assertTrue(this.controllaList(ex, b2.getContenutoOrdinatoPerPeso()));
	}
	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}

	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true; 
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiGruppi() {
		b2.addAttrezzo(martello);
		b2.addAttrezzo(pala);
		b2.addAttrezzo(racchetta);
		b2.addAttrezzo(falce);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new HashSet<>();
		Set<Attrezzo> sing2 = new HashSet<>();
		
		sing1.add(martello);
		sing2.add(pala);
		sing2.add(racchetta);
		sing1.add(falce);
		
		e.put(2, sing1);
		e.put(3, sing2);
		
		System.out.println(e);
		System.out.println(b2.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b2.getContenutoRaggruppatoPerPeso()));
	}
}
