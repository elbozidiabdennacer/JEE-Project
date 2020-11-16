package Add_book_beblio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class_Java.Biblio;
import Class_Java.ConnexionBD;


@WebServlet("/Add_beblio")
public class Add_beblio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Add_beblio() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Biblio bi = new Biblio();
		bi.setIdb(Integer.parseInt(request.getParameter("idbb")));
		bi.setNomB(request.getParameter("nombb"));
		
		ConnexionBD.addBiblio(bi);
		request.getRequestDispatcher("/Add_bk_bb.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
