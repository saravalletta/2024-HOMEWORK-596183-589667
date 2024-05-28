package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = LettoreProperties.getMessBenvenuto();
	
	static final private String elencoComandi = LettoreProperties.getElencoComandi();
	
	private Partita partita;
	private IO io;

	public DiaDia(IO console, Labirinto labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		this.io = console;
		this.partita = new Partita(labirinto);
	}

	public void gioca() throws Exception {
		String istruzione; 
		//		Scanner scannerDiLinee;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();

		}while (!processaIstruzione(istruzione) );

	}    
	
	/**
	 * Processa una istruzione  
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.io);
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (ClassNotFoundException cne) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		} catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	public static void main(String[] argc) throws Exception{
		Scanner scanner = new Scanner(System.in);
		IO console = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		
		DiaDia gioco = new DiaDia(console, labirinto);
		gioco.gioca();
		scanner.close();
	}
} 
