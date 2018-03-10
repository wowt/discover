package com.hongcheng.discover.discover.auth;


import org.apache.shiro.authc.AuthenticationException;

/**
 * OAuth Exception
 */
public class OAuth2AuthenticationException extends AuthenticationException {
    public OAuth2AuthenticationException(Throwable cause) {
        super(cause);
    }
}
