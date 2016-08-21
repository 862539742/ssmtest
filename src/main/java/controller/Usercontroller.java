package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationHandler;
import org.apache.shiro.crypto.CipherService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Userinfo;

import com.alibaba.fastjson.JSON;

import service.IUserService;

@Controller
public class Usercontroller{
	@Resource
	private IUserService userService = null;
	@RequestMapping("/user.action")
	public void test(HttpServletResponse response,String id) throws IOException{
		Userinfo userinfo=userService.getUserById(id);
		if (userinfo==null) {
			response.getWriter().append("{\"result\":\"false\"}");
		}else {
			response.getWriter().append(JSON.toJSONString(userinfo));
		}
	}
	@RequestMapping(value="/loginCheck.action",method=RequestMethod.POST)
	public void loginCheck(String username,String password){
		Subject subject=SecurityUtils.getSubject();
		AuthenticationToken token=new UsernamePasswordToken(username,password);
		System.out.println("========================================");
        System.out.println("1、进入认证方法");
		subject.login(token);
		Userinfo userinfo=(Userinfo)subject.getPrincipal();
	}
	@RequestMapping("/main.action")
	public String index(){
		return "index";
	}
	@RequestMapping("/userByUsername.action")
	public void userByUsername(HttpServletResponse response,String userName) throws IOException{
		Userinfo userinfo=userService.getUserByUsername(userName);
		response.getWriter().append(JSON.toJSONString(userinfo));
	}
}	
