package shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import pojo.Userinfo;
import service.IUserService;

/**
 * 自定义realm
 * @author yang
 */
@Component("MyRealm")
public class MyRealm extends AuthorizingRealm {

	@Resource
	private IUserService userService=null;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
		String username=usernamePasswordToken.getUsername();
		Userinfo userinfo=userService.getUserByUsername(username);
		if (userinfo==null) {
			return null;
		}
		String passwordFromDB=userinfo.getPassword();
		AuthenticationInfo info=new SimpleAuthenticationInfo(userinfo,passwordFromDB,this.getClass().getSimpleName());
		return info;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
}
