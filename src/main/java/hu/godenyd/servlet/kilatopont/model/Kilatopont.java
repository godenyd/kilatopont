package hu.godenyd.servlet.kilatopont.model;

public class Kilatopont extends Hely implements ILatnivalo {

	public Kilatopont(String nev, int magassag, Kornyezet kornyezet) {
		super(nev, magassag, kornyezet);
		
	}

	@Override
	public void letogatokRogzitese() {
		
	}

	public String serialize() {
		return getNev() + ";" + getMagassag() + ";" + getKornyezet().name();
	}
	
	public static Hely deserialize(String value) {
		String[] values = value.split(";");
		
		return new Kilatopont(values[0], Integer.parseInt(values[1]), Kornyezet.getByName(values[2]));
	}
}
