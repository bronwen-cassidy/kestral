var kestralControllers = angular.module('kestralControllers', []);

controllers.ClientController = ['clientService', function(clientService){
    var self = this;
    // todo note the company id will come from self when we have a log in
    self.newClient = {user: {userType:'C', company: {id: 1 }}};

    self.find = function(clientId) {
        clientService.find(clientId).then(function(result){
            self.client = result;
        });
    };

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

}];

controllers.ScheduleController = ['scheduleService', function(scheduleService){

}];
