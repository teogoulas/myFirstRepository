var app = angular.module('app', []);

app.service('ClassesService', ['$http', function ($http) {

	this.retrieveSelectedClass = function retrieveSelectedClass(className){
		return $http({
			method: 'POST',
			url: 'classes.html',
			params: {className:className}
		});
	}

	this.getClasses = function getUsers(){
		return $http({
			method: 'GET',
			url: 'availableClasses.json',
			headers:'Accept:application/json'
		}).then( function(response){
			return response.data;
		} );
	}
}]);


app.controller('ClassesCtrl', ['$scope','ClassesService', function ($scope, ClassesService) {

	$scope.getClasses = function() {
		ClassesService.getClasses().then(function(data) {
			$scope.classes = data;
		});
	};

	$scope.retrieveSelectedClass = function() {
		$scope.submitted = true;
		if ($scope.classForm.$valid) {
			ClassesService.retrieveSelectedClass($scope.classes.className)
				.then (function success(response) {
						$scope.message = 'Class retrieved!';
						$scope.errorMessage = '';
						$scope.getClasses();
						$scope.classes = null;
						$scope.submitted = false;
					},
					function error(response) {
						if (response.status == 409) {
							$scope.errorMessage = response.data.message;
						}
						else {
							$scope.errorMessage = 'Error adding user!';
						}
						$scope.message = '';
					});
		}
	}

	$scope.getClasses();
}]);