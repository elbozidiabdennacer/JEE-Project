package Package_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class_Java.Client;
import Class_Java.ConnexionBD;

/**
 * Servlet implementation class Serv_sign
 */
@WebServlet("/Serv_sign")
public class Serv_sign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Serv_sign() {
		super();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("Prenom");
		String Email = (String) request.getParameter("Email");
		String Adresse = (String) request.getParameter("Adresse");
		String Tele = (String) request.getParameter("Tele");
		String pass = (String) request.getParameter("pass");

		if (nom.equals("") || prenom.equals("") || Email.equals("") || Adresse.equals("") || Tele.equals("")
				|| pass.equals("")) {
			request.getRequestDispatcher("/Signin.jsp").forward(request, response);
		} else {
			out.println(nom);

			Client cl = new Client();
			cl.setNomC(nom);
			cl.setPrenomC(prenom);
			cl.setEmail(Email);
			cl.setAddresseC(Adresse);
			cl.setTeleC(Tele);
			cl.setPassword(pass);
            
			ConnexionBD.ajouter(cl);
			
			ResultSet resultat = ConnexionBD.logIn(Email, pass);
			HttpSession session = request.getSession(true);
   
			try {
				if (resultat.next()) {

					session.setAttribute("IdC", resultat.getInt("IdC"));
					session.setAttribute("NomC", resultat.getString("NomC"));
					session.setAttribute("PrenomC", resultat.getString("PrenomC"));
					session.setAttribute("EmailC", resultat.getString("EmailC"));
					session.setAttribute("AddresseC", resultat.getString("AddresseC"));
					session.setAttribute("TeleC", resultat.getString("TeleC"));

					System.out.println(session.getAttribute("NomC"));

					request.getRequestDispatcher("/Accueil.jsp").forward(request, response);

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

}
