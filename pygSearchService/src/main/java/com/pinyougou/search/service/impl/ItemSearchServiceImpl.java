package com.pinyougou.search.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.pinyougou.common.Result;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.search.service.ItemSearchService;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class ItemSearchServiceImpl implements ItemSearchService{
	
	@Autowired
	private TbItemMapper itemMapper;
    @Autowired
    private SolrTemplate solrTemplate;
	
	@Override
	public Result addAllItemToSolr() {
		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("1");
		List<TbItem> itemList = itemMapper.selectByExample(example);
		
		for(TbItem item:itemList){
			System.out.println(item.getId()+" "+ item.getTitle()+ " "+item.getPrice());	
			Map specMap = JSON.parseObject(item.getSpec(), Map.class);//从数据库中提取规格json字符串转换为map
			item.setSpecMap(specMap);
		}
		System.out.println(itemList.size());
		solrTemplate.saveBeans(itemList);
		solrTemplate.commit();
		
		return new Result(true, "成功");
	}

	
	
	@Override
	public Map search(Map searchMap) {
		Map resutlMap = new HashMap<>();
		Query query = new SimpleQuery("*:*");
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria );
		ScoredPage<TbItem> result = solrTemplate.queryForPage(query , TbItem.class);
		resutlMap.put("rows", result.getContent());
		resutlMap.put("count", result.getNumberOfElements());
		return resutlMap;
	}

}
