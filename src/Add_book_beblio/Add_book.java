package Add_book_beblio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class_Java.Book;
import Class_Java.ConnexionBD;


@WebServlet("/Add_book")
public class Add_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Add_book() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    Book b = new Book();
		
	  b.setNomBk(request.getParameter("nombk"));
	  b.setAuteurBk(request.getParameter("Auteur"));
	  b.setDate_edition(request.getParameter("date_edition"));
	  b.setPrixBx(Double.parseDouble(request.getParameter("prix")));
	  b.setIdB(Integer.parseInt(request.getParameter("beblio")));
	  b.setPath(request.getParameter("path"));
	  
	  ConnexionBD.addBook(b);
	  
	  request.getRequestDispatcher("/Add_bk_bb.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
