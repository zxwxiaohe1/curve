package com.curve.interceptor;

/**
 *
 */
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

/**
 * 自定义WEB会话管理类
 * 
 * @author heyong
 * @version 2018-8-20
 */

public class SessionManager extends DefaultWebSessionManager {
	public static boolean clear = false;
	public long loginOutValidateTime = 0;
	public long sessionvalidateTime = 0;
    @Override
	public void validateSessions() {
		if (clear) {
			super.setGlobalSessionTimeout(loginOutValidateTime);
		} else {
			super.setGlobalSessionTimeout(sessionvalidateTime);
		}

	}

	public long getLoginOutValidateTime() {
		return loginOutValidateTime;
	}

	public void setLoginOutValidateTime(long loginOutValidateTime) {
		this.loginOutValidateTime = loginOutValidateTime;
	}

	public long getSessionvalidateTime() {
		return sessionvalidateTime;
	}

	public void setSessionvalidateTime(long sessionvalidateTime) {
		this.sessionvalidateTime = sessionvalidateTime;
	}

}