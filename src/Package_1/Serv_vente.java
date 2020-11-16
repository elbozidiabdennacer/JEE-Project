package Package_1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Serv_vente
 */
@WebServlet("/Serv_vente")
public class Serv_vente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Serv_vente() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String ids=request.getParameter("idbook");
		int idf=Integer.parseInt(ids);
		request.setAttribute("idbo", idf);
		
		if(session.getAttribute("NomC")==null) {
			
			request.getRequestDispatcher( "/Login.jsp" ).forward(request, response);
		}
		else {
			request.getRequestDispatcher( "/Vente.jsp" ).forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
