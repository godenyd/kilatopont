package hu.godenyd.servlet.kilatopont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.godenyd.servlet.kilatopont.controller.AdvanceKilatoAction;
import hu.godenyd.servlet.kilatopont.controller.SaveKilatopontAction;
import hu.godenyd.servlet.kilatopont.model.Hegyseg;
import hu.godenyd.servlet.kilatopont.util.ActionKeys;
import hu.godenyd.servlet.kilatopont.util.WebKeys;

/**
 * Servlet implementation class KilatoServlet
 */
@WebServlet("/KilatoServlet")
public class KilatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public KilatoServlet() {

    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	Hegyseg.getHegyseg();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/html/kilato.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter(WebKeys.ACTION);
		
		switch(action) {
		case ActionKeys.ADVANCE_KILATO:
			AdvanceKilatoAction.processAction(request, response);
			break;
		case ActionKeys.SAVE_KILATO:
			SaveKilatopontAction.processAction(request, response);
			break;
		}
		
		doGet(request, response);
	}

}
