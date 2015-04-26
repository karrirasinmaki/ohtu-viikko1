package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    
    private KomentoTehdas komentoTehdas;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        
        this.komentoTehdas = new KomentoTehdas(sovellus, tuloskentta, syotekentta);
        komentoTehdas.lisaa(plus, new Summa());
        komentoTehdas.lisaa(miinus, new Erotus());
        komentoTehdas.lisaa(nollaa, new Nollaa());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	Komento komento = komentoTehdas.hae(ae);
 
        if (komento != null) {
        	komento.suorita();
        } else {
            sovellus.edellinen();
        }
        
        int laskunTulos = sovellus.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        if ( laskunTulos==0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);
    }
 
}