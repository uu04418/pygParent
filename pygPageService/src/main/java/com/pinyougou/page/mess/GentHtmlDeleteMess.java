package com.pinyougou.page.mess;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import pygPageInterface.ItemPageService;

public class GentHtmlDeleteMess implements MessageListener{
	
	@Autowired
	private ItemPageService itemPageService;

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		try {
			String sendData = textMessage.getText();
			System.out.println("=================删除静态页面收到点消息================");
			System.out.println(sendData);
			List<Long> parseArray = JSON.parseArray(sendData, Long.class);
			for (Long goodsId : parseArray) {
				itemPageService.gentHtmlDelete(goodsId);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
