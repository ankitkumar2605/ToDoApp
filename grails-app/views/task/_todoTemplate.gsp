<table class="table table-bordered table-hover">
    <thead class="thead-inverse">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Due Date</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="col-md-4 j">${todo?.title}</td>
        <td class="col-md-3">${todo?.description}</td>
        <td class="col-md-2">${todo?.dueDate}</td>
        <td class="col-md-3">
            <button type="button" onclick="editTask(this,${todo?.id})"  class="btn btn-primary edit" data-toggle="modal" data-target="#addTask">Edit</button>
            <button type="button" id ="removeTask" class="btn btn-danger" onclick="deleteTask(this,${todo?.id})">Delete</button>
            <button type="button" class="btn btn-success" onclick="markAsComplete(this,${todo?.id})">Mark As Complete</button>
        </td>
    </tr>

    </tbody>
</table>
