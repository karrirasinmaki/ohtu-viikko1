package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSPelaajaParempiTekoaly extends KPSPelaajaTekoaly {
    
    public KPSPelaajaParempiTekoaly() {
    	super("Parannettu tekoäly", new TekoalyParannettu(20));
    }
    
}
