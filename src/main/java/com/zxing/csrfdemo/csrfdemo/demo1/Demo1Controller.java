package com.zxing.csrfdemo.csrfdemo.demo1;

import com.zxing.csrfdemo.csrfdemo.same_site.SSOCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class Demo1Controller {

    @RequestMapping("/demo1/main")
    public String main(HttpServletRequest request, Model model){
        if (SSOCheck.checkCookie(request))
            return "main1";

        model.addAttribute("gotoUrl","/demo1/main");
        return "login";
    }
}
