function buildContactTable() {
    $.getJSON('http://10.1.252.48:8080/api/contact/', {
        ajax: 'true'
    }, function (data) {
        $.each(data, function(index, single) {
            var fullName = single.firstName + " " + single.lastName;
            $('#contact-table').find('tbody')
                .append("<tr>" +
                "<td>" + single.id + "</td>" +
                "<td>" + single.firstName + " " + single.lastName + "</td>" +
                "<td>" + single.phoneNumber + "</td>" +
                "<td>" + single.emailAddress + "</td>" +
                "<td>" + "<select class='form-control'><option>(Select Address)</option></select>"+ "</td>" +
                "<td>" + "<button onclick='editContact(" + single.id + ")'>Edit</button>" + "</td>" +
                "<td>" + "<button data-toggle='modal' data-target='#confirmDeletedModal' " +
                "data-record-id='" + single.id + "'>Delete</button>" + "</td>" +
                "</tr>");
        });
    });
}


function insertContact() {
    //clear fields in modal
    $('#employeeVersion').val("");
    $('#inputEmployeeId').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#inputContactNumber').val("");
    $('#inputContactEmail').val("");

    //open modal
    $('#contactModal').modal('show');
}

function saveContact() {
    var id = $('#employeeId').val();
    var version = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var phoneNumber = $('#inputContactNumber').val();
    var emailAddress = $('#inputContactEmail').val();

    var contact = {
        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        phoneNumber: phoneNumber,
        emailAddress: emailAddress,
        address: []

    }

    console.log(contact);

    $.ajax({
        type: "post",
        data: contact,
        url: "/api/contact/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })


}

function editContact(id) {
    $.getJSON('/api/contact/' + id, {
        ajax: 'true'
    }, function(contact) {
        console.log(contact);

        $('#employeeVersion').val(contact.version);
        $('#inputEmployeeId').val(contact.id);
        $('#inputFirstName').val(contact.firstName);
        $('#inputLastName').val(contact.lastName);
        $('#inputContactNumber').val(contact.phoneNumber);
        $('#inputContactEmail').val(contact.emailAddress);

        $('#contactModal').modal('show');

        })
}

function deletedModal() {
    $('#confirmDeletedModal').on('click', '.btn-ok', function(e) {
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/contact/" + id,
            async: true,
            dataType: "json",
            success: function() {
                window.location.reload();
            },
            error: function() {
                alert("Error Deleting Contact");
            }
        })
    });

    $('#confirmDeletedModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });



}