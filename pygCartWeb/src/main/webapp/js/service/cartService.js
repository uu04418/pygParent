//服务层
app.service('cartService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findCartList=function(){
		return $http.get('cart/findCartList.do');		
	}
	
	
	//添加购物车
	this.addGoodsToCart=function(itemId , num){
		return $http.get('cart/addGoodsToCart.do?itemId='+itemId +"&num="+num);		
	}
	
});
