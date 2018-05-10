<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

            <a href="generators">Generators</a>

            | 

            <a href="events">Events</a>

            | 
            <a id="log" href="auth">Log out</a>

        </nav>
     
    </header>


<main>

    <div class="row-container">

        <form class="fill card" method= "POST">

            <div class="form-group">

                <label for="name">Generators Name</label>

                <input type="text" id="name" name ="name">

            </div>


            <div class="form-group">

                <label for="description">Generators Description</label>

                <textarea id="description"name ="description" ></textarea>

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

        <div>

            <table class="info-table table-with-elipsis">

                <thead>

                    <tr>
                       
                        <th>Name</th>
                        <th>Description</th>
                        <th>Rate</th>
                        <th>Cost</th>
                        <th>Unlock</th>
                        <th>Action</th>

                    </tr>

                </thead>

                <tbody>
                        <c:forEach items="${generatorentry}" var="generator">
                                <tr>
                                    <td>${generator.getName()}</td>
                                    <td>${generator.getDescription()}</td>
                                    <td>${generator.getRate()}</td>
                                    <td>${generator.getBaseCost()}</td>
                                    <td>${generator.getUnlockAt()}</td>
                                    <td>
                                            <a href="EditgenServlet?id=${generator.getId()}">Edit</a>|
                                            <a href="DeletegenServlet?id=${generator.getId()}">Delete</a> 
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