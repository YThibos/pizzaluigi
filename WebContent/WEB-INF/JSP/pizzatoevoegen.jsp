<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri='http://vdab.be/tags' prefix='vdab'%>

<!DOCTYPE HTML>
<html lang='nl'>

<head>
<vdab:head title="Pizza toevoegen"/>
</head>

<body>
	<vdab:menu></vdab:menu>
	
	<section class="content">
	<h1>Pizza toevoegen</h1>
	<form method='post' id='toevoegform' enctype="multipart/form-data">
		<label>
			Naam<span>${fouten.naam}</span> <input name='naam' value='${param.naam}' autofocus required>
		</label> 
		<label>
			Prijs<span>${fouten.prijs}</span> <input name='prijs' value='${param.prijs}' type='number' min='0' required step='0.01'>
		</label>
		<div>
			<label> <input type='checkbox' name='pikant' value='pikant'>
				Pikant
			</label>
		</div>
		<label>Foto<span>${fouten.foto}</span>
		<input type='file' name='foto'>
		</label>
		<input type='submit' value='Toevoegen' id='toevoegknop'>
	</form>
	</section>
	
	<script>
		document.getElementById('toevoegform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		}
	</script>
</body>
</html>