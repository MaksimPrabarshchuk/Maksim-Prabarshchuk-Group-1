angular.module('usersService', ['ngResource']).
    factory('Users', function($resource){
  return $resource('rest/users', {});
});