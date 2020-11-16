package Class_Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConnexionBD {

	public static Connection Connecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Ok");
		    String url = "jdbc:mysql://localhost:3307/vendre_books";
			String user = "root";
			String password = "";

			Connection cnx = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection bien établie");
			return cnx;
		} catch (Exception e) {
			System.out.println("op");
			e.printStackTrace();

			return null;
		}
	}

	// ajouter un client
	public static void ajouter(Client c) {

		try {
			Connection cnx = ConnexionBD.Connecter();
			String query = "INSERT INTO client (NomC, PrenomC, EmailC, AddresseC, TeleC, Password) VALUES (?,?,?,?,?,?)";
			PreparedStatement prepare = (PreparedStatement) cnx.prepareStatement(query);

			prepare.setString(1, c.getNomC());
			prepare.setString(2, c.getPrenomC());
			prepare.setString(3, c.getEmail());
			prepare.setString(4, c.getAddresseC());
			prepare.setString(5, c.getTeleC());
			prepare.setString(6, c.getPassword());

			prepare.execute();
			cnx.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean estAdmin(String email, String pass) {

		try {
			String query = "SELECT EmailC,Password FROM client where IdC=1";
			Connection cnx = ConnexionBD.Connecter();
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery(query);
			resultat.next();
			System.out.println("admin ok");
			return (resultat.getString("EmailC").equals(email) && resultat.getString("Password").equals(pass));

		} catch (SQLException e) {
			
			return false;
		}

	}

	public static ResultSet getClients(String email, String pass) {

		if (ConnexionBD.estAdmin(email, pass)) {
			try {
				String query = "SELECT * FROM client";
				Connection cnx = ConnexionBD.Connecter();
				Statement st = cnx.createStatement();
				ResultSet resultat = st.executeQuery(query);
				return resultat;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static ResultSet logIn(String email, String pass) {

		try {

			String query = "SELECT * FROM client WHERE EmailC= '" + email + "' AND Password = '" + pass + "'";
			Connection cnx = ConnexionBD.Connecter();
			Statement st = cnx.createStatement();
			ResultSet res = st.executeQuery(query);

			return res;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void addCommend(Commend c) {

		try {
			Connection cnx = ConnexionBD.Connecter();
			String query = "INSERT INTO commande(IdC, IdBk,quantite, Date) VALUES (?,?,?,?)";
			PreparedStatement prepare = (PreparedStatement) cnx.prepareStatement(query);

			prepare.setInt(1, c.getIdC());
			prepare.setInt(2, c.getIdBk());
			prepare.setInt(3, c.getQnt());
			prepare.setString(4, c.getDate());
			prepare.execute();
			cnx.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ResultSet getCommandes(String email, String pass) {

		if (ConnexionBD.estAdmin(email, pass)) {
			try {
				String query = "SELECT cl.NomC, cl.PrenomC, cl.EmailC, cl.AddresseC, cl.TeleC, b.NomBk, b.IdBk, cm.quantite, cm.Date  FROM client cl, commande cm, books b "
						+ "WHERE cm.IdC=cl.IdC and cm.IdBk=b.IdBk";
				Connection cnx = ConnexionBD.Connecter();
				Statement st = cnx.createStatement();
				
				ResultSet resultat = st.executeQuery(query);
				System.out.println("Commande ok");
				
				return resultat;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;

	}

	public static void addBook(Book b) throws FileNotFoundException {

		try {
			String query = "INSERT INTO books(IdBk, NomBk, AuteurBk, Date_edition, PrixBk, ImageBk,pthimage, IdB) VALUES (?,?,?,?,?,?,?,?)";

			Connection cnx = ConnexionBD.Connecter();
			PreparedStatement prepare = (PreparedStatement) cnx.prepareStatement(query);

			prepare.setInt(1, b.getIdBk());
			prepare.setString(2, b.getNomBk());
			prepare.setString(3, b.getAuteurBk());
			prepare.setString(4, b.getDate_edition());
			prepare.setDouble(5, b.getPrixBx());

			if (!b.getPath().equals("")) {
				InputStream imgg = new FileInputStream(new File(b.getPath()));
				prepare.setBlob(6, imgg);
			}
			prepare.setString(7, b.getPath());
			prepare.setInt(8, b.getIdB());

			prepare.execute();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addBiblio(Biblio bb) {

		try {

			String query = "INSERT INTO biblio(IdB, NomB) VALUES (?,?)";
			Connection cnx = ConnexionBD.Connecter();
			PreparedStatement prepare = (PreparedStatement) cnx.prepareStatement(query);

			prepare.setInt(1, bb.getIdb());
			prepare.setString(2, bb.getNomB());
			prepare.execute();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getBook() {

		try {
			String query = "SELECT * FROM books ";
			Connection cnx = ConnexionBD.Connecter();
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery(query);
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getBok(int id) {

		try {
			String query = "SELECT * FROM books WHERE IdBk=" + id + ";";
			Connection cnx = ConnexionBD.Connecter();
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery(query);

			return resultat;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ResultSet getBookB(int cat) {

		try {
			String query = "select * from books b, biblio o where b.IdB=o.Idb and o.IdB=" + cat + ";";
			Connection cnx = ConnexionBD.Connecter();
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery(query);

			return resultat;

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

	}

	public static ResultSet getCategorie() {

		try {
			String query = "SELECT * FROM biblio";
			Connection cnx = ConnexionBD.Connecter();
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery(query);
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
