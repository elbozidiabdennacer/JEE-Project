<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="javax.swing.ImageIcon" %>
<%@page import="Class_Java.*"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%
if(request.getSession().getAttribute("panier")==null){
	request.getSession().setAttribute("panier",new Panier());
}

Panier pan= (Panier)request.getSession().getAttribute("panier");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier</title>
<link rel='stylesheet' type='text/css' href='FichierCss/panie.css'>
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

    <div class="ligneP">
    
   <%
   Double prixT=0.0;
   for(LignePanier lp : pan.getLignesPanier()){
	  // System.out.println(lp.getBook().getPath());
    %>
    <ul class="trP">
       <li><img class="imgP" src="<%=lp.getBook().getPath()%>" alt="None"></li>
       <li class="nomP"><%=lp.getBook().getNomBk() %></li><li></li>
       <li class="prix"><%=lp.getBook().getPrixBx() %> Dhs</li>
       <li class="moin">unité: <%=lp.getQuantite() %></li>
       <li class="moin"><a href="AddAuPanier?op=plus&id=<%=lp.getBook().getIdBk()%>">+</a> | <a href="AddAuPanier?op=sous&id=<%=lp.getBook().getIdBk()%>">-</a> | <a href="AddAuPanier?op=elim&id=<%=lp.getBook().getIdBk()%>">x</a></li>
    </ul>
    <hr>
    <%
    
    prixT +=lp.getQuantite()*lp.getBook().getPrixBx();
    }
    
    %> 
    <ul class="trP2">
    <li class="nomP">Prix Total</li><li></li><li></li>
    <li class="prix"><b><%=prixT %> Dhs</b></li><li></li>
    </ul>
    
    <div class="divbtn">
			<form method='post' action="AddCommend" >
			
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
		<li> <a href="Mathématique.jsp" >Mathématiques</a></li>
		<li> <a href="Physiques.jsp">Physiques</a> </li>
		<li> <a href="Médecine.jsp">Médecine</a></li>
		<li> <a href="Technologie.jsp">Technologie</a></li>
		<li> <a href="Biologie.jsp">Biologie</a></li>
    </ul>
	</div>




</body>
</html>