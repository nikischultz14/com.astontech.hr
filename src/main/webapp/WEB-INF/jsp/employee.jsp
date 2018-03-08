<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="/static/js/employee.js" var="employee" />

<script src="${employee}"></script>

<script>
    //this javascript code executes when the page has loaded
    $(document).ready(function() {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">
    <h1>Employee List</h1>

    <button onclick="insertEmployee()" class="btn btn-primary">Add New Employee</button>

<table id="employee-table" class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Background</th>
        <th>Projects</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>


    <%--jquery will append our data here...--%>

    </tbody>
</table>

    <div id="employeeModel" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Employee Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>

                            <hidden id="employeeId"/>
                            <hidden id="employeeVersion" />

                            <div class="form-group">
                                <label for="inputFirstName" class="col-sm-2 col-form-label">First Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputFirstName" placeholder="First Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputLastName" class="col-sm-2 col-form-label">Last Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputLastName" placeholder="Last Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 col-form-label" for="textAreaBackground">Background</label>
                                <div class="col-sm-10">
                                <textarea class="form-control" id="textAreaBackground" rows="3"></textarea>
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div id="confirmDeleteModal" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirm Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                   <p>Are you sure you want to delete? This can not be undone!</p>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-ok" id="confirmDelete">Delete</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>


</div>

<%@include file="includes/footer.jsp" %>