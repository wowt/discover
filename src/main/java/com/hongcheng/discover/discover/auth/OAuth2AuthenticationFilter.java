package com.hongcheng.discover.discover.auth;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class OAuth2AuthenticationFilter extends AuthenticatingFilter {

    private static final Logger log = LoggerFactory.getLogger(OAuth2AuthenticationFilter.class);

    private String authHeader = "Authorization";

    private String failureUrl="/failure";

    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        log.info("create token.");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        return new OAuth2Token(((HttpServletRequest) request).getHeader(authHeader));
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String error = request.getParameter("error");
        String errorDescription = request.getParameter("error_description");
        if (!StringUtils.isEmpty(error)) {
            // 如果服务端返回了错误
            WebUtils.issueRedirect(request, response, failureUrl + "?error=" + error + "error_description=" + errorDescription);
            return false;
        }

        Subject subject = getSubject(request,response);
        if (!subject.isAuthenticated()) {
            if (StringUtils.isEmpty(request.getParameter(authHeader))) {
                // 如果用户没有身份验证，且没有Authorization，则重定向到服务端授权
                log.info("redirect to login");
                redirectToLogin(request, response);
                return false;
            }
        }

        log.info("login successful.");
        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        log.info("redirect to success url");
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        httpServletRequest.getSession().setAttribute("uid",subject.getPrincipal());
        WebUtils.issueRedirect(request, response, getSuccessUrl());
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest request,
                                     ServletResponse response) {
        log.info("login failed");
        Subject subject = getSubject(request, response);
        if (subject.isAuthenticated() || subject.isRemembered()) {
            try {
                log.info("redirect to success url");
                issueSuccessRedirect(request, response);
            } catch (Exception e) {
                log.error("fail to redirect", e);
            }
        } else {
            try {
                log.info("redirect to failure url");
                WebUtils.issueRedirect(request, response, failureUrl);
            } catch (IOException e) {
                log.error("fail to redirect", e);
            }
        }
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }
}
