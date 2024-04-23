package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi <nome attrezzo>", "posa <nome attrezzo>", "guarda"};
	private final static String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<elencoComandi.length; i++) {
			System.out.println(elencoComandi[i]+" ");
		}
		System.out.println(" ");
	}
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
