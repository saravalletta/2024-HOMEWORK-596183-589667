import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class testFabbricaDiComandiFisarmonica {

	private FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
	private Comando comando;

	@Test
	public void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(), fabbrica.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		comando = new ComandoVai("");
		comando.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		assertEquals(comando.getNome(), current.getNome());
		assertEquals(comando.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		comando = new ComandoFine();
		assertEquals(comando.getNome(), fabbrica.costruisciComando("fine").getNome());
	}

}

