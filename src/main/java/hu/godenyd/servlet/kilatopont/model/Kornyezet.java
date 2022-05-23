package hu.godenyd.servlet.kilatopont.model;

public enum Kornyezet {
	NOVENYES,
	SZIKLAS;
	
	public static Kornyezet getByName(String name) {
		for (Kornyezet kornyezet : values()) {
			if (name.equals(kornyezet.name())) {
				return kornyezet;
			}
		}
		
		return null;
	}
}
