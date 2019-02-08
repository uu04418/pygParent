package com.pinyougou.cart.service;

import java.util.List;

import com.pinyougou.datapojo.Cart;

public interface CartService {
	
	public List<Cart> addGoodsToCart(List<Cart> cartList , Long itemId , Integer num);
	
	public List<Cart> addGoosToCarrRedis(List<Cart> cartList , String username);
	
	public List<Cart> findCartListFromRedis(String username);
	
	public List<Cart> megireCarList(List<Cart> cookieList , List<Cart> redisList);


}
