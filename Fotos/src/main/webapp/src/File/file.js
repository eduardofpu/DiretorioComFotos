'use strict';

angular.module('file')
  .controller('fileCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH ) {
    $scope.f = {};
    $scope.files = [];   
    $scope.showAddEdit = false;
    
    $scope.show = function() {
      $scope.showAddEdit = true;
    };
    
    $scope.hide = function() {
      $scope.showAddEdit = false;
      $scope.f = {};
    };



    // Manage CRUD operations.
    var fileUrl = SERVICE_PATH.PRIVATE_PATH + '/file';


    $scope.updateLinkImage = function(f){
        var arq = f.split(',');
        $scope.f.mymeType = arq[0];
        $scope.f.file = arq[1];
    };

    

    $scope.editarFile = function(f) {
      $scope.f = angular.copy(f);
      $scope.show();
    };

    $scope.deletarFile = function(f) {
      RestSrv.delete(fileUrl, f, function(status,data) {
        $scope.files.splice($scope.files.indexOf(f), 1);
        ngNotify.set('File \'' + f.nomeImage + '\' Excluido com sucesso!!.', 'success');
      });
    };

    $scope.salvarFile = function(f) {
      if (f.id) {
        RestSrv.edit(fileUrl,f, function() {  

          for (var i = 0; i < $scope.files.length; i++) {
            if ($scope.files[i].id === f.id) {
              $scope.files[i] = f;
            }
          }

          $scope.hide();
          ngNotify.set('File \'' + f.nomeImage+ '\' Editado com sucesso!!.', 'success');
        });
      } else {
        RestSrv.add(fileUrl, f, function(newFile) {

          $scope.files.push(newFile);

          $scope.hide();
          ngNotify.set('File \'' + f.nomeImage + '\' Salvo com sucesso!!.', 'success');



        });
      }
    };


    RestSrv.find(fileUrl, function(data) {
        $scope.files = data;

        ngNotify.set('Conectado com sucesso!.', 'success');
      });


  });
