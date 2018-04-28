<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <title>Incremental game framework - game information</title>

    <link rel="stylesheet" href="../app.css">

</head>
<body class ="width-constraint">

    <header>

        <h1>Incremental game framework</h1>
	</header>
		<div class="row-container">

            <form class="fill card" method= "POST">
    
                <div class="form-group">
    
                    <label for="name">Event Name</label>
    
                    <input type="text" id="names" name ="name">
    
                </div>
    
    
                <div class="form-group">
    
                    <label for="description">Event Description</label>
    
                    <textarea id="description"name ="descTextArea" ></textarea>
    
                </div>
    
    
                <div class="form-group">
    
                    <label for="trigger_at">Trigger at</label>
    
                    <input type="number" id="trigger_at" name ="triggerInput">
    
                </div>
    
                <div class="actions">
    
                    <button>Save</button>
    
                </div>
    
            </form>
		
		</html>