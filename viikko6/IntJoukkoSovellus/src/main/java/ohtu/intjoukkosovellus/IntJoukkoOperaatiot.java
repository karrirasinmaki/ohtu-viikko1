package ohtu.intjoukkosovellus;

public class IntJoukkoOperaatiot {

    int[] aTaulu;
    int[] bTaulu;
    
	public IntJoukkoOperaatiot(IntJoukko a, IntJoukko b) {
        aTaulu = a.toIntArray();
        bTaulu = b.toIntArray();
	}

    public IntJoukko yhdiste() {
        return lisaa(new IntJoukko(), aTaulu, bTaulu);
    }

    public IntJoukko leikkaus() {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public IntJoukko erotus() {
        return poista(lisaa(new IntJoukko(), aTaulu), bTaulu);
    }
    
    private IntJoukko lisaa(IntJoukko x, int[] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            x.lisaa(taulu[i]);
        }
        return x;
    }
    
    private IntJoukko lisaa(IntJoukko x, int[] taulu1, int[]... taulut) {
    	lisaa(x, taulu1);
    	if (taulut == null) return x;
    	for (int i = 0, l = taulut.length; i < l; i++) {
    		lisaa(x, taulut[i]);
    	}
        return x;
    }
    
    private IntJoukko poista(IntJoukko x, int[] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            x.poista(taulu[i]);
        }
        return x;
    }
    
    private IntJoukko poista(IntJoukko x, int[] taulu1, int[]... taulut) {
    	poista(x, taulu1);
    	if (taulut == null) return x;
    	for (int i = 0, l = taulut.length; i < l; i++) {
    		poista(x, taulut[i]);
    	}
        return x;
    }
    
}
