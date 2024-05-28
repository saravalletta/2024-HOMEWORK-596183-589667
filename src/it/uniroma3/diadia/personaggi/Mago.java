package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.LettoreProperties;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = LettoreProperties.getMessDonoMago();
	private static final String MESSAGGIO_SCUSE = LettoreProperties.getMessScuseMago();
	private Attrezzo attrezzo;
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	@Override
	public void agisci(Partita partita, IO io) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			io.mostraMessaggio(MESSAGGIO_DONO);
		}
		else {
			io.mostraMessaggio(MESSAGGIO_SCUSE);
		}
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Grazie per avermi regalato ");
		risposta.append(attrezzo.getNome()+".");
		risposta.append(" Lo modificherò e lo lascerò!");
		Attrezzo attrezzoModificato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoModificato);
		return risposta.toString();
	}
}