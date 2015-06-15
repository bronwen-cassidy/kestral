/* this will manage all our restful responses we will remove these from the controllers now*/
var kestralServices = angular.module('kestralServices', ['ngResource']);

kestralServices.factory('Provider', ['$resource', function ($resource) {
    return $resource('providers/provider/:providerId', {}, {
        query: {method: 'GET', params: {providerId: 'providerId'}, isArray: true}
    });
}]);

kestralServices.factory('Client', ['$resource', function ($resource) {
    return $resource('clients/client/:clientId', {}, {
        query: {method: 'GET', params: {clientId: 'clientId'}, isArray: true}
    });
}]);

kestralServices.factory('Clients', ['$resource', function ($resource) {
    return $resource('clients/:providerId', {}, {
        query: {method: 'GET', params: {providerId: 'providerId'}, isArray: true}
    });
}]);