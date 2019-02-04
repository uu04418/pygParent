package com.pinyougou.search.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.GroupOptions;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.GroupEntry;
import org.springframework.data.solr.core.query.result.GroupPage;
import org.springframework.data.solr.core.query.result.GroupResult;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.pinyougou.common.RedisCommonKey;
import com.pinyougou.common.Result;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.search.service.ItemSearchService;

@Service(timeout=10000)
@SuppressWarnings({"rawtypes","unchecked"})
public class ItemSearchServiceImpl implements ItemSearchService{
	
	@Autowired
	private TbItemMapper itemMapper;
    @Autowired
    private SolrTemplate solrTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
	
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

	
	/**查询结果列表**/
	public Map search(Map searchMap) {
		Map resutlMap = new HashMap<>();
		
		// 1- 查询基本数据
		Map contentList = searchItemList(searchMap);
		resutlMap.putAll(contentList);
		
		//2- 查询分组结果
		List<String> groupList = searchCategoryList(searchMap);
		resutlMap.put("categoryList", groupList);
		
		//3 查询品牌和规格列表
		String category = "";
		if (groupList.size() > 0) 
			category = groupList.get(0);
		if (!"".equals(searchMap.get("category"))) 
			category = (String) searchMap.get("category");
		if (!"".equals(category)) {
			Map map = searchBrandAndSpecList(category);
			resutlMap.putAll(map);
		}
		return resutlMap;
	}

	
	private Map searchBrandAndSpecList(String category) {
		Map map = new HashMap<>();
		
		Long  templeid = (Long)redisTemplate.boundHashOps(RedisCommonKey.ITEMCAT_HASH).get(category);
		if (templeid !=null) {
			// 查询品牌
			List brandList =(List) redisTemplate.boundHashOps(RedisCommonKey.BRAND_HASH).get(templeid);
			map.put("brandList", brandList);
			
			// 查询规格列表
			List specList =(List)  redisTemplate.boundHashOps(RedisCommonKey.SPEC_HASH).get(templeid);
			map.put("specList", specList);
		}
		
		
		return map;
	}


	// 查询分组结果
	private List searchCategoryList(Map searchMap) {
		List list = new ArrayList<>();
		Query query = new SimpleQuery("*:*");
		// 设置查询条件
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria );
		
		//1.1 关键字查询条件
		GroupOptions groupOptions = new GroupOptions().addGroupByField("item_category");
		query.setGroupOptions(groupOptions);
		
		
		
		// 执行查询取出查询结果
		GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query , TbItem.class);
		// 获取分组结果对象
		GroupResult<TbItem> groupResult = page.getGroupResult("item_category");
		// 获取分组入口项
		Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();
		// 获取集合
		List<GroupEntry<TbItem>> content = groupEntries.getContent();
		
		for (GroupEntry<TbItem> item : content) {
			list.add(item.getGroupValue());
		}
		return list;
	}


	private Map searchItemList(Map searchMap) {
		Map resutlMap = new HashMap<>();
		HighlightQuery query = new SimpleHighlightQuery();

		// 设置高亮点请求
		HighlightOptions highlightOptions = new HighlightOptions().addField("item_title");
		highlightOptions.setSimplePrefix("<em style='color:red'>"); //前缀
		highlightOptions.setSimplePostfix("</em>"); //后缀
		query.setHighlightOptions(highlightOptions);
		
		// 设置查询条件
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria );
		
		//1.2 品牌查询条件
		if (!"".equals(searchMap.get("brand"))) {
			FilterQuery fileterQuery = new SimpleFilterQuery();
			System.out.println("封装品牌点查询条件：" +  searchMap.get("brand"));
			Criteria filetercriteria = new Criteria("item_brand").is(searchMap.get("brand"));
			fileterQuery.addCriteria(filetercriteria);
			query.addFilterQuery(fileterQuery);
		}
		//1.2 分类查询条件
		if (!"".equals(searchMap.get("category"))) {
			FilterQuery fileterQuery = new SimpleFilterQuery();
			System.out.println("封装分类的查询条件:" + searchMap.get("category"));
			Criteria filetercriteria = new Criteria("item_category").is(searchMap.get("category"));
			fileterQuery.addCriteria(filetercriteria);
			query.addFilterQuery(fileterQuery);
		}
		// 规格参数
		if (searchMap.get("spec")!=null) {
			
			Map<String, String> specMap = (Map<String, String>)searchMap.get("spec");
			for(String key : specMap.keySet()) {
				FilterQuery fileterQuery = new SimpleFilterQuery();
				System.out.println("封装规格参数查询条件：" + key  + " " + specMap.get(key));
				Criteria filetercriteria = new Criteria("item_spec_"+key).is(specMap.get(key));
				fileterQuery.addCriteria(filetercriteria);
				query.addFilterQuery(fileterQuery);
			}
		}
				
		
		// 取出查询结果
		HighlightPage<TbItem> result = solrTemplate.queryForHighlightPage(query,TbItem.class);
		List<HighlightEntry<TbItem>> highlighted = result.getHighlighted();
		for (HighlightEntry<TbItem> entity : highlighted) {
			// 如果有高亮点结果
			if (entity.getHighlights().size() > 0
					&& entity.getHighlights().get(0).getSnipplets().size() > 0) {
				// 取出查询结果
				entity.getEntity().setTitle(entity.getHighlights().get(0).getSnipplets().get(0) );;
			}
			
		}
		
		// 设置返回页面点值
		resutlMap.put("rows", result.getContent());
		return resutlMap;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override  第一版本普通查询
	public Map search(Map searchMap) {
		Map resutlMap = new HashMap<>();
		Query query = new SimpleQuery("*:*");
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria );
		ScoredPage<TbItem> result = solrTemplate.queryForPage(query , TbItem.class);
		resutlMap.put("rows", result.getContent());
		resutlMap.put("count", result.getNumberOfElements());
		return resutlMap;
	}*/

}
