package com.pinyougou.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.common.CookieUtils;
import com.pinyougou.common.Result;
import com.pinyougou.datapojo.Cart;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private HttpServletRequest request;
	
	
	@Autowired
	private HttpServletResponse response;
	
	@Reference
	private CartService cartService;
	
	
	@RequestMapping("/addGoodsToCart")
	public Result addGoodsToCart( Long itemId , Integer num){
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
				
		
		try {
			List<Cart> cartList = findCartList();
			cartList = cartService.addGoodsToCart(cartList, itemId, num);
			if ("anonymousUser".equals(username)) {
				String json =JSON.toJSONString(cartList);
				CookieUtils.setCookie(request, response, "cartList",
						json, 3600 * 24, "UTF-8");
			}else {
				cartService.addGoosToCarrRedis(cartList, username);
			}
			
			
			
			
			return new Result(true,"添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"添加失败");
		}
	};
	
	@RequestMapping("/findCartList")
	public List<Cart> findCartList() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("登录用户：" + username);
		String json = CookieUtils.getCookieValue(request, "cartList", "UTF-8");
		if (json == null || "".equals(json)) 
			json = "[]";
		List<Cart> cookieList = JSON.parseArray(json, Cart.class);
		if ("anonymousUser".equals(username)) {
			return cookieList ;
		}else {
			List<Cart> redisList = cartService.findCartListFromRedis(username);
			redisList = cartService.megireCarList(cookieList, redisList);
			cartService.addGoosToCarrRedis(redisList, username);
			CookieUtils.setCookie(request, response, "cartList",
					json, 0, "UTF-8");
			return redisList;
		}
		
		
		
	}
}
