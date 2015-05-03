package ohtu.kivipaperisakset;

// "Muistava tekoäly"

public class TekoalyParannettu implements Tekoaly {
	private String[] muisti;
	private int vapaaMuistiIndeksi;

	public TekoalyParannettu(int muistinKoko) {
		muisti = new String[muistinKoko];
		vapaaMuistiIndeksi = 0;
	}

	/**
	 * Jos muisti täyttyy, unohdetaan viimeinen alkio
	 * @param siirto
	 */
	private void kirjoitaMuistiin(String siirto) {
		if (vapaaMuistiIndeksi == muisti.length) {
			unohdaViimeinenAlkio();
		}
		muisti[vapaaMuistiIndeksi] = siirto;
		vapaaMuistiIndeksi++;
	}

	private void unohdaViimeinenAlkio() {
		for (int i = 1; i < muisti.length; i++) {
			muisti[i - 1] = muisti[i];
		}
		vapaaMuistiIndeksi--;
	}
	
	/**
	 * Tehdään siirron valinta esimerkiksi seuraavasti;
	 * - jos kiviä eniten, annetaan aina paperi
	 * - jos papereita eniten, annetaan aina sakset
	 * - muulloin annetaan aina kivi
	 * 
	 * Tehokkaampiakin tapoja löytyy, mutta niistä lisää
	 * Johdatus Tekoälyyn kurssilla!
	 * 
	 * @param kivet
	 * @param paperit
	 * @param sakset
	 * @return
	 */
	private String valitseSiirto(int kivet, int paperit, int sakset) {
		if (kivet > paperit && kivet > sakset) {
			return "p";
		} else if (paperit > kivet && paperit > sakset) {
			return "s";
		} else {
			return "k";
		}
	}
	
	private String valitseSiirto() {
		if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
			return "k";
		}

		String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

		int k = 0;
		int p = 0;
		int s = 0;

		for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
			if (viimeisinSiirto.equals(muisti[i])) {
				String seuraava = muisti[i + 1];

				if ("k".equals(seuraava)) {
					k++;
				} else if ("p".equals(seuraava)) {
					p++;
				} else {
					s++;
				}
			}
		}
		
		return valitseSiirto(k, p, s);
	}
	
	@Override
	public void asetaSiirto(String siirto) {
		kirjoitaMuistiin(siirto);
	}

	@Override
	public String annaSiirto() {
		return valitseSiirto();
	}
}