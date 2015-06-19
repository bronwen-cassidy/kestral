var kestralApp = angular.module('kestralApp', [
    'ngRoute',
    'ngCookies',
    'ngResource',
    'kestralControllers',
    'kestralServices'
]);

kestralApp.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/clients/client/:clientId', {
                templateUrl: 'pages/clients/client-detail.html',
                controller: 'clientController'
            })
            .otherwise({redirectTo: '/'});
    }]);
