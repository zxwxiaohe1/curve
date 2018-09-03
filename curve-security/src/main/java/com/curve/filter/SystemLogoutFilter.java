package com.curve.filter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.curve.interceptor.SessionManager;
import com.curve.realm.CustomRealm;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
public class SystemLogoutFilter extends LogoutFilter {
    @Autowired
    private CustomRealm customRealm;
    @Autowired
    private HttpServletRequest requests;
    @Autowired
    private SessionManager sessionManager;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response)
            throws Exception {
        // 在这里执行退出系统前需要清空的数据
        Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
        try {
            sessionManager.clear = true;
            sessionManager.validateSessions();
            subject.logout();
        } catch (SessionException ise) {
            ise.printStackTrace();

        }

        issueRedirect(request, response, redirectUrl);

        // 返回false表示不执行后续的过滤器，直接返回跳转到登录页面

        return false;

    }
}

