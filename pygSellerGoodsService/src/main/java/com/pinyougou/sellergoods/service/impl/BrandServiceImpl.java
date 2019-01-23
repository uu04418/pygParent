package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.common.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private TbBrandMapper brandMapper;
	
	public List<TbBrand> getAll() {
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNub, int pageSize) {
		PageHelper.startPage(pageNub, pageSize);
		Page<TbBrand> brandList =(Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(brandList.getTotal(), brandList.getResult());
	}

}
