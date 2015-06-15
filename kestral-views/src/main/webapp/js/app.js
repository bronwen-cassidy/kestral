var kestralApp = angular.module('kestralApp', [
    'ngRoute',
    'kestralControllers',
    'kestralServices'
]);

kestralApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/clients', {
            templateUrl: 'clients/client-list.html',
            controller: 'clientsController'
        }).
        when('/client/:clientId', {
            templateUrl: 'clients/client-detail.html',
            controller: 'clientController'
        }).
        otherwise({
            redirectTo: '/pages/login.html'
        });
}]);