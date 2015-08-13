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
    .controller('ClientController', ['clientService', function(clientService){
        var self = this;
        // todo note the company id will come from self when we have a log in
        self.newClient = {user: {userType:'C', company: {id: 1 }}};

        self.list = function() {
            self.clients = clientService.list();
            return self.clients;
        };

        self.add = function() {
            var clientDataPromise = clientService.add(self.newClient);
            clientDataPromise.then(function(result){
                self.clients.push(result);
            }).then(function() {
                self.newClient = {user: {userType:'C', company: {id: 1 }}};
            });
        };

        self.delete = function(clientId, elemIndex) {

            var deleteSuccessPromise = clientService.delete(clientId);

            deleteSuccessPromise.then(function(result) {
                console.log(result);
                for(var i = 0; i < self.clients.length; i++) {
                    if(clientId == self.clients[i].id) {
                        console.log(" found the client in the list with id : " + clientId);
                        self.clients.splice(i, 1);
                        break;
                    }
                }
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