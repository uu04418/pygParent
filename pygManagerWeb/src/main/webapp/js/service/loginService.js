//服务层
app.service('loginService',function($http){
	    	
	//显示登录用户名称
	this.loginName=function(){
		return $http.get('../login/name.do');		
	}
	
});
