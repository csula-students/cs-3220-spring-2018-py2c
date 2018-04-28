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

            <a href="generators">Generators</a>"

            | 

            <a href="generatorss">generatorss</a>"

        </nav>

    </header>


<main>

    <div class="row-container">

        <form class="fill card" method= "POST">

            <div class="form-group">

                <label for="name">generators Name</label>

                <input type="text" id="names" name ="name">

            </div>


            <div class="form-group">

                <label for="description">generators Description</label>

                <textarea id="description"name ="descTextArea" ></textarea>

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
                        <c:forEach items="${generators}" var="generator">
                                <tr>
                                    
                                    <td>${generators.getName()}</td>
                                    <td>${generators.getDescription()}</td>
                                    <td>${generators.getRate()}</td>
                                    <td>${generators.getCost()}</td>
                                    <td>${generators.getUnlockAt()}</td>
                                    <td>
                                            <a href="EditgenServlet?id=${generators.getId()}">Edit</a>|
                                            <a href="DeletegenServlet?id=${generators.getId()}">delete</a> 
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