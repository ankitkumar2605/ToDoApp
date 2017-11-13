//= require jquery-2.2.0.min


$(document).ready(function () {
    var dateToday = new Date();
    $("#datepicker").datepicker({
        showButtonPanel: true,
        minDate: dateToday,
        dateFormat: 'dd-mm-yy'
    });

    $('#submit').one('click', addTask);

    $(document).on("click", ".edit", function () {

        $(".modal-body #title").val();
    });
    loadTasks("DUE")
})

function editTask(editBtn, id,title,description,priority,dueDate) {
    $(".modal-body #title").val(id);

}

function deleteTask(deleteBtn, id) {
    $.ajax({
        url: "http://localhost:8090/task/removeTask",
        type: "POST",
        async: false,
        data: {id: id},
        success: function (result) {
            if (result.success)
                $(deleteBtn).closest('tr').remove();
            else
                alert("Some error occurred!!Please try again")

        },
        error: function (result) {
            alert("Some error occurred!!Please try again")
        }
    });
}

function markAsComplete(markCompletebtn, id) {
    $.ajax({
        url: "http://localhost:8090/task/updateTaskStatus",
        type: "POST",
        async: false,
        data: {id: id},
        success: function (result) {
            if (result.success)
                $(markCompletebtn).closest('tr').remove();
            else
                alert("Some error occurred!!Please try again")

        },
        error: function (result) {
            alert("Some error occurred!!Please try again")
        }
    });
}

var addTask = function (e) {
    var title = $('#title').val()
    var description = $('#description').val()
    var dueDate = $('#datepicker').val()
    var priority = $('#priority').val().toUpperCase()
    var status = "DUE"
    $.ajax({
        url: "http://localhost:8090/task/addTask",
        type: "POST",
        data: {title: title, description: description, dueDate: dueDate, priority: priority, status: status},
        success: function (result) {
            if (result.success) {
                $('#submit').one('click', addTask);
                $('#close').click();
                $(".modal-body input,textarea").val("")
                loadTasks("DUE")
            } else if (!result.success && result.isParamsIncorrect) {
                alert("Please send correct params")
            } else {
                alert("Please try again")
            }


        },
        error: function (result) {
            alert("Some error occurred!!Please try again")
        }
    });
    e.stopImmediatePropagation();
    return false;
}

function loadTasks(status) {
    $.ajax({
        url: "http://localhost:8090/task/loadTasks",
        type: "POST",
        data: {status: status},
        success: function (response) {
            $('#todoTable tbody').empty()
            $.each(response.todoList, function (i, item) {
                $('<tr>').html(
                    "<td>" + item.title + "</td><td>" + item.description + "</td><td>" + item.dueDate + "</td>" +
                    "<td>" + '<button type="button" onclick="editTask(this,'+item.id+')"  class="btn btn-primary edit" data-toggle="modal" data-target="#addTask">Edit</button>' +
                    ' <button type="button" id ="removeTask" class="btn btn-danger" onclick="deleteTask(this ,' + item.id + ')">Delete</button>' +
                    ' <button type="button" class="btn btn-success" onclick="markAsComplete(this,'+item.id+')">Mark As Complete</button>' +

                    " </td>").appendTo('#todoTable');
            });
        },
        error: function (result) {

        }
    })


}




