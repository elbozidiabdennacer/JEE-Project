package Package_1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class_Java.Book;
import Class_Java.ConnexionBD;
import Class_Java.Panier;

@WebServlet("/AddAuPanier")
public class AddAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddAuPanier() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Book book = (Book) request.getSession().getAttribute("LignePanier");
		
		int id =Integer.parseInt(request.getParameter("id"));
		ResultSet resultats = ConnexionBD.getBok(id);
		Book book = null;
		try {
			resultats.next();
			book =new Book(resultats.getInt(1),resultats.getString(2),resultats.getString(3),resultats.getString(4),resultats.getDouble(5),resultats.getString(7),resultats.getInt(8));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		String op =(String) request.getParameter("op");
		System.out.println(op);
		if (request.getSession().getAttribute("panier") == null)
			request.getSession().setAttribute("panier", new Panier());
		Panier pan = (Panier) request.getSession().getAttribute("panier");

		
		if (op.equals("plus") ||op.equals("plus2")) {

			pan.addArticle(book);

			request.getSession().setAttribute("panier", pan);
 
			if(op.contentEquals("plus"))
			    request.getRequestDispatcher("/Panier.jsp").forward(request, response);
			else
				request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
				
		}
		
		

		else if (op.equals("sous")) {
			pan.sousArticle(book);
			request.getSession().setAttribute("panier", pan);
			request.getRequestDispatcher("/Panier.jsp").forward(request, response);

		}
		
		
		else if (op.equals("elim")) {
			pan.removeArticle(book);
			request.getSession().setAttribute("panier", pan);
			request.getRequestDispatcher("/Panier.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
