package com.spartan.front.admin.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.spartan.front.admin.constant.RedisConstant;
import com.spartan.front.admin.utils.CookieUtil;
import com.spartan.front.admin.utils.ResultVOUtil;
import com.spartan.front.admin.vo.ResultVO;
import com.front.operator.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApiController {
	
	private String TOKEN = "Admin-Token";

	@GetMapping("/login")
    public ResultVO<Map<String,String>> login(String username, String password, HttpServletResponse response){
		System.out.println(username);
		System.err.println(password);
		String token = UUID.randomUUID().toString();
		//3. 将token写入cookie
        CookieUtil.set(response, TOKEN, token, RedisConstant.EXPIRE);
        String role[] = {"admin"};
        User user = new User(role, "admin", "我是超级管理员", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif", "Super Admin");
        return ResultVOUtil.success(user);
    }
	
	@GetMapping("/userInfo")
    public ResultVO<Map<String,String>> getUserInfo(String token){
		System.out.println(token);
		String role[] = {"admin"};
		User user = new User(role, "admin", "我是超级管理员", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif", "Super Admin");
//		String user = "{ role: ['admin'], token: 'admin', introduction: '我是超级管理员', avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', name: 'Super Admin' }";
        return ResultVOUtil.success(user);
    }
	
}
