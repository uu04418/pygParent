package com.pinyougou.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/name")
	public Map<String, Object> loginName () {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, Object> map = new HashMap<>();
		map.put("loginName", name);
		return map;
	}
}
