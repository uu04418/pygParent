package com.pinyougou.cart.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.common.RedisCommonKey;
import com.pinyougou.datapojo.Cart;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbOrderItem;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	/**添加商品到购物车**/
	public List<Cart> addGoodsToCart(List<Cart> cartList, Long itemId, Integer num) {
		// 1 根据商品id查询
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		if (item == null) 
			throw new RuntimeException("找不到该商品");
		if (!"1".equals(item.getStatus())) 
			throw new RuntimeException("商品下架");
		
		//2 获得商家信息
		String sellerId = item.getSellerId();
		String sellerName = item.getSeller();
		// 3 判断该商品在购物车中是否存在
		Cart cart = searchCarBySellerId(cartList , sellerId);
		if (cart == null) {
			// 4 如果购物车中没有该商家信息
			cart = new Cart();
			cart.setSellerId(sellerId);
			cart.setSellerName(sellerName);
			
			// 创建购物车集合
			List<TbOrderItem> orderItemList = new ArrayList<>();
			// 把商品添加到购物车集合
			TbOrderItem orderItem = createOrderItem(item , num);
			orderItemList.add(orderItem);
			cart.setOrderItemList(orderItemList);
			cartList.add(cart);
			
		}else {
			// 如果购物车有商家id
			TbOrderItem orderItem = searchOrderItemByItemId(cart.getOrderItemList() , itemId);
			// 如果购物车不存在该商品
			if (orderItem == null) {
				orderItem = createOrderItem(item , num);
				cart.getOrderItemList().add(orderItem);	
			}else {
				// 如果商品存在数量相加价格相加
				orderItem.setNum(orderItem.getNum() + num);
				orderItem.setTotalFee(new BigDecimal(orderItem.getPrice().doubleValue() * orderItem.getNum()));
			}
		    // 如果商品数量小于0 移除当前商品
		    if (orderItem.getNum() <=0) {
		    	cart.getOrderItemList().remove(orderItem);
		    }
		    // 当购物车明细小于0
		    if (cart.getOrderItemList().size() <=0) {
		    	cartList.remove(cart);
		    }
		}
		
		return cartList;
		
	}

	/**从购物车判断商品是否存在**/
	private TbOrderItem searchOrderItemByItemId(List<TbOrderItem> orderItemList, Long itemId) {
		for (TbOrderItem item : orderItemList) {
			if (item.getItemId().longValue() == itemId.longValue()) 
				return item;
		}
		return null;
	}

	/**把商品添加到购物车**/
	private TbOrderItem createOrderItem(TbItem item, Integer num) {
		TbOrderItem orderItem = new TbOrderItem();
		orderItem.setItemId(item.getId());
		orderItem.setPrice(item.getPrice());
		orderItem.setPicPath(item.getImage());
		orderItem.setTitle(item.getTitle());
		orderItem.setTotalFee(new BigDecimal(item.getPrice().doubleValue() * num));
		orderItem.setNum(num);
		return orderItem;
	}

	/**
	 * 判断该商家中购物车中是否存在
	 * **/
	private Cart searchCarBySellerId(List<Cart> cartList, String sellerId) {
		for (Cart cart: cartList) {
			if (cart.getSellerId().equals(sellerId)) 
				return cart;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> addGoosToCarrRedis(List<Cart> cartList, String username) {
		redisTemplate.boundHashOps(RedisCommonKey.MYCART_SHASH).put(username, cartList);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> findCartListFromRedis(String username) {
		List<Cart> carts = (List<Cart>)redisTemplate.boundHashOps(RedisCommonKey.MYCART_SHASH).get(username);
		
		if (carts == null ) {
			return new ArrayList<>();
		}
		return carts;
	}

	@Override
	public List<Cart> megireCarList(List<Cart> cookieList, List<Cart> redisList) {
		for (Cart cart: cookieList) {
			for ( TbOrderItem item : cart.getOrderItemList()) {
				 addGoodsToCart(redisList, item.getItemId(), item.getNum()) ;
			}
		}
		
		return redisList;
	}

}
