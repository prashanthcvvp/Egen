var app = angular.module('restaurant.controller.reserveCtrl',[]);

app.controller('reserveCtrl',['$scope',function($scope){
    $scope.options={
        edit:'Edit',
        cancel:'Cancel'
    };
}]);