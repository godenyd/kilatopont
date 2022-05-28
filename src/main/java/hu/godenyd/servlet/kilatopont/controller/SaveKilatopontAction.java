package hu.godenyd.servlet.kilatopont.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.godenyd.servlet.kilatopont.model.Hegyseg;
import hu.godenyd.servlet.kilatopont.model.Kilatopont;
import hu.godenyd.servlet.kilatopont.model.Kornyezet;
import hu.godenyd.servlet.kilatopont.util.WebKeys;

public class SaveKilatopontAction {
	
	public static void processAction(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Save Kilato action");
		String nev = request.getParameter(WebKeys.NEV);
		int magassag = Integer.parseInt(request.getParameter(WebKeys.MAGASSAG));
		Kornyezet kornyezet = Kornyezet.getByName(request.getParameter(WebKeys.KORNYEZET));
		
		System.out.println("nev: " + nev);
		System.out.println("magassag: " + magassag);
		System.out.println("kornyezet: " + kornyezet);
		
		if (validate(nev, magassag, kornyezet)) {
			Hegyseg.getHegyseg().addKilato(new Kilatopont(nev, magassag, kornyezet));
		}
	}

	
	private static boolean validate(String nev, int magassag, Kornyezet kornyezet) {
		return nev != null && nev.length() > 0
				&& magassag > 0
				&& kornyezet != null;
	}
}
