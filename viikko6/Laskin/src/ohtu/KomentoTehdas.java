package ohtu;

import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

public class KomentoTehdas {
	
	private HashMap<JButton, Komento> komennot;
	
	private JTextField tuloskentta;
	private JTextField syotekentta;
	private Sovelluslogiikka sovellus;
	
	public KomentoTehdas(Sovelluslogiikka sovellus, JTextField tuloskentta,
			JTextField syotekentta) {
		this.sovellus = sovellus;
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		komennot = new HashMap<JButton, Komento>();
	}
	
	public void lisaa(JButton button, Komento komento) {
		komento.alusta(sovellus, tuloskentta, syotekentta);
		komennot.put(button, komento);
	}

	public Komento hae(ActionEvent ae) {
		return komennot.get(((JButton) ae.getSource()));
	}
	
}
