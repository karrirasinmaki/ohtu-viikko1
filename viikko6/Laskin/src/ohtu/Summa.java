package ohtu;

import javax.swing.JTextField;

public class Summa extends Komento {
    
	public Summa() {}
	
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta,
			JTextField syotekentta) {
		super(sovellus, tuloskentta, syotekentta);
	}

	@Override
	public void suorita_() {
		sovellus.plus(Integer.parseInt(syotekentta.getText()));
	}

}
