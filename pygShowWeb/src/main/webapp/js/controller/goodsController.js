 //控制层 
app.controller('goodsController' ,function($scope,$controller,$location ,goodsService 
		,uploadService,itemCatService,typeTemplateService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(){
		var id = $location.search()['id'];
		if (id == null) {return ;}
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
				editor.html(response.goodsDesc.introduction);
				$scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);
				$scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);
				$scope.entity.goodsDesc.specificationItems = JSON.parse($scope.entity.goodsDesc.specificationItems);
				for (var i=0;i<$scope.entity.itemList.length;i++) {
					$scope.entity.itemList[i].spec =  JSON.parse($scope.entity.itemList[i].spec);
				}
			}
		);				
	}
	
	//保存 
	$scope.save=function(){	
		$scope.entity.goodsDesc.introduction = editor.html();
		var serviceObject;//服务层对象  				
		if($scope.entity.goods.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	alert('新增成功');
		        	location.href = "goods.html";
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	$scope.uploadFile = function () {
		uploadService.uploadFile().success(
			function (response) {
				if (response.success) {
					$scope.image_entity.url = response.message;
				}else {
					alert(response.message);
				}
			}
		);
	}
	$scope.entity={ goodsDesc:{itemImages:[],specificationItems:[]} ,goods:{category3Id:''} };
	$scope.add_image_entity = function () {
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
	}
	
	//移除图片
	$scope.remove_image_entity=function(index){
		$scope.entity.goodsDesc.itemImages.splice(index,1);
	}
	
	//查询一级商品分类列表
	$scope.selectItemCat1List=function(){
		itemCatService.findByParentId(0).success(
			function(response){
				$scope.itemCat1List=response;			
			}
		);
		
	}
	
	//查询二级商品分类列表
	$scope.$watch('entity.goods.category1Id',function(newValue,oldValue){
		if (newValue != undefined) {
			itemCatService.findByParentId(newValue).success(
					function(response){
						$scope.itemCat2List=response;			
					}
			);
			
		}
		
		
	});
	
	//查询三级商品分类列表
	$scope.$watch('entity.goods.category2Id',function(newValue,oldValue){
		if (newValue != undefined) {
			itemCatService.findByParentId(newValue).success(
					function(response){
						$scope.itemCat3List=response;			
					}
			);
		}
	});
	

	
	//读取模板ID
	$scope.$watch('entity.goods.category3Id',function(newValue,oldValue){
		if(newValue == undefined) {return ;}
		itemCatService.findOne(newValue).success(
			function(response){
				$scope.entity.goods.typeTemplateId=response.typeId;
			}
		);		
	});
	

	//读取模板ID后，读取品牌列表 扩展属性  规格列表
	$scope.$watch('entity.goods.typeTemplateId',function(newValue,oldValue){
		if(newValue == undefined) {return ;}
		
		typeTemplateService.findOne(newValue).success(
			function(response){
				$scope.typeTemplate=response;// 模板对象 
								
				$scope.typeTemplate.brandIds= JSON.parse($scope.typeTemplate.brandIds);//品牌列表类型转换
				var id = $location.search()['id'];
				if (id !=null) {
					//扩展属性
					$scope.entity.goodsDesc.customAttributeItems= JSON.parse($scope.typeTemplate.customAttributeItems);
				}
				
			}
		);
		//读取规格
		typeTemplateService.findSpecList(newValue).success(
			function(response){
				$scope.specList=response;
			}
		);		
		
	});

	
	
	$scope.updateSpectAttribute = function  ($event,name,value) {
		
		// 先得到需要添加点集合
		var spectList = $scope.entity.goodsDesc.specificationItems;
		
		// 先获取obj
		var object = $scope.searchObjectByKey(spectList , 'attributeName' , name);
		
		if (object !=null) {
			// 如果点击点是确定
			if ($event.target.checked) {
				object.attributeValue.push(value);
			}else {
				//如果点击点是取消
				object.attributeValue.splice(object.attributeValue.indexOf(value ) ,1);
				//如果选项都取消了，将此条记录移除
				if(object.attributeValue.length==0){
					spectList.splice(spectList.indexOf(object),1);
				}
				
			}
		} else {
			spectList.push({"attributeName":name,"attributeValue":[value]});
		}
		
	}
	
	
	$scope.createItemList=function(){
		// 先拿到原来的集合然后遍历 进行克隆操作
		var items = $scope.entity.goodsDesc.specificationItems;
		$scope.entity.itemList=[{spec:{},price:0,num:99999,status:'0',isDefault:'0'} ];//列表初始化
		for (var i=0;i<items.length;i++) {
			// 进行深度克隆
			$scope.entity.itemList = addColumn($scope.entity.itemList , items[i].attributeName , items[i].attributeValue);
		}
	}
    
	addColumn =  function (list ,attributeName  , attributeValue ) {
		var newList = [];
		for (var i=0;i<list.length;i++) {
			// 先拿到初始化点集合
			var oldRow=  list[i];
			for (var j=0;j<attributeValue.length;j++) {
				var newRow=  JSON.parse( JSON.stringify(oldRow)  );//深克隆
				newRow.spec[attributeName]=attributeValue[j];
				newList.push(newRow);
			}
		}
		
		return newList ; 
	}
	
	$scope.status = ['未审核' ,'已审核' ,'审核通过' ,'驳回']
	
	$scope.itemCarList = [];
	
	$scope.finditmeCarList = function () {
		itemCatService.findAll().success (
			function (response) {
				for (var i=0;i<response.length;i++) {
					$scope.itemCarList[response[i].id] = response[i].name;
				}
			}
		)
	}
	// [{"attributeValue":["联通3G","联通2G"],"attributeName":"网络"},{"attributeValue":["16G","32G"],"attributeName":"机身内存"}]
	$scope.checkArrtibuteValue = function (attributeName ,attributeValue ) {
		var items = $scope.entity.goodsDesc.specificationItems ;
		var object = $scope.searchObjectByKey(items , 'attributeName' ,attributeName);
		if (object !=null) {
			if (object.attributeValue.indexOf(attributeValue)>=0) {
				return true ;
			}
		}
		return false;
	}
    
});	
