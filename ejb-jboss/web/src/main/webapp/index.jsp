<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" ng-app="regform">
<head>
    <title>Registered Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script src="js/libs/jquery-2.0.3.js"></script>
    <script src="js/libs/bootstrap.js"></script>
    <script src="js/libs/angular.js"></script>
    <script src="js/libs/angular-route.js"></script>
    <script src="js/libs/angular-resource.js"></script>

    <script src="js/controllers.js"></script>
    <script src="js/app.js"></script>
    <script src="js/services.js"></script>
</head>
<body>
    <section id="container">
        <div id="content" ng-view>
            <!-- For template -->
        </div>
    </section>
</body>
</html>