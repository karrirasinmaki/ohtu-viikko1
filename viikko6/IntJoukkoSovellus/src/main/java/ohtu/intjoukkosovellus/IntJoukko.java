
package ohtu.intjoukkosovellus;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class IntJoukko {

    private int[] ljono;
   
    
    public IntJoukko() {
        ljono = new int[0];
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
        	return false;
        }
        ljono = ArrayUtils.add(ljono, luku);
        return true;
    }

    public boolean kuuluu(int luku) {
    	return ArrayUtils.contains(ljono, luku);
    }

    public boolean poista(int luku) {
    	int oldLen = ljono.length;
    	ljono = ArrayUtils.removeElement(ljono, luku);
    	if (ljono.length < oldLen) {
    		return true;
    	}
    	return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return ljono.length;
    }


    @Override
    public String toString() {
    	return "{" + StringUtils.join(ArrayUtils.toObject(ArrayUtils.clone(ljono)), ", ") + "}";
    }

    public int[] toIntArray() {
    	return ArrayUtils.clone(ljono);
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
    	return new IntJoukkoOperaatiot(a, b).yhdiste();
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
    	return new IntJoukkoOperaatiot(a, b).leikkaus();
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
    	return new IntJoukkoOperaatiot(a, b).erotus();
    }
        
}