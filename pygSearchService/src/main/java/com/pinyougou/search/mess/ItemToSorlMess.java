package com.pinyougou.search.mess;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;

public class ItemToSorlMess implements MessageListener {

	@Autowired
	private ItemSearchService itemSearchService;
	



	@Override
	public void onMessage(Message message) {
		TextMessage textMessage =  (TextMessage) message;
		try {
			String sendData = textMessage.getText();
			System.out.println("=================导入索引库收到消息体=================" );
			System.out.println(sendData);
			List<TbItem> itemList = JSON.parseArray(sendData, TbItem.class);
			itemSearchService.importItemList(itemList);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
