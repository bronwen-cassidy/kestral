/* this will manage all our restful responses we will remove these from the controllers now*/
var kestralServices = angular.module('kestralServices', [])
    .service('clientService', ['$http', function ($http) {

        var self = this;
        // todo inline this into a search function to be consistent
        $http.get('/kestral/clients/client/search/forcompany/:companyId')
            .then(function (response) {
                self.clients = response.data;
            }, function(errResponse) {
                console.log(errResponse);
                self.errorMsg = "error";
            }
        );

        this.list = function () {
            return self.clients;
        };

        this.add = function (newClient) {
            return $http.post( '/kestral/clients/client/add', newClient)
                .then(function(response) {
                    return response.data;
                }
            );
        };

        this.delete = function (clientId) {
            return $http.get( '/kestral/clients/client/delete/'+ clientId)
                .then(function(response) {
                    return response.data;
                }
            );
        };

        this.find = function(clientId) {
            return $http.get( '/kestral/clients/client/'+ clientId)
                .then(function(response) {
                    return response.data;
                }
            );
        }
    }])

    .service('userService', ['$http', function($http) {
        var self = this;

        // todo register etc
    }])

    .service('loginService', ['$http', function($http) {

        this.login = function(loginInfo) {
            return $http.post('/kestral/logins/login/', loginInfo)
                .then(function(response){
                    // this will the user
                    return response.data;
                }, function (errResponse) {
                    return errResponse;
                });
        }
    }])
;