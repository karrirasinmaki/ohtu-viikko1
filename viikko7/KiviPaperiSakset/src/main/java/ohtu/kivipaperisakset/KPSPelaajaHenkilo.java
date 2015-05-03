package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaHenkilo implements KPSPelaaja {

    private static final Scanner scanner = new Scanner(System.in);
    private String nimi;
    
    public KPSPelaajaHenkilo(String nimi) {
    	this.nimi = nimi;
	}

	@Override
	public String siirto() {
        return scanner.nextLine();
	}

	@Override
	public void kaveriPelasi(String siirto) {
		// Ei tehä mitään
	}

	@Override
	public String nimi() {
		return nimi;
	}
	
}