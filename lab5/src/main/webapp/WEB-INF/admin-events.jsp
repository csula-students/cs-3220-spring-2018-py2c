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

        <nav class="main-nav">

            <a href="game-info.html">Game Information</a>

            | 

            <a href="generator-meta.html">Generators</a>

            | 

            <a class="active" href="event-meta.html">Events</a>

        </nav>

    </header>


<main>

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

        <div>

            <table class="info-table table-with-elipsis">

                <thead>

                    <tr>

                        <th>Name</th>

                        <th>Description</th>

                        <th>Trigger Point</th>

                        <th>Action</th>

                    </tr>

                </thead>

                <tbody>
                        <c:forEach items="${events}" var="event">
                                <tr>
                                    
                                    <td>${event.getName()}</td>
                                    <td>${event.getDescription()}</td>
                                    <td>${event.getTriggerAt()}</td>
                                    <td>
                                            <a href="../admin/EditEventServlet?id=${event.getId()}">Edit</a>|
                                            <a href="../admin/DeleteEventServlet?id=${event.getId()}">delete</a> 
                                    </td>
                                </tr>	
                                </c:forEach>
                </tbody>

            </table>

        </div>

    </div>



</main>


</body>

</html>
