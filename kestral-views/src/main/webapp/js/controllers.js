var kestralControllers = angular.module('kestralControllers', [])
    .controller('MainController', ['$http', function ($http) {
        var self = this;
        $http.get('/kestral/clients/client/find/1').
            success(function(data) {
                console.log("whew made it");
                self.clients = data;
            }).
            error(function(data) {
                console.log("error!!!");
            }
        );
        self.getClientClass = function(userType) {
            return {done : userType == 'C', pending: userType == 'P'};
        };
        self.tab = 'first';
        self.open = function(tab) {
            self.tab = tab;
        };
    }])
    .controller('ClientController', ['$http', '$scope','clientService', function($http, $scope, clientService){
        var self = this;
        self.newClient = {user: {userType:'C', company: {id: 1 }}};

        self.list = function() {
            $scope.clients = clientService.list();
            return $scope.clients;
        };

        self.add = function() {

            $http.post( '/kestral/clients/client/add', self.newClient)
                .then(function(response){
                    $scope.clients.push(response.data);
                })
                .then(function(response) {
                    self.newClient = {};
                });
        };
    }])
    .controller('SubCtrl', ['clientService', function(clientService){
       var self = this;
        self.list = function() {
            return clientService.list();
        };
        self.add = function() {
            clientService.add();
        }
    }]);