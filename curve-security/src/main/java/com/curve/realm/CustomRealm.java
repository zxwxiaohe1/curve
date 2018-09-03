package com.curve.realm;

import com.curve.modules.comm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:继承认证授权类
 */
public class CustomRealm extends AuthorizingRealm {

	// 注入service
	@Autowired
	private UserService userService;// 用户服务
	@Autowired
	private HttpServletRequest request;
//	@Autowired
//	private HttpServletResponse response;

	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	/**
	 * Description: realm的认证方法，从数据库查询用户信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		return null;
	}

	/**
	 * Description: 用于授权，从数据库查询用户权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}

	// 清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject()
				.getPrincipals();
		super.clearCache(principals);
	}
}
