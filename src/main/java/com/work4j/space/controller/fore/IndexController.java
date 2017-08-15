package com.work4j.space.controller.fore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
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

import java.util.List;
import java.util.Random;

@Controller
public class IndexController {
    @Value("${file.headpath}")
    private String headpath;
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
        System.out.println(headpath);
        return "login/login";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "login/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(UserForm form) {
        ModelAndView mav = new ModelAndView("login/login");
        form.setHead(headpath + new Random().nextInt(12) + ".jpg");
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
        return "redirect:/fore/article/list";
    }

    @RequestMapping("/404")
    public String error() {
        return "error_404";
    }

    @RequestMapping("/noPermission")
    public String noPermission() {
        return "noPermission";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, final UserQuery query) {
        ModelAndView mav = new ModelAndView("login/login");
        List<User> user = userService.find(query);
        if (user.size() > 0) {
            SystemHelper.setCurrentUser(user.get(0));
            String referer = request.getHeader("referer");
            if (referer.contains("redirect")) {
                String url = referer.substring(referer.indexOf("redirect") + 9, referer.length());
                if (url != null && !url.equals("")) {
                    mav.setViewName("redirect:" + request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + url);
                }
            } else {
                mav.setViewName("redirect:index");
            }
        } else {
            query.setPassword("");
            if (userService.find(query).size() == 0) {
                mav.addObject("msg", "没有此用户名");
            } else {
                mav.addObject("msg", "密码错误");
            }
        }
        return mav;
    }
}
