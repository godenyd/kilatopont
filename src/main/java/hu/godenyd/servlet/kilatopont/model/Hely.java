package hu.godenyd.servlet.kilatopont.model;

public abstract class Hely {

	private String nev;
	private int magassag;
	private Kornyezet kornyezet;
	
	public Hely(String nev, int magassag, Kornyezet kornyezet) {
		this.nev = nev;
		this.magassag = magassag;
		this.kornyezet = kornyezet;
	}
	
	public String getNev() {
		return this.nev;
	}
	
	public int getMagassag() {
		return this.magassag;
	}
	
	public Kornyezet getKornyezet() {
		return this.kornyezet;
	}

}
