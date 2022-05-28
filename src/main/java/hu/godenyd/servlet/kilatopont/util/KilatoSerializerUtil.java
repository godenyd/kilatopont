package hu.godenyd.servlet.kilatopont.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import hu.godenyd.servlet.kilatopont.model.Hegyseg;

public class KilatoSerializerUtil {
	
	private static final String CATALINA_BASE = System.getProperty("catalina.base");
	
	private static final String STORAGE_FILE_NAME = "mountain_storage.dat";
	
	public static void writeHegysegToFile(Hegyseg hegyseg) {
		
		resetDataFile();
		
		Path path = Paths.get(getPath());

		byte[] hegysegData = hegyseg.serialize().getBytes();
		
	    try (OutputStream out = new BufferedOutputStream(
	      Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
	      out.write(hegysegData, 0, hegysegData.length);
	    } catch (IOException x) {
	      System.err.println(x);
	    }
	}
	
	public static Optional<String> readHegysegFromFile() throws IOException {
		
		if (!Files.exists(Paths.get(getPath()), LinkOption.NOFOLLOW_LINKS)) {
			return Optional.empty();
		}
		
		byte[] bytes = Files.readAllBytes(Paths.get(getPath()));
		
		return Optional.of(new String(bytes, StandardCharsets.UTF_8));
		
	}
	
	private static File resetDataFile() {
		File dataFile = new File(getPath());
		
		dataFile.delete();
		try {
			dataFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dataFile;
	}
	
	private static String getPath() {
		return CATALINA_BASE + "/" + STORAGE_FILE_NAME;
	}
}
