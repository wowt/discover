package com.hongcheng.discover.discover.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * OAuth 2.0 Token
 *
 * @author wilsonwan
 */
public class OAuth2Token implements AuthenticationToken {

    private String authCode;

    public OAuth2Token(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public Object getPrincipal() {
        return authCode;
    }

    @Override
    public Object getCredentials() {
        return authCode;
    }
}
