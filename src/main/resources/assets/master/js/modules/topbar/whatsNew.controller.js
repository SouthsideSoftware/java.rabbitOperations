(function() {
  'use strict';

  angular
    .module('app.whatsNew')
    .controller('WhatsNewController', WhatsNewController);

  WhatsNewController.$inject = ['$scope', '$cookies', 'ngDialog'];
  function WhatsNewController($scope, $cookies, ngDialog) {
    'use strict';

    $scope.whatsNewVersionCookieName = 'whatsNewVersion';
    $scope.currentVersion = '0.10.0';
    $scope.alertWhatsNew = true;
    var versionCookie = $cookies.get($scope.whatsNewVersionCookieName);
    if (versionCookie !== undefined && versionCookie === $scope.currentVersion){
      $scope.alertWhatsNew = false;
    }

    $scope.open = function(){
      ngDialog.open({
        template: '/web/app/views/whatsNew.html?version=3',
        className: 'ngdialog-theme-default'
      });

      var now = new Date();
      var exp = new Date(now.getUTCFullYear()+1, now.getUTCMonth(), now.getUTCDate());
      $cookies.put($scope.whatsNewVersionCookieName, $scope.currentVersion, {expires: exp});
      $scope.alertWhatsNew = false;
    }

  }
})();
