/* this will manage all our restful responses we will remove these from the controllers now*/
var kestralServices = angular.module('kestralServices', [])
    .service('clientService', ['$http', function ($http) {
        var self = this;
        $http.get('/kestral/clients/client/find/1').
            success(function (data, status, headers, config) {
                self.clients = data;
            }).
            error(function (data, status, headers, config) {
                console.log("error!!!");
                self.errorMsg = "error";
            }
        );
        //var items = [ { id : 1 , user : {firstname : 'Item 0'}}, { id : 2 , user : {firstname : 'Item 1'}} ];
        this.list = function () {
            return self.clients;
        };
        this.add = function (item) {
            console.log("Got to item adding");
        };
    }
]);

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