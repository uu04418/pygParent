

app.controller('brandController' , function ($scope,$controller,brandService) {
			
	$controller('baseController',{$scope:$scope});
	
	$scope.findall = function () {
		brandService.findall().success(
			function (response) {
				$scope.list = response;
			}		
		);
	}
	
	
	
	// 分页查询数据
	/*$scope.findPage = function (page,size) {
		$http.get('../brand/findPage.do?page='+page+'&size='+size+'').success(
			function (response) {
				$scope.paginationConf.totalItems = response.total ;
				$scope.list = response.rows;
			}		
		);
	}*/
	
	$scope.searchEntity = {};
	// 分页查询品牌
	$scope.search = function (page,size) {
		brandService.search(page,size,$scope.searchEntity).success(
				function (response) {
					$scope.paginationConf.totalItems = response.total ;
					$scope.list = response.rows;
				}		
			);
		
	}
	
	// 新增品牌
	$scope.save = function () {
		var obj = null;
		if ($scope.brand.id == null){
			obj = brandService.add($scope.brand);
		}else {
			obj = brandService.update($scope.brand);
		}
		//var methName =  $scope.brand.id == null ? 'add' : 'update'
		obj.success(
			function (response) {
				if (response.success) {
					$scope.reloadPage();
				}else {
					alert(response.message);
				}
			}		
		);
	}
	
	// 查询一个品牌
	$scope.findOne = function (id) {
		brandService.findOne(id).success (
			function (response) {
				$scope.brand = response ;
			}
		);
		
	}
	
	
	
	// 删除品牌
	$scope.deletebrand = function () {
		brandService.deletebrand($scope.selectOptions).success (
				function (response) {
					if (response.success) {
						$scope.reloadPage();
						$scope.selectOptions = [];
					}else {
						alert(response.message);
					}
					
				}
			);
	}
			
			
});