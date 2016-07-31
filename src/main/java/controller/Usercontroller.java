package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import service.IUserService;

@Controller
public class Usercontroller{
	@Resource
	private IUserService userService = null;
	@RequestMapping("/user.action")
	public void test(HttpServletResponse response,String id) throws IOException{
		response.getWriter().append(JSON.toJSONString(userService.getUserById(id)));
	}
}	
