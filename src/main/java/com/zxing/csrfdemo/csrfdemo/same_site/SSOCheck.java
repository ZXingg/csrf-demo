package com.zxing.csrfdemo.csrfdemo.same_site;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOCheck {

    public static boolean checkLogin(String username,String password){
        return username.equals("user")&&password.equals("user");
    }

    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            for (Cookie cookie :
                    cookies) {
                if (cookie.getName().equals("ssocookie")
                        &&cookie.getValue().equals("sso")) {
                    return true;
                }
            }
        }
        return false;
    }
}
