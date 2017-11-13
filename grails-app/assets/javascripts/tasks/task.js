//= require jquery-2.2.0.min



$(document).ready(function () {
    var dateToday = new Date();
    $("#datepicker").datepicker({
        showButtonPanel: true,
        minDate: dateToday,
        dateFormat: 'dd-mm-yy'
    });

    $('#submit').one('click', addTask);

    $(document).on("click", ".edit",function () {

        $(".modal-body #title").val();
    });

})

function editTask(editBtn,todo) {
    $(".modal-body #title").val(todo);

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
            if(result.success){
            $('#submit').one('click', addTask);
            $('#close').click();
            $(".modal-body input,textarea").val("")
            window.location ="loadTasks"
            }else if (!result.success && result.isParamsIncorrect) {
                alert("Please send correct params")
            }else{
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

function loadTasks() {
    ajax({
        url: "http://localhost:8090/task/loadTasks",
        type: "POST",
        data: {status: status},
        success: function (result) {
             //window.location ="loadTasks"
        },
        error:function (result) {

        }
    })


}




