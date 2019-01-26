package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.PageResult;
import com.pinyougou.common.Result;
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
	
	// 分页查询品牌
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult getAll(int page ,int rows){
		return brandService.findPage(page, rows);
	}
	
	// 新增品牌
	@RequestMapping("/add")
	@ResponseBody
	public Result add (@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			return new Result(false, "操作失败");
		}
		
	}
	
	// 查询一个品牌
	@ResponseBody
	@RequestMapping("/findOne")
	public TbBrand findOne (Long id) {
		return brandService.findOne(id);
	}
	
	
	// 编辑品牌
	@RequestMapping("/update")
	@ResponseBody
	public Result update (@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			return new Result(false, "操作失败");
		}
		
	}
	
	// 删除品牌
	@RequestMapping("/delete")
	@ResponseBody
	public Result deleteBrand (Long [] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			return new Result(false, "操作失败");
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search (@RequestBody TbBrand brand ,
			int page ,int rows	) {
		return brandService.findPage(brand, page, rows);
	}
	
	
	@ResponseBody
	@RequestMapping("/selectOptionList")
	public List<Map<String, Object>>  selectOptionList () {
		return brandService.selectOptionList();
	}
	
	

	
}
