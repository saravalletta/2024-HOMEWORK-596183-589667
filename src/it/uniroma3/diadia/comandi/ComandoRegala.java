package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	private IO io;

	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			io.mostraMessaggio("Sintassi del comando errata! Dimmi quale oggetto vuoi regalare, per dubbi sulla sintassi digita <aiuto>");
		}
		else {
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
		}
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
