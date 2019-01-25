
app.service("brandService",function ($http) {
		this.findall = function () {
			return $http.get('../brand/getAll.do');
		}
		
		this.search = function (page,size,search) {
			return $http.post('../brand/search.do?page='+page+'&size='+size,search);
		}
		
		this.findOne = function (id) {
			return $http.get('../brand/findOne.do?id=' +id);
		}
		
		this.deletebrand = function (ids) {
			return $http.get('../brand/delete.do?ids=' +ids);
		}
		
		this.add = function (entity) {
			return $http.post('../brand/add.do' , entity);
		}
		this.update = function (entity) {
			return $http.post('../brand/update.do' , entity);
		}
			
});