package Package_1;

import java.awt.Image;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import Class_Java.ConnexionBD;


@WebServlet("/Serv_Accueil")
public class Serv_Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int compt =0;  
   
    public Serv_Accueil() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet res =  ConnexionBD.getBook();
		
		
		try {
			
		  int i=0;
			while(i<0) {
				 res.next();
				byte[] img = res.getBytes("ImageBk");
				ImageIcon image = new ImageIcon(img);
				Image myImg = image.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
				
				
                 compt++;
				 request.setAttribute("image "+compt, myImg);
				 request.setAttribute("nom "+compt, res.getString("NomBk"));
               
				    
                 }
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
                request.setAttribute("compteur", compt);
                
             request.getRequestDispatcher("/Accueil.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
