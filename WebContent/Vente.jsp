<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="java.io.*" %>
<%@page import="Class_Java.*" %>
<%

	int ids =(int)request.getAttribute("idbo");
    ResultSet resultats = ConnexionBD.getBok(ids);
    resultats.next();
    
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
<link rel='stylesheet' type='text/css' href='FichierCss/vente.css'>
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
	
 <div class="jsp_vente">
 
	<div><img  class="img" src="<%=resultats.getString(7)%>"></div>
	
	<div class="tab">
		<h4>Information de livre</h4>
		<hr>
		<table>

			<tr>
				<th>Nom Livre</th><td><%=resultats.getString(2) %></td>
			</tr>	
			<tr>	
				<th>Auteur de livre</th><td><%=resultats.getString(3) %></td>
			</tr>
			<tr>	
				<th>Date d'edition</th><td><%=resultats.getString(4) %></td>
			</tr>
			<tr>	
				<th>Le prix</th><td><%=resultats.getString(5) %> Dhs</td>
			</tr>
			
		</table>
		<hr>
		<br>
		<br><br>
	</div>
	<br>
	<div class="divbtn">
			<form method='post' action="AddAuPanier?op=plus2&id=<%=ids %>" >
			
			 <input type="submit" name="btne" value="Ajeter au panier" class="btn" />
			  
			</form>
		</div>
   </div>	

<div class='Your_Book'>
		<p class='p1'>yourbook</p>
		<div class='span'>
		<span class="welcome" id="welcome"><%=Nom %> <%=Prenom %></span>
		
		</div>

		<div class='bien'>



			<div class='menu' id="menu" onclick="myclick2()">
				<div class='carre'></div>
				<div class='carre'></div>
				<div class='carre'></div>
			</div>

		</div>

	</div>
		
  <div class="panier" id="panier">
  <ul>
        <li> <a href="Accueil.jsp">Accueil</a></li>
		<li> <a href="Mathématique.jsp" >Mathématiques</a></li>
		<li> <a href="Physiques.jsp">Physiques</a> </li>
		<li> <a href="Médecine.jsp">Médecine</a></li>
		<li> <a href="Technologie.jsp">Technologie</a></li>
		<li> <a href="Biologie.jsp">Biologie</a></li>
    </ul>
	</div>
</body>
</html>