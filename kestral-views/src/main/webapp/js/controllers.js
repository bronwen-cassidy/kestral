var kestralControllers = angular.module('kestralControllers', []);

// todo this will provide the company id, user id, may be a client or a provider we will type it etc
kestralControllers.controller('loginProviderController', function ($scope, $http) {

    $scope.onLogin = function () {
        console.log('Attempting login with username ' + $scope.vm.username + ' and password ' + $scope.vm.password);
        if ($scope.form.$invalid) {
            return;
        }
        $http({method: 'POST', url: '/login', data: $scope.formData
        }).success(function(data) {
            $scope.successMsg = data;
        }).error(function(data, status, headers, config) {
            if(status == 400) {
                $scope.errMessages = data;
            } else {
                alert('Unexpected server error.');
            }
        });
    };
});

kestralControllers.controller('clientsController', ['$scope', '$routeParams', 'Clients', function ($scope, $routeParams, Clients) {
    $scope.clients = Clients.get({providerId: $routeParams.providerId});
    $scope.orderProp = 'name';
}]);

// todo figure out how to obtain the id, companyId will come from a login but where would it go
kestralControllers.controller('clientController', ['$scope', '$routeParams', 'Client', function ($scope, $routeParams, Client) {
    $scope.client = Client.get({clientId: $routeParams.clientId}, function(client) {
        // make sure we have the companyId
        $scope.companyId = client.company.id;
    });

    // note functions relating to the client go here
    $scope.setName = function(name) {
        $scope.client.name = name;
    };
}]);

// todo figure out how to obtain the id, companyId will come from a login but where would it go
kestralControllers.controller('company', ['$scope', '$http', function ($scope, $http) {
    $http.get('companies/company/?/').success(function(data) {
        $scope.company = data;
    });
}]);

kestralControllers.controller('providers', ['$scope', '$http', function ($scope, $http, $routeParams) {
    $scope.companyId = $routeParams.companyId;
    $http.get('providers/all/{{$scope.companyId}}/').success(function(data) {
        $scope.providers = data;
    });
}]);

// todo appointment controller will be huge with many functions relating directly to appointments
// todo 2 flows to map a provider marking unavailable days (holiday etc)
// todo client flow to book an appointment