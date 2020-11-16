<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="erreur.jsp" import="java.sql.*"%>
<%@page import="Class_Java.*" %>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<% 
        if(request.getSession().getAttribute("IdC") == null)
        {
            response.sendRedirect("Login.jsp");
        }
%>
<%
	String email=(String)request.getSession().getAttribute("EmailC");
	String pass=(String)request.getSession().getAttribute("Password");
	
    ResultSet resultats = ConnexionBD.getClients(email,pass); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel='stylesheet' type='text/css' href='Accueil.css'>
<style type="text/css">

a{
text-decoration:none;
}
</style>

<script src="javascript.js"></script>
</head>
<body>


   <%
    String Nom="",Prenom="";
   if(session.getAttribute("NomC")!=null){
	   Nom =(String) session.getAttribute("NomC");
	   Prenom = (String) session.getAttribute("PrenomC");
	   
   }
	   
   %>

	<div class="tab-books">
	<table>
	   <%
	   while(resultats.next()){
	   %>
	   <tr>
	   <td><%=resultats.getInt("IdC") %>||<%=resultats.getString("NomC") %> <%=resultats.getString("PrenomC") %></td>
	   <td><%=resultats.getString("AddresseC") %></td>
	   <td><%=resultats.getString("EmailC") %></td>
	   </tr>

       <%} %>
       
     </table>
       
       <ul>
       <li><a href="Add_bk_bb.jsp">Ajouter des livres ou categorie</a></li>
       <li><a href="view.jsp?op=getCmd">Voir les commandes</a></li>
       <li><a href="view.jsp?op=getCl">Voir les clients</a></li>
       </ul>

	</div>

	<div class='Your_Book'>
		<p class='p1'>yourbook</p>
		<div class='span'>
		<span class="welcome" id="welcome"><%=Nom %> <%=Prenom %></span>
		
		</div>

	</div>
		
</body>
</html>