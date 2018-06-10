(function (angular) {
    angular.module('shareCashApp', ['ngRoute'])

        .controller('MainController', function($scope) {
        })
        .controller('TransactionsController', function($scope) {
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
                });
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);