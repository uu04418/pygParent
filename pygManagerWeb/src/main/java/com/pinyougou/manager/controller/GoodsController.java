package com.pinyougou.manager.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.pinyougou.common.ActiveMqSendMess;
import com.pinyougou.common.PageResult;
import com.pinyougou.common.Result;
import com.pinyougou.datapojo.Goods;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbItem;
//import com.pinyougou.search.service.ItemSearchService;
import com.pinyougou.sellergoods.service.GoodsService;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination itemToSorl;
	@Resource
	private Destination itemDeleteSorl;
	@Resource
	private Destination gentHtml;
	@Resource
	private Destination gentHtmlDelete;
	
	
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return goodsService.findPage(page, rows);
	}
	
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Goods goods){
		try {
			goodsService.update(goods);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Goods findOne(Long id){
		return goodsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			goodsService.delete(ids);
			System.out.println("======================删除商品发送消息====================");
			String sendData = JSON.toJSONString(ids);
			ActiveMqSendMess.sendData(jmsTemplate,itemDeleteSorl , sendData);
			ActiveMqSendMess.sendData(jmsTemplate,gentHtmlDelete , sendData);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		goods.setIsDelete("0"); // 没有删除的
		return goodsService.findPage(goods, page, rows);		
	}
	
	/**审核商品**/
	@RequestMapping("/updateStatus")
	public Result updateStatus (Long [] ids ,String status) {
		
		if("1".equals(status)){//如果是审核通过 
			//得到需要导入的SKU列表
			List<TbItem> itemList = goodsService.searchItemListByGoodIdAndState(ids, status);
			//导入到solr
			//searchService.importItemList(itemList);	
			String sendData = JSON.toJSONString(itemList);
			System.out.println("============审核商品发送导入索引库的消息===============================");
			ActiveMqSendMess.sendData(jmsTemplate, itemToSorl, sendData);
			sendData = JSON.toJSONString(ids);
			ActiveMqSendMess.sendData(jmsTemplate, gentHtml, sendData);
		}		
		
		return goodsService.updateStatus(ids ,status);
	}
	
	
}
