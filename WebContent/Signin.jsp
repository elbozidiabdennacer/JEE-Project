<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signin</title>
<link rel='stylesheet' type='text/css' href='FichierCss/Singin.css'>
</head>
<body>

	
	<div class='container-box'>
		
		<form method='post' action='Serv_sign'>
			
		
			<div class='name'>
				 <label for='nom'>Nom :</label> 
				 <input class='input3' name='nom' id='nom' type='text' placeholder='Nom' pattern="[A-Za-z]" /><br>
			</div>
			
			<div class='name'>
				 <label for='Prenom'>Prenom :</label> 
				 <input class='input3' name='Prenom' id='Prenom' type='text' placeholder='Prenom' pattern="[A-Za-z]" /><br>
			</div>
			
			<div class='name'>
				 <label for='Email'>Email :</label> 
				 <input class='input3' name='Email' id='Email' type='Email' placeholder='Email' /><br>
			</div>
			
			<div class='name'> 
				 <label for='Adresse'>Adresse :</label> 
				 <input class='input3' name='Adresse' id='Adresse' type='text' placeholder='Adresse' /><br>
			</div>
			
			<div class='name'>
				 <label for='Tele'>Tele :</label> 
				 <input class='input3' name='Tele' id='Tele' type='tel' placeholder='Tele' pattern="[0-9]{10}"/><br>
			</div>
			
			<div class='name'>
				 <label for='pass'>Mot de passe :</label> 
				 <input class='input3' name='pass' id='pass' type='password' placeholder='Password' /><br>
			</div>
			
			
			<br><br>
			<div class='name'>
				 <input class='input2' name='submit' type='submit' value='Sign in' />
			</div>
			<a  href="Login.jsp" class="alog">vous avez déja un compte ?</a>
		</form>
		  
		
	</div>
	
	<div class='login'>
		<p class='p1'>Sign in</p>
	</div>
	
<br><br><br><br>
</body>
</html>