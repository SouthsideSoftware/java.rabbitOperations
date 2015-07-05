/**=========================================================
 * Module: tour.js
 =========================================================*/
App.controller('TourCtrl', ['$scope',function($scope){
  
  // BootstrapTour is not compatible with z-index based layout
  // so adding position:static for this case makes the browser
  // to ignore the property
  var section = angular.element('.wrapper > section')
  section.css({'position': 'static'});
  // finally restore on destroy and reuse the value declared in stylesheet
  $scope.$on('$destroy', function(){
    section.css({'position': ''});
  });

}]);