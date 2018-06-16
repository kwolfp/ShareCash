(function (angular) {
    angular.module('shareCashApp', ['ngRoute'])

        .controller('MainController', function($scope) {
        })
        .controller('TransactionsController', function($scope) {
        })
        .controller('CreditCardController', function($scope, $http) {
            $scope.addCreditCard=function () {
                $http({
                    method : 'POST',
                    url : '/creditCards/create',
                    data: {
                         provider: $scope.provider,

                    }
                }).then(function successCallback(response) {
                    console.log(response.data);
                }, function errorCallback(response) {
                    console.log(response.statusText);
                });
            }
        })
        .config(function($routeProvider, $locationProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'index',
                    controller: 'MainController'
                })
                .when('/transactions', {
                    templateUrl: 'transactions',
                    controller: 'TransactionsController'
                })
                .when('/creditCards', {
                    templateUrl: 'creditCards',
                    controller: 'CreditCardController'
                 });

            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);