var kestralApp = angular.module('kestralApp', []);

// todo this will provide the company id, user id, may be a client or a provider we will type it etc
kestralApp.controller('loginClientController', function ($scope, $http) {

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

// todo figure out how to obtain the id, companyId will come from a login but where would it go
kestralApp.controller('client', ['$scope', '$http', function ($scope, $http) {
    $http.get('clients/client/?/').success(function(data) {
        $scope.client = data;
    });
}]);

// todo figure out how to obtain the id, companyId will come from a login but where would it go
kestralApp.controller('company', ['$scope', '$http', function ($scope, $http) {
    $http.get('companies/company/?/').success(function(data) {
        $scope.company = data;
    });
}]);

kestralApp.controller('providers', ['$scope', '$http', function ($scope, $http) {
    $http.get('providers/all/?/').success(function(data) {
        $scope.providers = data;
    });
}]);