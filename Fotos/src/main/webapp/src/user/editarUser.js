'use strict';

angular.module('file')
  .controller('EditarUserCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH ) {

    $scope.editar = {};
    $scope.editars = [];

    $scope.permissions = [];

    $scope.showEditUser = false;



    // Editar.
    $scope.show = function() {
      $scope.showEditUser = true;

    };

    // Editar.
    $scope.hide = function() {
      $scope.showEditUser = false;
      $scope.editar = {};
    };






    // Manage CRUD operations.
    var userUrl = SERVICE_PATH.PRIVATE_PATH + '/user';

    $scope.editUser = function(editar) {
      $scope.editar = angular.copy(editar);
      $scope.show();
    };

    $scope.visao = function(editar) {
      $scope.editar = angular.copy(editar);
      $scope.show();
    };



    $scope.deleteUser = function(editar) {
      RestSrv.delete(userUrl, editar, function(status,data) {
        $scope.editars.splice($scope.editars.indexOf(editar), 1);
        ngNotify.set('User \'' + editar.name + '\' Excluido com sucesso!!.', 'success');
      });
    };


    $scope.Editar = function(editar) {
      if (editar.id) {
        RestSrv.edit(userUrl, editar, function() {
          delete editar.password;



          for (var i = 0; i < $scope.editars.length; i++) {
            if ($scope.editars[i].id === editar.id) {
              $scope.editars[i] = editar;
            }
          }


          $scope.hide();
          ngNotify.set('User \'' + editar.name + '\' Editado com sucesso!!.', 'success');
        });

      } else {
        RestSrv.add(userUrl, editarr, function(newUser) {

          $scope.editars.push(newUser);

          $scope.hide();
          ngNotify.set('User \'' + editar.name + '\' Salvo com sucesso!!.', 'success');



        });
      }
    };





    // Request all data (permission and user).
    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';

    RestSrv.find(permissionUrl, function(data) {
      $scope.permissions = data;

      RestSrv.find(userUrl, function(data) {
        $scope.editars = data;
        ngNotify.set('Conectado users com sucesso!!.', 'success');
      });
    });

  });
