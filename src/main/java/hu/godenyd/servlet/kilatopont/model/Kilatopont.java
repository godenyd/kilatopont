package hu.godenyd.servlet.kilatopont.model;

import java.io.IOException;
import java.util.stream.Stream;

import hu.godenyd.servlet.kilatopont.util.LatogatoUtil;

public class Kilatopont extends Hely implements ILatnivalo {

	public Kilatopont(String nev, int magassag, Kornyezet kornyezet) {
		super(nev, magassag, kornyezet);
		
	}

	@Override
	public void latogatokRogzitese() {
		try {
			LatogatoUtil.writeToFile(Hegyseg.getHegyseg().getKilatoIndex(this));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String serialize() {
		return getNev() + ";" + getMagassag() + ";" + getKornyezet().name();
	}
	
	public static Kilatopont deserialize(String value) {
		
		String[] values = value.split(";");
		
		return new Kilatopont(values[0], Integer.parseInt(values[1]), Kornyezet.getByName(values[2]));
	}
}
