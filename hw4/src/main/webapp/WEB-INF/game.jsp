<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title> Dungeon Extraordinare</title>
	<link rel="stylesheet" href="../game.css">
	
	<script>
		state = ${state};
		window.defaultState = state;  // where state is passed from Controller as JSON string
	</script>
</head>
<body class = "width-constraint">
	<header>
		<h1>The Abyss Point</h1>
	</header>
<main>
<div class ="story-time"> 	
	<game-story-book></game-story-book>		
</div>	
<br>
<div class= "row-container_2">	
	<game-counter></game-counter>
	<game-button></game-button>	
</div>
<div class = "row-container">
	<c:forEach var = "i" begin = "0" end = "${generatorindex}">
         	<game-generator data-id="${i}"></game-generator>
      	</c:forEach>
</div>

</main>
<script src="https://cdnjs.cloudflare.com/ajax/libs/webcomponentsjs/1.1.0/webcomponents-lite.js"></script>
<script src ="../app.bundle.js"></script>




</body>
<footer>
	<p>
		Posted by :Jarly Arciniega
	</p>
</footer>
</html>