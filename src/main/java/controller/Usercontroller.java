package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.SysUser;

import com.alibaba.fastjson.JSON;

import service.SysUserService;

@Controller
public class Usercontroller{
	@Resource
	private SysUserService sysUserService = null;
	
	@ResponseBody
	@RequestMapping(value="/user.action",method=RequestMethod.GET)
	public SysUser test(HttpServletResponse response,int id) throws IOException{
		SysUser user=sysUserService.selectByPrimaryKey(id);
		if (user==null) {
			response.getWriter().append("{\"result\":\"false\"}");
			return null;
		}else {
//			response.getWriter().append(JSON.toJSONString(userinfo));
			return user;
		}
	}
	/**
	 * 用户登录检验
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value="/loginCheck.action",method=RequestMethod.POST)
	public String loginCheck(String username,String password){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		System.out.println("========================================");
        System.out.println("1、进入认证方法");
        try {
        	subject.login(token);
        	return "index";
		}catch(UnknownAccountException uae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            return "123";
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
        } catch (Exception e) {
		}
        if (subject.isAuthenticated()) {
        	System.out.println("dd");
		}else {
        	token.clear();
		}
        return "123";
//		Userinfo userinfo=(Userinfo)subject.getPrincipal();
	}
	@RequestMapping("/main.action")
	public String index(){
		return "index";
	}
	@RequestMapping("/userByUsername.action")
	public void userByUsername(HttpServletResponse response,String userName) throws IOException{
		SysUser user=sysUserService.selectByPrimaryUserName(userName);
		response.getWriter().append(JSON.toJSONString(user));
	}
	@RequestMapping("/loginOut.action")
	public void loginOut(HttpServletResponse response) throws IOException{
		 SecurityUtils.getSubject().logout();  
		 response.setCharacterEncoding("UTF-8");
		response.getWriter().append("{\"result\":\"true\",\"message\":\"退出成功\"}");
	}
}	
