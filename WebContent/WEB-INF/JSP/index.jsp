<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE HTML>
<html lang='nl'>

<head>
<title>Pizza Luigi</title>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<link rel='stylesheet' href='styles/default.css' />
<meta name='viewport' content='width=device-width, initial-scale=1' />
</head>

<body>
	<h1>Pizza Luigi</h1>
	<img src='images/pizza.jpg' alt='pizza' class='fullwidth'>
	<h2>${begroeting}</h2>

	<h2>De zaakvoerder</h2>
	<dl>
		<dt>Naam</dt>
		<dd>${zaakvoerder.naam}</dd>
		<dt>Aantal kinderen</dt>
		<dd>${zaakvoerder.aantalKinderen}</dd>
		<dt>Gehuwd</dt>
		<dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee' }</dd>
		<dt>Adres</dt>
		<dd>${zaakvoerder.adres}</dd>
	</dl>
</body>
</html>