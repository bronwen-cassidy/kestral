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