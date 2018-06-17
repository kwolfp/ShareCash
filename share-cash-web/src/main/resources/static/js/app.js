(function (angular) {
    angular.module('shareCashApp', ['ngRoute'])

        .controller('MainController', function($scope) {
        })
        .controller('TransactionsController', function($scope) {
        })
        .controller('GroupsController', function($scope) {
        })
        .controller('CreditCardController', function($scope, $http) {
            $scope.addCreditCard=function () {
                $http({
                    method : 'POST',
                    url : '/creditCards/create',
                    headers: CSRF.header,
                    data: {
                        provider: $scope.provider,
                        cardNumber: $scope.card_number,
                        ownerName: $scope.owner_name,
                        ownerAddress: $scope.owner_address,
                        country: $scope.country,
                        csc: $scope.csc,
                        exp: Date.parse("01/"+$scope.exp)
                    }
                }).then(function successCallback(response) {
                    console.log(response.data);
                    alert("Dodano kartę")
                }, function errorCallback(response) {
                    console.log(response.statusText);
                    alert("Niepoprawne dane")
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
                .when('/creditCards_add', {
                    templateUrl: 'creditCards/add',
                    controller: 'CreditCardController'
                 })
                .when('/creditCards_list', {
                    templateUrl: 'creditCards/list',
                    controller: 'CreditCardController'
                }).when('/groups', {
                    templateUrl: 'groups',
                    controller: 'GroupsController'
                });
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);