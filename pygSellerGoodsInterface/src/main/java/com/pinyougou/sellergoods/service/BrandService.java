package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.common.PageResult;
import com.pinyougou.pojo.TbBrand;

/**
 * 品牌service
 * **/
public interface BrandService {
	
	/**
	 * 查询所有点品牌
	 * **/
	public List<TbBrand> getAll () ;
	
	/**分页查询品牌
	 * @param pageNub : 当前页码
	 * @param pageSize : 每页数量
	 * **/
	public PageResult findPage(int pageNub ,int pageSize);
	
	
	/**分页查询品牌带条件
	 * @param pageNub : 当前页码
	 * @param pageSize : 每页数量
	 * **/
	public PageResult findPage(TbBrand brand,int pageNub ,int pageSize);
	
	
	/**
	 * 新增品牌
	 * **/
	public void add (TbBrand brand);
	
	/**
	 * 查询一个品牌
	 * **/
	public TbBrand findOne (Long id);
	
	/**
	 * 编辑品牌
	 * **/
	public void update (TbBrand brand);
	
	/**删除品牌**/
	public void delete (Long [] ids);

	public  List<Map<String, Object>>  selectOptionList();
}
