 //控制层 
app.controller('cartController' ,function($scope,$controller,cartService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findCartList=function(){
		cartService.findCartList().success(
			function(response){
				$scope.itemList=response;
				sum();
			}			
		);
	}   
	
	 //读取列表数据绑定到表单中  
	$scope.addGoodsToCart=function(itemId , num){
		cartService.addGoodsToCart(itemId,num).success(
			function(response){
				if (response) {
					$scope.findCartList();
				}else {
					alert(response.message);
				}
			}			
		);
	}    
	
	sum = function () {
		$scope.totalNum = 0;
		$scope.totalMonery = 0;
		var cart = $scope.itemList;
		for (var i=0;i<cart.length;i++) {
			var item = cart[i].orderItemList;
			for(var n = 0;n<item.length;n++){
				$scope.totalNum +=item[n].num;
				$scope.totalMonery +=item[n].totalFee;
			}
		}
		
	}
	
	
});	
