var kestralControllers = angular.module('kestralControllers', [])
    .controller('MainController', ['$http', function ($http) {
        var self = this;
        $http.get('/kestral/clients/client/find/1').
            success(function(data, status, headers, config) {
                console.log("whew made it");
                self.clients = data;
            }).
            error(function(data, status, headers, config) {
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
    .controller('SubCtrl', ['clientService', function(clientService){
       var self = this;
        self.list = function() {
            return clientService.list();
        };
        self.add = function() {
            clientService.add();
        }
    }]);

kestralControllers.controller('LoginController', ['$http', function ($http) {
    console.log("Login controller");
    var self = this;
    self.submit = function() {
        $http.post("/kestral/app/login", {loginInfo: self.loginInfo}).
            success(function(data, status, headers, config) {
                self.user = data.user;
                console.log("message = " + data.successMsg);

                // this callback will be called asynchronously
                // when the response is available
            }).
            error(function(data, status, headers, config) {
                console.log("message = " + data.errorMsg);
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            }
        );
    }
}]);