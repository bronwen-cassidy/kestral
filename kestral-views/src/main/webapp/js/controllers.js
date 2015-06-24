var kestralControllers = angular.module('kestralControllers', []);

kestralControllers.controller('MainController', ['$http', function ($http) {
    console.log("Created the main controller give me moooar");
    var self = this;
    $http.get('/kestral/clients/client/find/1').
        success(function(data, status, headers, config) {
            console.log("whew made it");
            self.clients = data;
            // this callback will be called asynchronously
            // when the response is available
        }).
        error(function(data, status, headers, config) {
            console.log("error!!!");
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        }
    );
    self.getClientClass = function(userType) {
        return {done : userType == 'C', pending: userType == 'P'};
    };
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