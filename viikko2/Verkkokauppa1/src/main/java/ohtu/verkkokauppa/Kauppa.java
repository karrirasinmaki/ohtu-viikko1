package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa implements KauppaInterface {

    private Varasto varasto;
    private Pankki pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori viitegeneraattori;
    private String kaupanTili;

	@Autowired
    public Kauppa(Varasto varasto, Pankki pankki, Viitegeneraattori viitegeneraattori) {
    	this.varasto = varasto;
    	this.pankki = pankki;
    	this.viitegeneraattori = viitegeneraattori;
        kaupanTili = "33333-44455";
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.KauppaInterface#aloitaAsiointi()
	 */
    @Override
	public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.KauppaInterface#poistaKorista(int)
	 */
    @Override
	public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.KauppaInterface#lisaaKoriin(int)
	 */
    @Override
	public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    /* (non-Javadoc)
	 * @see ohtu.verkkokauppa.KauppaInterface#tilimaksu(java.lang.String, java.lang.String)
	 */
    @Override
	public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
