package ohtu.kivipaperisakset;

public class KPSPelaajaTekoaly implements KPSPelaaja {

    private Tekoaly tekoaly;
    private String nimi;
    
    public KPSPelaajaTekoaly() {
    	this("Tekoäly", new TekoalyYksinkertainen());
	}
    
    public KPSPelaajaTekoaly(String nimi, Tekoaly tekoaly) {
    	super();
    	this.nimi = nimi;
    	this.tekoaly = tekoaly;
	}

	@Override
	public String nimi() {
		return nimi;
	}

	@Override
	public String siirto() {
		return tekoaly.annaSiirto();
	}

	@Override
	public void kaveriPelasi(String siirto) {
        tekoaly.asetaSiirto(siirto);
	}
	
}