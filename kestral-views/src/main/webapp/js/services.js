/* this will manage all our restful responses we will remove these from the controllers now*/
var kestralServices = angular.module('kestralServices', [])
    .service('clientService', ['$http', function ($http) {

        var self = this;

        $http.get('/kestral/clients/client/find/1').then(
            function (response) {
                self.clients = response.data;
            }, function(errResponse) {
                console.log("error!!!");
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
    }
]);