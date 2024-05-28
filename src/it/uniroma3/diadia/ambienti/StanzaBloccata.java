package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private Direzioni direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, String attrezzoSbloccante, Direzioni direzioneBloccata) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
 
	@Override
	public Stanza getStanzaAdiacente(Direzioni direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante + " e posalo nella stanza";

		if(!this.hasAttrezzo(attrezzoSbloccante))
			return bloccata;
		return super.getDescrizione();
	}
	
	@Override
	public boolean isStanzaBuia() {
		return false;
	}
}
