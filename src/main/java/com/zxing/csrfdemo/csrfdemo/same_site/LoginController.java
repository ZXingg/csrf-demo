package com.zxing.csrfdemo.csrfdemo.same_site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
public class LoginController {

    @RequestMapping("/check")
    public void login(HttpServletResponse response,@PathParam("username") String username
            ,@PathParam("password") String password,@PathParam("gotoUrl") String gotoUrl){
        if (SSOCheck.checkLogin(username, password)){
            Cookie cookie=new Cookie("ssocookie","sso");
            cookie.setPath("/");//设置到顶层域
            response.addCookie(cookie);
        }

        try{
            response.sendRedirect(gotoUrl!=null&&gotoUrl!=""?gotoUrl:"/demo1/main");//默认1
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
