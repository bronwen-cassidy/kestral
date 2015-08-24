var kestralRoutes = angular.module('kestralRoutes', ['ngRoute'])
    .config(['$routeProvider', function($routeProvider){
        $routeProvider.when('/kestral/clients/client/find/:id', {
            templateUrl: 'pages/clients/client-detail.html',
            controller : ['ClientController','$routeParams' , function ( $routeParams ) {
                this.detailId = $routeParams . detId ; this . qStr = $routeParams . q ;
            }]
        })
    }
]);