'use strict';

angular.module('file')
  .controller('UserCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH ) {
    $scope.user = {};
    $scope.users = [];
    $scope.permissions = [];


    $scope.showAddEditUser = false;
    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.user = {};
    };



    // Manage CRUD operations.
    var userUrl = SERVICE_PATH.PRIVATE_PATH + '/user';





    $scope.editUser = function(user) {
      $scope.user = angular.copy(user);
      $scope.show();
    };

    $scope.deleteUser = function(user) {
      RestSrv.delete(userUrl, user, function(status,data) {
        $scope.users.splice($scope.users.indexOf(user), 1);
        ngNotify.set('User \'' + user.name + '\' Excluido com sucesso!!.', 'success');
      });
    };

    $scope.saveUser = function(user) {
      if (user.id) {
        RestSrv.edit(userUrl, user, function() {
          delete user.password;



          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) {
              $scope.users[i] = user;
            }
          }


          $scope.hide();
          ngNotify.set('User \'' + user.name + '\' Editado com sucesso!!.', 'success');



        });
      } else {
        RestSrv.add(userUrl, user, function(newUser) {

          $scope.users.push(newUser);

          $scope.hide();
          ngNotify.set('User \'' + user.name + '\' Salvo com sucesso!!.', 'success');



        });
      }
    };




    // Request all data (permission and user).
    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';

    RestSrv.find(permissionUrl, function(data) {
      $scope.permissions = data;

      RestSrv.find(userUrl, function(data) {
        $scope.users = data;

        ngNotify.set('Conectado users com sucesso!!.', 'success');
      });
    });

  });
