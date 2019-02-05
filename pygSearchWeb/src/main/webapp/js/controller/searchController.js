app.controller('searchController',function($scope,$location,searchService){
	
	$scope.searchMap = {'category':'','brand':'','spec':{} ,
			'price':'' ,'pageNub':1,'pageSize':10 ,'orderField':'','orderValue':''};
	
	//搜索
	$scope.search=function(){
		searchService.search($scope.searchMap).success(
			function(response){
				$scope.resultMap=response;	
				$scope.buildPageLabel();
			}
		);		
	}
	
	$scope.buildPageLabel = function () {
		$scope.pageLabel = [];
		var first = 1;
		var last = $scope.resultMap.totalPages;
		
		// 如果总页码大于 5
		if ($scope.resultMap.totalPages > 5) {
			
			// 如果是前面的五页
			if ($scope.searchMap.pageNub <3) {
				last = 5;
			}
			// 如果是后面5页
			else if ($scope.searchMap.pageNub > $scope.resultMap.totalPages-2) {
				first =  $scope.resultMap.totalPages - 4 ;
			}
			else {
				first = $scope.searchMap.pageNub - 2;
				last =  $scope.searchMap.pageNub  + 2;
			}
			
		}
		
		
		for (var i=first;i<=last;i++) {
			$scope.pageLabel.push(i);
		}
	}
	
	$scope.queryByPage=function (pageNub) {
		$scope.searchMap.pageNub = pageNub;
		$scope.search();
	}
	
	$scope.addSearchItem = function (key ,value) {
		if (key == 'category' || key == 'brand' || key =='price') {
			$scope.searchMap[key] = value;
		}else {
			$scope.searchMap.spec[key]=value;
		}
		$scope.search();
	};
	
	$scope.removeSearchItem = function (key) {
		if (key == 'category' || key == 'brand' || key=='price') {
			$scope.searchMap[key] = '';
		}else {
			delete $scope.searchMap.spec[key];
		}
		$scope.search();
	};
	
	$scope.sortQuery = function (orderField , orderValue) {
		$scope.searchMap.pageNub = 1;
		$scope.searchMap.orderField = orderField;
		$scope.searchMap.orderValue = orderValue;
		$scope.search();
	}
	
	// 判断keywords 是否是品牌开头
	$scope.checkIsBrandSearch= function () {
		// 得到品牌
		var list = $scope.resultMap.brandList;
		for (var i = 0;i<list.length;i++) {
			if ($scope.searchMap.keywords.startsWith(list[i].text)) {
				return true ;
			}
		}
		return false;
	}
	
	$scope.loadSearch =  function  () {
		$scope.searchMap.keywords = $location.search()['keywords'];
		$scope.search();
	}
	
	
});