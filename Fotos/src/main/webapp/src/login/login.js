'use strict';

angular.module('file')
  .controller('LoginCtrl', function($scope, LoginLogoutSrv) {

    $scope.login = function(email, password) {
      LoginLogoutSrv.login(email, password);
    };

  });
