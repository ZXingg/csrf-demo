package com.zxing.csrfdemo.csrfdemo.demo2;

import com.zxing.csrfdemo.csrfdemo.same_site.SSOCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Demo2Controller {

    @RequestMapping("/demo2/main")
    public String main(HttpServletRequest request, Model model){
        if (SSOCheck.checkCookie(request))
            return "main2";

        model.addAttribute("gotoUrl","/demo2/main");
        return "login";
    }
}
