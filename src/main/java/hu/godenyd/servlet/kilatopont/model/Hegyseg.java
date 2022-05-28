package hu.godenyd.servlet.kilatopont.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import hu.godenyd.servlet.kilatopont.util.KilatoSerializerUtil;
import hu.godenyd.servlet.kilatopont.util.LatogatoUtil;

public class Hegyseg {

	private List<Kilatopont> kilatopontok;
	private Kilatopont currentKilatopont = null;
	
	private static Hegyseg instance = null;
	
	// initialize hegyseg
	private Hegyseg() {
		
		instance = this;
		
		Optional<String> hegysegString = Optional.empty();
		
		int currentIndex = -1;
		
		try {
			hegysegString = KilatoSerializerUtil.readHegysegFromFile();
			currentIndex = LatogatoUtil.readFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			kilatopontok = new ArrayList<>();
			hegysegString.ifPresent(hegyseg -> instance.deserialize(hegyseg));
			System.out.println("index in const: " + currentIndex);
			currentKilatopont = kilatopontok.get(currentIndex);
		}
		
	}
	
	public static Hegyseg getHegyseg() {
		
		if (instance == null) {
			new Hegyseg();
		}
		
		return instance;
	}
	
	public void addKilato(Kilatopont kilato) {
		kilatopontok.add(kilato);
		KilatoSerializerUtil.writeHegysegToFile(this);
	}
	
	public void advanceToNextKilato() {
		int currentIndex = getKilatoIndex(currentKilatopont);
		
		System.out.println("current index: " + currentIndex);
		
		if (currentIndex == kilatopontok.size() - 1) {
			currentIndex = -1;
		}
		currentKilatopont = kilatopontok.get(++currentIndex);
		currentKilatopont.latogatokRogzitese();
	}
	
	public Kilatopont getCurrentKilatopont() {
		return currentKilatopont;
	}
	
	public void restartTour() {
		if (kilatopontok.size() > 0) {
			currentKilatopont = kilatopontok.get(0);
			currentKilatopont.latogatokRogzitese();
		}
	}
	
	public String serialize() {
		return kilatopontok.stream()
				.map(Kilatopont::serialize)
				.collect(Collectors.joining(":"));
	}
	
	public void deserialize(String hegysegString) {
		
		String[] strings = hegysegString.split(":");
		kilatopontok = new ArrayList<>();
		
		for (int i = 0; i < strings.length; i++) {
			kilatopontok.add(Kilatopont.deserialize(strings[i]));
		}
		
	}
	
	public int getKilatoIndex(Kilatopont kilato) {
		return kilatopontok.indexOf(kilato);
	}
}
