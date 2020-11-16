<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="Class_Java.*" %>
<%@page import="java.io.*" %>
<%
    int id=Integer.parseInt(request.getParameter("idbiblio"));
	ResultSet resultats = ConnexionBD.getBookB(id);
	ResultSet resultats2 = ConnexionBD.getCategorie();
	boolean en = resultats.next();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=resultats.getString("NomB") %></title>
<link rel='stylesheet' type='text/css' href='FichierCss/Accueil.css'>
<style type="text/css">

a{
text-decoration:none;
}

</style>
<script src="scripts/javascript.js"></script>
</head>

<body>

   <%
    String Nom="",Prenom="";
   if(session.getAttribute("NomC")!=null){
	   Nom =(String) session.getAttribute("NomC");
	   Prenom = (String) session.getAttribute("PrenomC");   
   }   
   %>
   
    <div class="info">
	 <div class="slid">
	       <img src="Image/Slide/livre1.jpg" alt="" id="slide" class="slide">
		 </div>
		 
		 <ul class="list">
		   
		  <li class="list2"> Connexion
		    <ul>
		     <li><a href="Login.jsp">Login</a></li>
		     <li><a href="Signin.jsp">Signin</a></li>
		     <li><a href="Logout">Logout</a></li>
		    </ul>
		  </li>
		  
		<li class="list2"><a href="Panier.jsp">Panier</a></li>
		  
		  <li class="list2"> Contact moi
		     <ul>
		       <li>Email :abdennacer@gmail.com</li>
		       <li>Télé  :0621547589</li>
		     </ul>
		   </li>
		 
		 </ul>
	</div>
	
	<div class="tab-books">

		<table >

			<% 
			    int j=1;
				while (en) {
			    int i= 1;
			%>
			 <tr>
			  <%while(i<4 && en){%>
			  
				<th width="150px"    >
				 <a href="Serv_vente?idbook=<%=resultats.getInt(1) %>" > <img src="<%=resultats.getString(7)%>" onMouseOut="id='ns'" onMouseOver="id='img'" >
				 <br><br>
		          <%=resultats.getString(2) %></a>  
				</th> 
				 
				<%
				 en=resultats.next(); 
				 i++; j++;
			    }
				%>	
			</tr>
			<% } %>

		</table>
						
	</div>

	<div class='Your_Book'>
		<p class='p1'>yourbook</p>
		<div class='span'>
		<span class="welcome" id="welcome"><%=Nom %> <%=Prenom %></span>
		
		</div>

		<div class='bien'>

			<div class='menu' id="menu" onclick="myclick2()" >
				<div class='carre'></div>
				<div class='carre'></div>
				<div class='carre'></div>
			</div>

		</div>

	</div>
		
  <div class="panier" id="panier">
	   <ul>
	        <li> <a href="Accueil.jsp">Accueil</a></li>
	        <%
	        while(resultats2.next()){
	        %>
	        <li> <a href="Categorie.jsp?idbiblio=<%=resultats2.getInt(1)%>"><%=resultats2.getString(2) %></a></li>
	        <%}%>
	    </ul>
	</div>
</body>
</html>