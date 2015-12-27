var app = angular.module('restaurant.controller.owner',[]);

app.controller('ownerCtrl',['$scope','$location',function($scope,$location){
    var validation_obj = {
        user:'pradeep',
        password:'123'
    };
    $scope.validate=function(validateObj){
        if(angular.equals(validateObj,validation_obj)){
            $location.path('/bookings/'+validateObj.user);
        }else{
            console.log('Invalid User');
        }
    };
}]);

app.controller('bookingCtrl',['$scope','$routeParams','bookingService',function($scope,$routeParams,bookingService){
    $scope.bookingList= bookingService.bookingsList;
    
    
    $scope.delete=function(index){
        $scope.bookingList.splice(index,1);
    }
}]);