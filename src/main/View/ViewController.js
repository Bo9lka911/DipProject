/**
 * Created by fedorishchev_as on 21.11.2016.
 */
var MyApp = angular.module('App', [])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/Employees', {
                templateUrl: "Employees.html",
            })
            .when('/CreateEmploy', {
                templateUrl: "CreateEmploy.html",
            })
            .when('/Employ/Change', {
                templateUrl:"Employ-change.html",
            })
            .otherwise({ redirectTo: '/Employees' });
    }]);
