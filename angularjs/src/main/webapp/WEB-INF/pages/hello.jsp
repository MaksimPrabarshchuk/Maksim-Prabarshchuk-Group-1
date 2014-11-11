<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="text/html; charset=utf-8">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-spinedit.css" rel="stylesheet">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <form:form class="form-reg" method="post" action="/reg-new" modelAttribute="formModel">
            <h4 class="form-reg-heading">Registration form</h4>
            <form:input type="text" class="input-block-level" placeholder="Full name" style="height: 30px;" path="name"/>
            <input type="text" class="input-block-level" placeholder="Email address" style="height: 30px;">
            <input type="text" class="input-block-level" placeholder="Phone number xxx-xxx-xx-xx" style="height: 30px;">
            <input type="text" class="input-block-level" placeholder="Website" style="height: 30px;">
            <div id="datetimepicker4" class="input-append" style="margin-bottom: 0px;">
                <input data-format="yyyy-MM-dd" type="text" placeholder="Date of Birth" style="height: 30px;">
                <span class="add-on">
                    <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                </span>
            </div>

            <h4 class="form-reg-heading">Delivery options</h4>
            <div class="btn-group" style="margin-bottom: 5px;">
                <select class="form-control">
                    <option value="">Select country</option>
                    <option value="Belarus">Belarus</option>
                    <option value="Kazakhstan">Kazakhstan</option>
                    <option value="Russia">Russia</option>
                    <option value="Ukraine">Ukraine</option>
                </select>
            </div><br>
            <textarea rows="3" placeholder="Address" style="margin-bottom: 15px;"></textarea>
            <input type="text" class="input-block-level" placeholder="Postcode" style="height: 30px;">

            <h4 class="form-reg-heading">Notifications method</h4>
            <label class="radio">
                <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1">
                By email
            </label>
            <label class="radio">
                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                By phone
            </label>
            <label class="radio">
                <input type="radio" name="optionsRadios" id="optionsRadios3" value="option1">
                Don't notify me
            </label><br>
            <div>
                <input type="text" id="spinEdit4" class="aSpinEdit" style="height: 30px;"><br>
            </div>
            <button class="btn btn-large btn-primary" type="submit">Send</button>
        </form:form>
    </div>
    <script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/app.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/bootstrap-dropdown.js"></script>
    <script src="/js/bootstrap-spinedit.js"></script>
    <script src="/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $('#datetimepicker4').datetimepicker({
                pickTime: false
            });
        });

        $('.aSpinEdit').spinedit({
            minimum: 7,
            maximum: 21,
            step: 1
        });
    </script>
</body>
</html>