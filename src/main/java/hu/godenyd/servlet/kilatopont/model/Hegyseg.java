package hu.godenyd.servlet.kilatopont.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hu.godenyd.servlet.kilatopont.util.KilatoSerializerUtil;

public class Hegyseg {

	private List<Kilatopont> kilatopontok;
	private Kilatopont currentKilatopont = null;
	
	private static Hegyseg instance = null;
	
	// initialize hegyseg
	private Hegyseg() {
		
		Optional<String> hegysegString = Optional.empty();
		
		try {
			hegysegString = KilatoSerializerUtil.readHegysegFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			kilatopontok = new ArrayList<>();
			hegysegString.ifPresent(hegyseg -> getHegyseg().deserialize(hegyseg));
		}
		
	}
	
	public static Hegyseg getHegyseg() {
		
		if (instance == null) {
			instance = new Hegyseg();
		}
		
		return instance;
	}
	
	public void addKilato(Kilatopont kilato) {
		kilatopontok.add(kilato);
		KilatoSerializerUtil.writeHegysegToFile(this);
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
	
	public String serialize() {
		return kilatopontok.stream()
				.map(Kilatopont::serialize)
				.collect(Collectors.joining(":"));
	}
	
	public void deserialize(String hegysegString) {
		kilatopontok = Stream.of(hegysegString.split(":"))
				.map(Kilatopont::deserialize)
				.collect(Collectors.toList());
	}
}
