package hu.godenyd.servlet.kilatopont.model;

import java.util.ArrayList;
import java.util.List;

public class Hegyseg {

	private List<Kilatopont> kilatopontok;
	private Kilatopont currentKilatopont = null;
	
	private static Hegyseg instance = null;
	
	private Hegyseg() {
		kilatopontok = new ArrayList<>();
	}
	
	public static Hegyseg getHegyseg() {
		
		if (instance == null) {
			instance = new Hegyseg();
		}
		
		return instance;
	}
	
	public void addKilato(Kilatopont kilato) {
		kilatopontok.add(kilato);
	}
	
	private Kilatopont getNextKilatopont(int currentKilato) {
		return kilatopontok.get(currentKilato++);
	}
	
	public Kilatopont getNextKilatopont(Kilatopont currentKilato) {
		return getNextKilatopont(kilatopontok.indexOf(currentKilato));
	}
	
	public void restartTour() {
		if (kilatopontok.size() > 0) {
			currentKilatopont = kilatopontok.get(0);
		}
	}
}
