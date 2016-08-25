var myApp = angular.module('formApp', ['ui.router']);
myApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");
    $stateProvider
        .state('/', {
            url: "/home",
                    templateUrl: 'home.html'
        })

        .state('admin', {
            url: "/admin",
            controller:'admin',

            views:{
                A:
        {
            templateUrl: 'admin.html'
        }
        }})


                 .state('admin.addForm', {
                        url: "/addform",
                     controller:'admin',

                     templateUrl: 'addForm.html'
                        })

                 .state('admin.viewForm', {
                        url: "/viewforms",
                     controller:'admin',

                     templateUrl: 'viewForm.html'
                        })

                     .state('admin.editForm', {
                      url: "/editForms",
                    controller:'admin',

                     templateUrl: 'editForm.html'
                      })
                //.state('admin.register', {
                //    url: "/register",
                //    controller:'admin',
                //    templateUrl: 'register.html'
                //})
        .state('user', {
            url: "/user",

            views:{
            A:
            {
                templateUrl: 'user.html'
            }
        }
        })
        .state('user.createTransaction', {
            url: "/addRecord",
            controller:'user',
            templateUrl: 'createTransaction.html'
        }).state('user.showTransaction', {
        url: "/showRecords",
        controller:'user',
        templateUrl: 'viewTransaction.html'
    })


});



angular.module('formApp')
    .service('dataService', ['$http', function ($http) {

        var urlBase = "http://localhost:8080";
        this.userD = function () {
            return $http.get(urlBase+"/getuser");
        };
        this.createForm = function (form) {
            return $http.post(urlBase+"/createForm",form);
        };
        this.addCategory = function (attribute) {
            return $http.post(urlBase+"/addAttribute",attribute);
        };
        this.getForm = function () {
            return $http.get(urlBase+"/getForm");
        };
        this.displayit=function(attribute)
        {
            return $http.post(urlBase+"/getFormAttribute",attribute);
        }

        this.createRecord = function (transaction) {
            return $http.post(urlBase+"/insertTransaction",transaction);
        };


        this.displayRecord=function(form){
            return $http.post(urlBase+"/displayRecord",form);

        }
    }]);
/*  myApp.run(function ($rootScope, $state) {
        $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){

        });
    });
*/