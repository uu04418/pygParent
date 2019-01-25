

app.controller('brandController' , function ($scope,$http,brandService) {
			
	$scope.findall = function () {
		brandService.findall().success(
			function (response) {
				$scope.list = response;
			}		
		);
	}
	
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
	
	// 分页查询数据
	$scope.findPage = function (page,size) {
		$http.get('../brand/findPage.do?page='+page+'&size='+size+'').success(
			function (response) {
				$scope.paginationConf.totalItems = response.total ;
				$scope.list = response.rows;
			}		
		);
	}
	
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