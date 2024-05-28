package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.LettoreProperties;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	private static final String MESSAGGIO_SALUTATA = LettoreProperties.getMessSalStrega();
	private static final String MESSAGGIO_NON_SALUTATA = LettoreProperties.getMessNonSalStrega();

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public void agisci(Partita partita, IO io) {;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();

		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAttrezzi.getNumeroAttrezzi())
					maxAttrezzi = s;
				if(s.getNumeroAttrezzi() < minAttrezzi.getNumeroAttrezzi())
					minAttrezzi = s;
			}
		}

		if(this.haSalutato()) {
			io.mostraMessaggio(MESSAGGIO_SALUTATA);
			partita.setStanzaCorrente(maxAttrezzi);
			io.mostraMessaggio("\nLa strega ti ha teletrasportato in \n" + partita.getStanzaCorrente().getDescrizione());
		} else {
			io.mostraMessaggio(MESSAGGIO_NON_SALUTATA);
			partita.setStanzaCorrente(minAttrezzi);
			io.mostraMessaggio("\nLa strega ti ha teletrasportato in \n" + partita.getStanzaCorrente().getDescrizione());
		}
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "AHAHAHAHAHAHHA";
	}

}