<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function() {

        $("#successAlert").delay(8000).fadeOut(2000); //milliseconds
        $("#warningAlert").delay(10000).fadeOut(2000);
    });
</script>



<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="element_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
    <div class=" col-sm-8">

        <form:form cssClass="form-horizontal" modelAttribute="elementVO" action="/admin/element/add" method="post">
            <fieldset>
                <legend>Element Management</legend>
                <div class="form-group">
                    <label for="inputNewElementType" class="col-lg-2 control-label">Element Type</label>
                    <div class="col-lg-10">
                        <form:input path="newElementType" type="text" class="form-control"
                                    id="inputNewElementType" placeholder="Element Type"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewElements" class="col-lg-2 control-label">Elements</label>
                    <div class="col-lg-10">
                        <form:textarea path="newElements" cssClass="form-control" rows="3"
                                    id="inputNewElements" ></form:textarea>
                        <span class="help-block">Enter each new Element on a new line.</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                    </div>

                </div>



            </fieldset>

        </form:form>

    </div>

        <div class="col-sm-4">
            <%--Alerts--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Element Added!!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>

            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4 class="alert-heading">Warning!</h4>
                    <p class="mb-0">Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>

            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>

        </div>
    </div>
</div>


<%@include file="../../includes/footer.jsp" %>