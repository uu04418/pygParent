package com.pinyougou.sellergoods.service;

import java.util.List;

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

}
