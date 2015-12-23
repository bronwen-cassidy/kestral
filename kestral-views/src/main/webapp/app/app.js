var kestralApp = angular.module('kestralApp', ['ngRoute','ngCookies','ngAnimate', 'kestralControllers','kestralServices']);

kestralApp.config( function( $routeProvider ){
    $routeProvider
        .when('/', {  // note the path to
            templateUrl: 'app/partials/kestral.html'
        })
        .when('/login', {  // note the path to
            controller: 'LoginController',
            templateUrl: 'app/partials/security/login.html'
        })
        .when('/register', {  // note the path to
            controller: 'UserController',
            templateUrl: 'app/partials/security/register.html'
        })
        .when('/home', {  // note the path to
            controller: 'HomeController',
            templateUrl: 'app/partials/home.html'
        })
        .otherwise({redirectTo: '/login'});
});

//kestralApp.run( function( $rootScope, $location, $cookieStore, $http ) {

//    $rootScope.$on('$locationChangeStart', function (event, next, current) {
//        // redirect to login page if not logged in and trying to access a restricted page
//        var restrictedPage = $.inArray($location.path(), ['/login', '/register', '/']) === -1;
//        var loggedIn = $rootScope.globals.currentUser;
//        if (restrictedPage && !loggedIn) {
//            $location.path('/login');
//        }
//    });
//});
