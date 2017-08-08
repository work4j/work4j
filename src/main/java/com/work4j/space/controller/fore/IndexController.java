package com.work4j.space.controller.fore;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.User;
import com.work4j.space.pojo.form.UserForm;
import com.work4j.space.pojo.query.UserQuery;
import com.work4j.space.service.ArticleService;
import com.work4j.space.service.UserService;

@Controller
public class IndexController {
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;

    @RequestMapping("/index")
    public String toIndex() {
        return "redirect:/fore/article/list";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login/login";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "login/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(UserForm form) {
        ModelAndView mav = new ModelAndView("login/login");
        userService.add(form);
        mav.addObject("msg", "注册成功");
        return mav;
    }
    
    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkUsername(String username) {
        UserQuery query = new UserQuery();
        query.setUserName(username);
        return userService.find(query).size() > 0;
    }

    @RequestMapping("/logout")
    public String toLogout() {
        SystemHelper.getSession().removeAttribute("currentUser");
        return "redirect:/fore/article/articleList";
    }

    @RequestMapping("/noPermission")
    public String noPermission() {
        return "noPermission";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String userName, String password) {
        ModelAndView mav = new ModelAndView("login/login");
        User user = userService.get(userName);
        if (user != null) {
            SystemHelper.setCurrentUser(user);
            mav.setViewName("redirect:index");
        } else {
            mav.addObject("msg", "密码错误");
        }
        return mav;
    }
}
