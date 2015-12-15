/* this will manage all our restful responses we will remove these from the controllers now*/
var kestralServices = angular.module('kestralServices', [])

    .factory('loginFactory', ['$http', function($http) {

        var loginFactory = {};
        var user = {};
        var client = {};
        var provider = {};
        var company = {};

        loginFactory.loginCustomer = function(username, password) {

            var data = $.param({'loginInfo.username': username, 'loginInfo.password': password});

            $http.post('/kestral/logins/login/', data).then(function(response){
                // this will the user
                user = response.user;
                return response.data;

            });
        };
        return loginFactory;

    }])
;