<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="element_sidebar.jsp" %>

        <div id="main-wrapper" class="col-sm-11 pull-right">
            <div class="col-lg-8 col-md-7 col-sm-6">

                <%--List of existing elements--%>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Element Type</th>
                        <th>Elements</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="elementType" items="${elementTypeList}">
                        <tr>
                            <td>${elementType.id}</td>
                            <td>${elementType.elementTypeName}</td>
                            <td>Elements will go here..</td>
                            <td><a href="/admin/element/edit/${elementType.id}">Edit</a></td>
                            <td><a href="/admin/element/delete/${elementType.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

            </div>
        </div>


</div>

<%@include file="../../includes/footer.jsp" %>