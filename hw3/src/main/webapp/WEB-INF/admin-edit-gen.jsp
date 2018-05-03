<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>Incremental game framework - game information Edit</title>
		<link rel="stylesheet" href="../app.css">
		</head>
		<body class =\"width-constraint\">
		<header>
		<h1>Incremental game framework</h1>
		</header>
		<main>
		<div class="row-container">
		<form class="fill card" method= "POST">
		<div class="form-group">
		<label for="name">Generator Name</label>
		<input type="text" id="name" name = "name">
		</div>

		<div class="form-group">
		<label for="description">Generator Description</label>
		<textarea id="description" name = "description"></textarea>
		</div>

		<div class="form-group">
		<label for="rate">Generator rate</label>
		<input type="number" id="rate" name = "rate">
		</div>

		<div class="form-group">
		<label for="cost">Base cost</label>
		<input type="number" id="cost" name = "cost">
		</div>

		<div class="form-group">
		<label for="unlock_at">Unlock At</label>
		<input type="number" id="unlock_at" name = "unlock">
		</div>

		<div class="actions">
		<button>Save</button>
		</div>
		</form>

	
		</html>
		