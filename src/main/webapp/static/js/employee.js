function buildTable() {
    $.getJSON('http://10.1.252.48:8080/api/employee/', {
        ajax: 'true'
    }, function (data) {
        //console.log(data)
        $.each(data, function(index, single) {
            var fullName = single.firstName + " " + single.lastName;
            $('#employee-table').find('tbody')
                .append("<tr>" +
                    "<td>" + single.id + "</td>" +
                    "<td>" + single.firstName + " " + single.lastName + "</td>" +
                    "<td>" + single.background + "</td>" +
                    "<td>" + "<select class='form-control'><option>(Select Project)</option></select>"+ "</td>" +
                    "<td>" + "<button onclick='editEmployee(" + single.id + ")'>Edit</button>" + "</td>" +
                    "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' " +
                    "data-record-id='" + single.id + "'>Delete</button>" + "</td>" +
                    "</tr>");
        });
    });
}


function insertEmployee() {
    //clear fields in modal
    $('#employeeId').val("");
    $('#employeeVersion').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#textAreaBackground').val("");

    //open modal
    $('#employeeModel').modal('show');
}


function saveEmployee() {
    //using jquery to retrieve values from input fields
    var id = $('#employeeId').val();
    var version = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var background = $('#textAreaBackground').val();


    //creating an object in javascript
    var employee = {

        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        background: background,
        project: []
    }

    console.log(employee);

    //asynchronous javascript call (ajax)
    $.ajax({
        type: "post",
        data: employee,
        url: "/api/employee/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}



function editEmployee(id) {

    //retrieve the employee with the passed in id
    $.getJSON('/api/employee/' + id, {
        ajax: 'true'
    }, function(employee) {
        console.log(employee);

        //populate values (hidden and input)
        $('#employeeId').val(employee.id);
        $('#employeeVersion').val(employee.version);
        $('#inputFirstName').val(employee.firstName);
        $('#inputLastName').val(employee.lastName);
        $('#textAreaBackground').val(employee.background);

        //open the modal
        $('#employeeModel').modal('show');
    })


}



function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/employee/" + id,
            async: true,
            dataType: "json",
            success: function() {
                window.location.reload();
            },
            error: function() {
                alert("Error Deleting Employee");
            }
        })

    });


    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });

}





