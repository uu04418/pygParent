app.controller('baseController' , function ($scope) {
	
	// 定义分页对象点信息
	$scope.paginationConf = {
			currentPage : 1 ,
			totalItems :  10 ,
			itemsPerPage: 10,
			perPageOptions : [10 ,20 ,30],
			onChange :function () {
				$scope.reloadPage();
			}
	}
	
	$scope.reloadPage = function () {
		$scope.search($scope.paginationConf.currentPage ,$scope.paginationConf.itemsPerPage );
	}
	
	
	// 定义一个集合
	$scope.selectOptions = [];
	
	// 调用方法
	$scope.changeSelect = function ($event , id) {
		if ($event.target.checked) {
			$scope.selectOptions.push(id);
		}else {
			var index = $scope.selectOptions.indexOf();
			$scope.selectOptions.splice(index,1);
		}
	}
	
});