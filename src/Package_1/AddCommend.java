package Package_1;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class_Java.Commend;
import Class_Java.ConnexionBD;
import Class_Java.LignePanier;
import Class_Java.Panier;

@WebServlet("/AddCommend")
public class AddCommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCommend() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		int idc =(int)session.getAttribute("IdC");
		Panier panier =(Panier)session.getAttribute("panier");
		
		Commend c = new Commend();
		c.setIdC(idc);
		for(LignePanier lp : panier.getLignesPanier()) {
			c.setIdBk(lp.getBook().getIdBk());
			c.setQnt(lp.getQuantite());
			c.setDate(String.valueOf(new Date()));
			ConnexionBD.addCommend(c);
		}
		panier.vider();
		session.setAttribute("panier", null);
		
		request.getRequestDispatcher( "/Saved.jsp" ).forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
