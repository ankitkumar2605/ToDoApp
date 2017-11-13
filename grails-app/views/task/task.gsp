<%--
  Created by IntelliJ IDEA.
  User: ankit
  Date: 8/11/17
  Time: 4:43 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <asset:javascript src="tasks/task.js"/>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
    <title></title>

</head>

<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <p class="navbar-brand">TODO APP</p>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><button type="button " class="btn btn-danger navbar-btn" style="background: transparent ;border-color:black" onclick="loadTasks('DUE')">HOME</button></li>
            <li><button type="button "  class="btn btn-danger navbar-btn" style="background: transparent ;border-color:black" onclick="loadTasks('DONE')">COMPLETED</button></li>
            <li><a href="#">OVERDUE</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div id="todoList">

        <table class="table table-bordered table-hover" id="todoTable">
            <thead class="thead-inverse">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Due Date</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>


    </div>

</div>
<div class="container">

    <div class="fab" data-toggle="modal" data-target="#addTask">+</div>

    <!-- Modal -->
    <div class="modal fade" id="addTask" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" id="close" data-dismiss="modal">&times;</button>

                    <h2 class="modal-title">Add a task</h2>
                </div>

                <div class="modal-body">
                    <div class="container">
                        <form id="addTask-form" action="#">
                            <div class="form-group">
                                <label>Title:</label>
                                <input type="text" class="form-control" id="title" placeholder="Enter Title"
                                       name="title">
                            </div>

                            <div class="form-group">
                                <label>Description:</label>
                                <textarea rows="5" class="form-control" id="description" placeholder="Enter Description"
                                          name="description"></textarea>
                            </div>

                            <div class="form-group">
                                <label>Select Priority:</label>
                                <select class="form-control" id="priority">
                                    <option>Low</option>
                                    <option>Medium</option>
                                    <option>High</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Due Date:</label>
                                <input type="text" class="form-control" name="selected_date"
                                       placeholder="Select Due Date" id="datepicker"/>
                            </div>


                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" id="submit">Submit</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>