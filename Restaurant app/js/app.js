var app = angular.module('Restaurant-app',
                        ['ngRoute',
                         'restaurant.controller.mainCtrl',
                        'restaurant.controller.reserveCtrl']);

app.config(['$routeProvider',function($routeProvider){
    $routeProvider.when('/',{
       templateUrl:'../../partials/main.html',
        controller:'mainCtrl'
    }).when('/reserve',{
        templateUrl:'../../partials/reserve.html',
        controller:'reserveCtrl'
    }).when('/new-reservation',{
        templateUrl:'../../partials/reservation/new-reservation.html',
        controller:'reserveCtrl'
    }).when('/edit-reservation',{
        templateUrl:'../../partials/reservation/edit-reservation.html',
        controller:'reserveCtrl'
    }).otherwise({
        redirectTo:'/'
    });
}]);