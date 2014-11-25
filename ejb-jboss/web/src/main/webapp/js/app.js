angular.module('regform', [ 'ngRoute', 'usersService' ])
    .config( [ '$httpProvider','$routeProvider', function($httpProvider, $routeProvider) {
        $httpProvider.interceptors.push('ajaxNonceInterceptor');
        $routeProvider.
        when('/mainView', {
            templateUrl : 'mainView.html',
            controller : UsersCtrl
        }).otherwise({
            redirectTo : '/mainView'
        });
    } ])
    .factory('ajaxNonceInterceptor', function() {
        var param_start = /\?/;
        return {
            request : function(config) {
                if (config.method == 'GET') {
                    config.url += (param_start.test(config.url) ? "&" : "?") + '_=' + new Date().getTime();
                }
                return config;
            }
        }
    });