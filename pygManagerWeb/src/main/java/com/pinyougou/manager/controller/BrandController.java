package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.PageResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<TbBrand> getAll(){
		return brandService.getAll();
	}
	
	
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult getAll(int page ,int size){
		return brandService.findPage(page, size);
	}
	
	

	
}
