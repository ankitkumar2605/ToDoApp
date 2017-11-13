    <tr>
        <td class="col-md-4 ">${todo?.title}</td>
        <td class="col-md-3">${todo?.description}</td>
        <td class="col-md-2">${todo?.dueDate}</td>
        <td class="col-md-3">
            <button type="button" onclick="editTask(this,${todo?.id})"  class="btn btn-primary edit" data-toggle="modal" data-target="#addTask">Edit</button>
            <button type="button" id ="removeTask" class="btn btn-danger" onclick="deleteTask(this,${todo?.id})">Delete</button>
            <button type="button" class="btn btn-success" onclick="markAsComplete(this,${todo?.id})">Mark As Complete</button>
        </td>
    </tr>

