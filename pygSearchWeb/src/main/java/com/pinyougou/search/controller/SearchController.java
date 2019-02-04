package com.pinyougou.search.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.Result;
import com.pinyougou.search.service.ItemSearchService;

@RestController
@RequestMapping("/itemSearch")
public class SearchController {

	@Reference
	private ItemSearchService itemSearchService;
	
	@RequestMapping("/importAll")
	public Result importAll() {
		return itemSearchService.addAllItemToSolr();
	}
	
	/**根据条件查询商品**/
	@RequestMapping("/search")
	public Map search (@RequestBody Map searchMap) {
		return itemSearchService.search(searchMap);
	}
}
