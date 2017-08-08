package com.work4j.space.controller.admin;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.User;
import com.work4j.space.service.UserService;

@Controller
public class AdminLoginController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login/login";
    }

 /*   @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password) {
        ModelAndView mav = new ModelAndView("login/loginResult");
        User user = userService.login(username, password);
        if (user != null) {
            SystemHelper.setCurrentUser(user);
            mav.setViewName("redirect:index");
        } else {
            mav.addObject("result", false);
        }
        return mav;
    }*/

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
