package ohtu.verkkokauppa;

public interface KauppaInterface {

	public abstract void aloitaAsiointi();

	public abstract void poistaKorista(int id);

	public abstract void lisaaKoriin(int id);

	public abstract boolean tilimaksu(String nimi, String tiliNumero);

}