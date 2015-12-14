var kestralApp = angular.module('kestralApp', [
    'kestralControllers'
    ,'kestralServices','kestralRoutes'
]);

kestralApp.config(function($routeProvider){
    $routeProvider
        .when('/login', {  // note the path to
            controller: 'LoginController',
            templateUrl: '/partials/login.html'  // todo make sure these paths work??
        })
        .otherwise({redirectTo: '/login'});



});

//var controllers = {};
//kestralApp.controller(controllers);