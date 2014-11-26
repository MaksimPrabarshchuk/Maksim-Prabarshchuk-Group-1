function UsersCtrl($scope, $http, Members) {

    $scope.refresh = function() {
        $scope.users = Users.query();
    };

    $scope.clearMessages = function () {
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};
    };

    $scope.reset = function() {
        if($scope.regForm) {
            $scope.regForm.$setPristine();
        }
        $scope.newUser = {firstName: "", lastName: "", age: ""};
        $scope.clearMessages();
    };

    $scope.register = function() {
        $scope.clearMessages();
        Users.save($scope.newUser, function(data) {
            $scope.refresh();
            $scope.reset();
            $scope.successMessages = [ 'User Registered' ];
        }, function(result) {
            if ((result.status == 409) || (result.status == 400)) {
                $scope.errors = result.data;
            } else {
                $scope.errorMessages = [ 'Unknown server error' ];
            }
        });

    };

    $scope.refresh();
    $scope.reset();
    $scope.orderBy = 'firstName';
}