package hu.godenyd.servlet.kilatopont.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.godenyd.servlet.kilatopont.model.Hegyseg;
import hu.godenyd.servlet.kilatopont.util.WebKeys;

public class AdvanceKilatoAction {

	public static void processAction(HttpServletRequest request, HttpServletResponse response) {
		
		Hegyseg.getHegyseg().advanceToNextKilato();
		
		request.setAttribute(WebKeys.DO_SHOW_KILATO, true);
	}
}
