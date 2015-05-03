package ohtu.kivipaperisakset;

public class KPSPeli {

	private Tuomari tuomari;
	private KPSPelaaja pelaaja1;
	private KPSPelaaja pelaaja2;
	private Integer maksimiMaaraPeleja;
	private int pelatutPelit = 0;

	public KPSPeli(KPSPelaaja pelaaja1, KPSPelaaja pelaaja2) {
		this(pelaaja1, pelaaja2, null);
	}
	
	public KPSPeli(KPSPelaaja pelaaja1, KPSPelaaja pelaaja2, Integer maksimiMaaraPeleja) {
		this.pelaaja1 = pelaaja1;
		this.pelaaja2 = pelaaja2;
		this.maksimiMaaraPeleja = maksimiMaaraPeleja;
	}

	public boolean annaSiirrot(String ekanSiirto, String tokanSiirto) {
		if (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
			tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
			pelaaja1.kaveriPelasi(tokanSiirto);
			pelaaja2.kaveriPelasi(ekanSiirto);
			return true;
		}
		return false;
	}

	public void pelaa() {
		tuomari = new Tuomari();
		while ((maksimiMaaraPeleja == null || pelatutPelit < maksimiMaaraPeleja) && 
				annaSiirrot(otaPelaajanSiirto(1, pelaaja1), otaPelaajanSiirto(2, pelaaja2))) {
			System.out.println(tuomari);
			System.out.println();
			pelatutPelit++;
		}
		System.out.println();
		System.out.println("Kiitos!");
		System.out.println(tuomari);
	}

	private String otaPelaajanSiirto(int pelaajaNumero, KPSPelaaja pelaaja) {
		System.out.println("Pelaaja " + pelaajaNumero + " (" + pelaaja.nimi()
				+ ") siirto: ");
		String siirto = pelaaja.siirto();
		System.out.println(siirto);
		return siirto;
	}

	private static boolean onkoOkSiirto(String siirto) {
		return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
	}

}
