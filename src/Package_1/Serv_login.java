package Package_1;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class_Java.ConnexionBD;

@WebServlet("/Serv_login")
public class Serv_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Serv_login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("Email_l");
		String pass = request.getParameter("passl");

		ResultSet resultat = ConnexionBD.logIn(email, pass);
		HttpSession session = request.getSession(true);

		try {

			if (resultat.next()) {

				session.setAttribute("IdC", resultat.getInt("IdC"));
				session.setAttribute("NomC", resultat.getString("NomC"));
				session.setAttribute("PrenomC", resultat.getString("PrenomC"));
				session.setAttribute("EmailC", resultat.getString("EmailC"));
				session.setAttribute("AddresseC", resultat.getString("AddresseC"));
				session.setAttribute("TeleC", resultat.getString("TeleC"));
				session.setAttribute("Password", resultat.getString("Password"));
				
				
				if(resultat.getInt("IdC")== 1 && resultat.getString("EmailC").equals("elbozidi.abdennacer@gmail.com"))
				  request.getRequestDispatcher("Admin/AccueilAdmin.jsp").forward(request, response);
				else{
					request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
				}
			}

			else {

				request.setAttribute("Erreur", "Veuiller ressaier");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
