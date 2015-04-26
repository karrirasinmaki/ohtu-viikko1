package ohtu;

import javax.swing.JTextField;

public abstract class Komento {
	protected abstract void suorita_();
	
	protected JTextField tuloskentta;
	protected JTextField syotekentta;
	protected Sovelluslogiikka sovellus;
	
	public void peru() {
		sovellus.edellinen();
	}
	
	public void suorita() {
		sovellus.edellinen(sovellus.tulos());
		suorita_();
	}
	
	public Komento() {
	}
	
	public Komento(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
		alusta(sovellus, tuloskentta, syotekentta);
	}

	public void alusta(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
		this.sovellus = sovellus;
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
	}
	
}
