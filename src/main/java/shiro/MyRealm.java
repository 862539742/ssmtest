package shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import pojo.SysUser;
import service.SysUserService;

/**
 * 自定义realm
 * @author yang
 */
@Component("MyRealm")
public class MyRealm extends AuthorizingRealm {

	@Resource
	private SysUserService sysUserService=null;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
		String userName=usernamePasswordToken.getUsername();
		SysUser user=sysUserService.selectByPrimaryUserName(userName);
		if (user==null) {
			return null;
		}
		String passwordFromDB=user.getUserPass();
		AuthenticationInfo info=new SimpleAuthenticationInfo(user,passwordFromDB,this.getClass().getSimpleName());
		return info;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
}
