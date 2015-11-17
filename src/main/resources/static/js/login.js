var eventsupdates = angular.module('eventsupdates', ['ngRoute']);

polygon.config(['$routeProvider', function ($routeProvider) {
	$routeProvider
	.when('/login', {
		'templateUrl': '/html/login.html',
		'controller': 'loginCtrl'
	}).otherwise({
		redirectTo: '/home'
	});
}]);


eventsupdates.directive('fileModel', ['$parse', function ($parse) {
	return {
		restrict: 'A',
		link: function (scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function () {
				scope.$apply(function () {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
}]);