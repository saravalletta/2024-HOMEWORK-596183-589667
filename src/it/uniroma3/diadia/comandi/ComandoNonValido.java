package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private final static String NOME = "comando non valido";
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando sconosciuto");
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
