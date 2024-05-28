package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.LettoreProperties;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private static String MESSAGGIO_CANE = LettoreProperties.getMessCane();
	private static String CIBO_PREFERITO= LettoreProperties.getCiboPrefCane();

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public void agisci(Partita partita, IO io) {
		io.mostraMessaggio(MESSAGGIO_CANE);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");

		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito.");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 2));
		} else {
		risposta.append(attrezzo.getNome()+",ma non e' il mio cibo preferit, bau!");
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		
		return risposta.toString();
	}

}
