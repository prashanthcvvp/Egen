var app = angular.module('restaurant.service.bookings',[]);

app.service('bookingService',function(){
    var self = this;
    
    self.bookingsList=[
        {
            confirmNum:'12345678',
            name:'a',
            time:'6:40 pm',
            tableNumber:'4',
            headCount:'4'
        },
        {
            confirmNum:'12345687',
            name:'b',
            time:'7:00pm',
            tableNumber:'1',
            headCount:'10'
        },
        {
            confirmNum:'12345637',
            name:'c',
            time:'7:10pm',
            tableNumber:'2',
            headCount:'11'
        }
    ];
});