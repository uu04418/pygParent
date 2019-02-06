package com.pinyougou.search.mess;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.pinyougou.search.service.ItemSearchService;

public class ItemDeleteSorlMess implements MessageListener {

	
	@Autowired
	private ItemSearchService itemSearchService;
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			String sendData = textMessage.getText();
			System.out.println("==============删除商品收到消息======================");
			System.out.println(sendData);
			List<Long> parseArray = JSON.parseArray(sendData, Long.class);
			itemSearchService.deleteByGoodsId(parseArray);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
