<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title> Dungeon Extraordinare</title>
	<link rel="stylesheet" href="../game.css">

</head>
<body class = "width-constraint">
	<header>
		<h1>The Abyss Point</h1>
	</header>
<main>
<div class ="story-time"> 
		<c:forEach items="${events}" var="event">
			<p>${event.name}</p>
			</c:forEach>
</div>	



</textarea>
<br>
<div class= "row-container_2">
			<label = "ruppe">Ruppes:<span id = "counts"> 0</span></label>
			<div class="actions">
					<button id = "click-me">Click Me</button>
			</div>
			
	
</div>

<div class="row-container">
<form class="card" action="">
	<div class ="form group">
		<div class = "rows">
		<c:forEach items="${generators}" var="generator">
		<p>${generator.name}<span> 0</span></p>
		<p>${generator.description}</p>
		<p>%{generator.rate}</p> 
		<button>$generator.baseCost}</button>
		</c:forEach>
	</div>
	<br>
	

</div>

</main>
<script>
window.incrementalGame = {
	        state: {
	            counter: 0
	        }
		};
    	window.incrementalGame.state = ${states};
</script>
<script  src = "app.js"></script>
</body>
<footer>
	<p>
		Posted by :Jarly Arciniega
	</p>
</footer>
</html>