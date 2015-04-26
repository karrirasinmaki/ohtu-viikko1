package ohtu;

import java.util.LinkedList;

public class Sovelluslogiikka {
	
	private LinkedList<Integer> historia = new LinkedList<Integer>();
 
    private int tulos;
 
    public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
    
    public void tulos(int tulos) {
    	this.tulos = tulos;
    }
    
    public int edellinen() {
    	int palautettava = historia.isEmpty() ? 0 : historia.pop();
    	tulos(palautettava);
    	return palautettava;
    }
    
    public void edellinen(int arvo) {
    	historia.push(arvo);
    }
    
}