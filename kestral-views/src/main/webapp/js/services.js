/* this will manage all our restful responses we will remove these from the controllers now*/
var kestralServices = angular.module('kestralServices', ['ngResource', 'ngCookies']);

kestralServices.factory('Client', ['$resource', function ($resource) {
    return $resource('clients/client/:clientId', {}, {
        query: {method: 'GET', params: {clientId: 'clientId'}, isArray: true}
    });
}]);

//kestralServices.factory('AuthenticationService', ['$http', '$cookieStore', '$rootScope',
//    function ($http, $cookieStore, $rootScope) {
//        var service = {};
//
//        service.login = function (username, password, callback) {
//
//            $http.post("/login", {username: username, password: password}, {headers: {'Content-Type': 'application/json'}})
//                .success(function (response) {
//                    callback(response);
//                });
//
//        };
//
//        service.SetCredentials = function (username, id, companyId) {
//
//            $rootScope.globals = {
//                currentUser: {
//                    username: username,
//                    id: id,
//                    companyId: companyId
//                }
//            };
//
//            $cookieStore.put('globals', $rootScope.globals);
//        };
//
//        service.ClearCredentials = function () {
//            $rootScope.globals = {};
//            $cookieStore.remove('globals');
//            $http.defaults.headers.common.Authorization = 'Basic ';
//        };
//
//        return service;
//    }]);