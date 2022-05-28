package hu.godenyd.servlet.kilatopont.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LatogatoUtil {

	private static final String CATALINA_BASE = System.getProperty("catalina.base");

	private static final String STORAGE_FILE_NAME = "latogato.txt";

	public static int readFromFile() {
		
		byte[] bytes = null;
		
		try {
			bytes = Files.readAllBytes(getPath());
		} catch (Exception e) {
			return -1;
		}
		
		return Integer.parseInt(new String(bytes));
	}

	public static void writeToFile(int number) throws IOException {

		Files.write(getPath(), String.valueOf(number).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE,
				StandardOpenOption.TRUNCATE_EXISTING);
	}

	private static Path getPath() {
		return Paths.get(CATALINA_BASE + "/" + STORAGE_FILE_NAME);
	}
}
