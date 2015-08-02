/*****************
 * WhatsNewController
 ***************/
App.controller('WhatsNewController', ['$scope', 'ngDialog', 'ipCookie', function($scope, ngDialog, ipCookie) {
  'use strict';

  $scope.whatsNewVersionCookieName = 'whatsNewVersion';
  $scope.currentVersion = '0.10.0';
  $scope.alertWhatsNew = true;
  var versionCookie = ipCookie($scope.whatsNewVersionCookieName);
  if (versionCookie !== undefined && versionCookie === $scope.currentVersion){
      $scope.alertWhatsNew = false;
  }

  $scope.open = function(){
    ngDialog.open({
      template: '/web/app/views/whatsNew.html?version=2',
      className: 'ngdialog-theme-default'
    });

    ipCookie($scope.whatsNewVersionCookieName, $scope.currentVersion, {expires: 365});
    $scope.alertWhatsNew = false;
  }

}]);
