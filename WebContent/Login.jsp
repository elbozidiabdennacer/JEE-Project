<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel='stylesheet' type='text/css' href='FichierCss/Login.css'>
</head>
<body>

<div class='container-box'>
		
		<%
		String Erreur="";
		if(request.getAttribute("Erreur")!=null)
			Erreur=(String)request.getAttribute("Erreur");
		%>

		<form method='post' action='Serv_login'>
			
			
			<p class="cnx">Connexion</p><br><br>

			<div class='name'>
				 <label for='Email_l'>Email :</label>
				 
				 <input class='input3' name='Email_l' id='Email_l' type='Email' placeholder='Email' /><br>
			</div>
			 
			 <br>

			<div class='name'>
				 <label for='passl'>Password :</label>
				 <input class='input3' name='passl' id='passl' type='password' placeholder='Password' />
			</div>
			<br><br>
			<div class='name'>
				 <input class='input2' name='submit' type='submit' value='Log in' />
			</div>
			<div>
			<a href="Signin.jsp" class="alog">Créer un compte</a>
			</div>
		</form>
		
	</div>
	
	<div class='login'>
			<p class='p1'>Log in</p>
	</div>
	

</body></html>