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
    .controller('ClientController', ['$scope','clientService', function($scope, clientService){
        var self = this;
        // todo note the company id will come from the scope when the user logs in
        self.newClient = {user: {userType:'C', company: {id: 1 }}};

        self.list = function() {
            $scope.clients = clientService.list();
            return $scope.clients;
        };

        self.add = function() {
            var clientDataPromise = clientService.add(self.newClient);
            clientDataPromise.then(function(result){
                $scope.clients.push(result);
            }).then(function() {
                self.newClient = {user: {userType:'C', company: {id: 1 }}};
            });
        };

        self.delete = function(clientId) {
            console.log("the client id i have been given is: " + clientId)
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