import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testComandoPosa {
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	private Comando comando;
	Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = Labirinto.newBuilder("Labirinto1.txt").getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		attrezzo2 = new Attrezzo("cacciavite", 1);
		comando = new ComandoPosa();
	}

	@After 
	public void tearDown() throws Exception {
	}

	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.esegui(partita);
		comando.setParametro("martello");
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}


	public void creatoreAttrezzi() {
		for(int i= 0; i<10;i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
		}
	}
	
	@Test
	public void testPiuAttrezzi() {
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.esegui(partita);
		comando.setParametro("martello");
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}

}
