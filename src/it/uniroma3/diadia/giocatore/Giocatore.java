package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.LettoreProperties;

public class Giocatore {
	private int cfu = 20;
	private Borsa borsa;
	static final private int CFU_INIZIALI = LettoreProperties.getCFU();
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
}