/*****************
 * WhatsNewController
 ***************/
App.controller('WhatsNewController', ['$scope', 'ngDialog', '$cookies', function($scope, ngDialog, $cookies) {
  'use strict';
  
  $scope.currentVersion = '0.10.0';
  $scope.alertWhatsNew = true;
  var versionCookie = $cookies.whatsNewVersion;
  if (versionCookie !== undefined && versionCookie === $scope.currentVersion){
      $scope.alertWhatsNew = false;
  }

  $scope.open = function(){
    ngDialog.open({
      template: '/web/app/views/whatsNew.html?version=2',
      className: 'ngdialog-theme-default'
    });

    $cookies.whatsNewVersion = $scope.currentVersion;
    $scope.alertWhatsNew = false;
  }

}]);
