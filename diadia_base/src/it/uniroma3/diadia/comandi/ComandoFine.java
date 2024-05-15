package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private final static String NOME = "fine";
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");
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
