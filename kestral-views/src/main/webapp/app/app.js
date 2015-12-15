var kestralApp = angular.module('kestralApp', ['ngRoute', 'ngAnimate', 'kestralControllers','kestralServices']);

kestralApp.config(function($routeProvider){
    $routeProvider
        .when('/', {  // note the path to
            templateUrl: 'app/partials/kestral.html'  // todo make sure these paths work??
        })
        .when('/login', {  // note the path to
            controller: 'LoginController',
            templateUrl: 'app/partials/security/login.html'  // todo make sure these paths work??
        })
        .otherwise({redirectTo: '/login'});



});

//var controllers = {};
//kestralApp.controller(controllers);