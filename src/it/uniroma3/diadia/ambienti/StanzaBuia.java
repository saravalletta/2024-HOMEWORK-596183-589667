package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private  String attrezzoLucente;
	private boolean stanzaBuia;
	
	public StanzaBuia(String nome , String attrezzoLucente) {
		super(nome);
		this.attrezzoLucente = attrezzoLucente;
		stanzaBuia = true;
	}
	
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "qui c'è un buio pesto, dammi l'attrezzo " + attrezzoLucente;
		if(!this.hasAttrezzo(attrezzoLucente))
			return buio;
		else return super.getDescrizione();
	}
	
	@Override 
	public boolean isStanzaBuia() {
		return stanzaBuia;
	}
}
