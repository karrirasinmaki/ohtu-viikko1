package ohtu.kivipaperisakset;

public class KPSTehdas {

	public static KPSPeli henkiloVsTekoaly() {
		return new KPSPeli(new KPSPelaajaHenkilo("Pelaaja1"), new KPSPelaajaTekoaly());
	}
	
	public static KPSPeli henkiloVsHenkilo() {
		return new KPSPeli(new KPSPelaajaHenkilo("Pelaaja1"), new KPSPelaajaHenkilo("Pelaaja2"));
	}
	
	public static KPSPeli henkiloVsTekoalyParannettu() {
		return new KPSPeli(new KPSPelaajaHenkilo("Pelaaja1"), new KPSPelaajaParempiTekoaly());
	}
	
	public static KPSPeli tekoalyParannettuVsTekoalyParannettu(int maxPelit) {
		return new KPSPeli(new KPSPelaajaParempiTekoaly(), new KPSPelaajaParempiTekoaly(), maxPelit);
	}
	
}
