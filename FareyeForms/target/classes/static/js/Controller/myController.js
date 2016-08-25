//Admin
myApp.controller('admin',['$scope', '$http','dataService','$rootScope','$state', '$stateParams', function ($scope,$http,dataService,$rootScope,$state, $stateParams)
{


//Display All User



    $scope.createForm=function()
    {
        var attributes=[];

        for(var i=0;i<$scope.attribute.label.length;i++)
        {
            attributes[i]={
                label:$scope.attribute.label[i].trim(),
                type:$scope.attribute.type[i],
                formname:$scope.form.name
            };
        }
        formdetail={name:$scope.form.name}

        dataService.createForm(formdetail)
            .then(function (response) {
        dataService.addCategory(attributes)
            .then(function (response) {
                console.log(response.data)
                        $scope.createdForm="Created"
                        $scope.attribute = { label:[], type:[],}
                        $scope.form="";
                        $scope.attribute.label.push('');
                        $scope.attribute.type.push('');

                    })
                    console.log(response.data)

            }, function (error) {
                console.log(error.data);
                $scope.error="Already Exist";
            })

        }

    $scope.checkadmin=function()
    {
        if($rootScope.roles=="user")
            $state.go("user")
    }

    $scope.displayForms=function()
    {
        dataService.getForm()
            .then(function (response) {
                console.log(response.data)
                $scope.formtable=response.data;
            },
                function (error) {
        console.log(error.data);
    })
    }

    $scope.editForm=function()
    {
        var attributes = [];

        for (var i = 0; i < $scope.attribute.label.length; i++) {
            attributes[i] = {
                label: $scope.attribute.label[i].trim(),
                type: $scope.attribute.type[i],
                formname: $scope.form.name.trim()
            };
        }
        dataService.addCategory(attributes)
            .then(function (response) {
                console.log(response.data);

            },
                function (error) {
                    console.log(error.data);
                    $scope.error="Wrong data"

                })
    }



    //Dynamic category

    $scope.attribute = { label:[], type:[],};

    $scope.attribute.label.push('');
    $scope.attribute.type.push('');
    $scope.add = function() {
        $scope.attribute.label.push('');
        $scope.attribute.type.push('');
    }
    $scope.delete = function(index) {
        $scope.attribute.type.splice(index,1);
        $scope.attribute.label.splice(index,1);
    }




    //Display Form
    $scope.displayForms=function()
    {
        console.log("hello");
        dataService.getForm()
            .then(function (response) {
                    console.log(response.data)
                    $scope.formtable=response.data;
                    $scope.errorcreate=""

                },
                function (error) {
                    console.log(error.data);
                    $scope.errorcreate="No Form"

                })
    }



    //Display Content
    $scope.displayit=function() {
        var attribute= {
            label: '',
            type: '',
            formname: $scope.form.name.trim()
        };
        dataService.displayit(attribute).then(function (response) {
            console.log(response.data)
            $scope.attributeTable = response.data
            $scope.errorcreate=""

        }, function (error) {
            console.log(error.data);
            $scope.errorcreate="No Attribute";
        })
    }

}]);

//home Controller
myApp.controller('home',['$scope', '$http','dataService','$rootScope','$state', '$stateParams', function ($scope,$http,dataService,$rootScope,$state, $stateParams)
    {

//find User


    $scope.find_user=function() {
            dataService.userD()
                .then(function (response) {
                    $scope.user = response.data.username;
                   $rootScope.roles=response.data.type;
                    console.log($rootScope.roles);
                    console.log($scope.user)
                         if($rootScope.roles==="admin")
                            $state.go("admin")
                        else if($rootScope.roles==="user")
                            $state.go("user")
                }, function (error) {
                    console.log(error.data);
                });
        }



    }]);




myApp.controller('user',['$scope', '$http','dataService','$rootScope','$state', '$stateParams', function ($scope,$http,dataService,$rootScope,$state, $stateParams)
{


    console.log("inside");



    //Display Form
    $scope.displayForms=function()
    {
        console.log("hello");
        dataService.getForm()
            .then(function (response) {
                    console.log(response.data)
                    $scope.formtable=response.data;
                    $scope.errorcreate=""

                },
                function (error) {
                    console.log(error.data);
                    $scope.errorcreate="No Form"

                })
    }




    //Display Content
    $scope.displayit=function() {
        var attribute= {
            label: '',
            type: '',
            formname: $scope.form.name.trim()
        };
        dataService.displayit(attribute).then(function (response) {
            console.log(response.data)
            $scope.attributeTable = response.data
            $scope.errorcreate=""

        }, function (error) {
            console.log(error.data);
            $scope.errorcreate="No Attribute";
        })
    }




    //Check User
    $scope.checkuser=function()
    {
        if($rootScope.roles==="admin")
            $state.go("admin")
    }





    //create Transaction

    $scope.createTransaction=function()
    {

        console.log($scope.attributeTable.value);

        var record=[];
        for(var i=0;i<$scope.attributeTable.length;i++) {
            record[i] = {
                attributeId: $scope.attributeTable[i].id,
                attributevalue: $scope.attributeTable.value[i],
            }
        }
        transaction={username:'',formname:$scope.form.name.trim(),attributeValueSet:record};
        dataService.createRecord(transaction)
            .then(function (response) {
                console.log(response)
                $scope.errorcreate=""
                $scope.attributeTable.value=[];
                $scope.inserted="Inserted"
                console.log(record);
                    },function (error) {
                console.log(error.data);
                $scope.inserted=""
                $scope.errorcreate="Error created"
            })
    }




//Show Records
    $scope.displayRecords=function()
    {

        form={name:$scope.form.name.trim()}
        var attribute= {
            label: '',
            type: '',
            formname: $scope.form.name.trim()
        };
        $scope.attvalue=[];
        dataService.displayit(attribute).then(function (response) {
            console.log(response.data)
            $scope.attributeTable = response.data;
            for(var i=0;i<response.data.length;i++)
            $scope.attvalue[i]={label:$scope.attributeTable[i].label,value:''};

        })
        console.log($scope.attvalue)

        dataService.displayRecord(form)
            .then(function (response) {
                console.log(response.data);
                //var temp=[];
                //for(var i=0;i<response.data.length;i++)
                //        temp[i]={value:response.data[i].attributeValueSet};
                $scope.recordTable=response.data;
                $scope.size=response.length-1;
                console.log($scope.recordTable.value)

               },function (error) {
                console.log(error.data);
                $scope.norecord="No Record Found"
            })
    }



}]);
