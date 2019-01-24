package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.common.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
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

	@Override
	public void add(TbBrand brand) {
		 brandMapper.insertSelective(brand);
	}

	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKeySelective(brand);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbBrand brand, int pageNub, int pageSize) {
		PageHelper.startPage(pageNub, pageSize);
		TbBrandExample example = new TbBrandExample();
		TbBrandExample.Criteria criteria = example.createCriteria();
		if (brand !=null) {
			if (brand.getName() !=null && brand.getName().length() > 0) 
				criteria.andNameLike("%"+brand.getName()+"%");
			if (brand.getFirstChar() !=null && brand.getFirstChar().length()> 0) 
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
		}
		Page<TbBrand> brandList =(Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(brandList.getTotal(), brandList.getResult());
	}

}
