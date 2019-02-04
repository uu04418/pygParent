package com.pinyougou.search.service;

import java.util.Map;

import com.pinyougou.common.Result;

public interface ItemSearchService {
	
	/**一键导入索引**/
	Result addAllItemToSolr();
	
	/**根据条件查询商品**/
	Map search(Map searchMap);

}
