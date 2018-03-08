<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="/static/js/contact.js" var="contact" />

<script src="${contact}"></script>

<script>
    //this code executes when the page has loaded
    $(document).ready(function() {
        //functions from js go here
        buildContactTable();
        deletedModal();
    })
</script>

<div class="container">
    <h1>Contact Information</h1>

    <button onclick="insertContact()" class="btn btn-info">Add New Contact</button>

    <table id="contact-table" class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <%--jquery goes here --%>

        </tbody>
    </table>

    <div id="contactModal" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Contact Details</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>

                            <hidden id="employeeVersion" />

                            <div class="form-group">
                                <label for="inputEmployeeId" class="col-sm-2 col-form-label">Employee Id</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputEmployeeId" placeholder="Employee Id">
                                </div>
                            </div>

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
                                <label for="inputContactNumber" class="col-sm-2 col-form-label">Phone Number</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputContactNumber" placeholder="Phone Number">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputContactEmail" class="col-sm-2 col-form-label">Email Address</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputContactEmail" placeholder="Email Address">
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" onclick="saveContact()">Save Changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div id="confirmDeletedModal" class="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Confirm Delete</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h5>Are you sure you want to  delete? This can not be undone!</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger btn-ok" id="confirmDeleted">Delete</button>
                </div>
            </div>
        </div>
    </div>




</div>

<%@include file="includes/footer.jsp" %>