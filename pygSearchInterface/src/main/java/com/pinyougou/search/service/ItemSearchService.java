package com.pinyougou.search.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.common.Result;
import com.pinyougou.pojo.TbItem;

public interface ItemSearchService {
	
	/**一键导入索引**/
	Result addAllItemToSolr();
	
	/**根据条件查询商品**/
	Map search(Map searchMap);
	
	void deleteByGoodsId(List goodIds) ;
	
	void importItemList(List<TbItem> itemList) ;

}
