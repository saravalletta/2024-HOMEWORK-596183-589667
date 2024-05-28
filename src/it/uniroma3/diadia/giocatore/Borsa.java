package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.LettoreProperties;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = LettoreProperties.getPesoMax();
	private Map<String, Attrezzo> attrezzi;
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int peso;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new TreeMap<>(); // speriamo bastino...
		this.numeroAttrezzi = 0;
		this.peso = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getAttrezzo(attrezzo.getNome())!=null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		this.peso += attrezzo.getPeso();
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		//TODO
		Attrezzo a = null;
		if(nomeAttrezzo!=null && this.attrezzi.containsKey(nomeAttrezzo)) {
			a = this.attrezzi.get(nomeAttrezzo);
		}
		return a;
	} 
	
	public int getPeso() {
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	 
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public void removeAttrezzo(Attrezzo attrezzo) {
		String a = attrezzo.getNome();
		int peso = attrezzo.getPeso();
		if(a!=null && this.attrezzi.containsKey(a)) {
			this.peso -= peso;
			this.attrezzi.remove(a);
			numeroAttrezzi--;
		}
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo!=null){
			int peso = nome2attrezzi.get(nomeAttrezzo).getPeso();
			this.peso -= peso;
			a = nome2attrezzi.remove(nomeAttrezzo);
		}
		return a;
	}

	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append("\n");
			s.append("Contenuto ordinato per peso:");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerPeso().toString());
			s.append("\n");
			s.append("Contenuto ordinato per nome:");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append("Contenuto raggruppato per peso:");
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append("Contenuto ordinato per peso:");
			s.append("\n");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerNome());
		s.addAll(this.attrezzi.values());
		return s;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> map = new TreeMap<>();
		
		for(Attrezzo a : this.attrezzi.values()) {
			if(map.containsKey(a.getPeso())) {
				map.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> tmp = new HashSet<Attrezzo>();
				tmp.add(a);
				map.put(a.getPeso(), tmp);
			}
		}
		
		return map;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.attrezzi.values());
		return s;
	}
}