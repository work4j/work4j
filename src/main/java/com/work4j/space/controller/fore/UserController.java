package com.work4j.space.controller.fore;

import com.github.pagehelper.Page;
import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.Article;
import com.work4j.space.pojo.Collection;
import com.work4j.space.pojo.User;
import com.work4j.space.pojo.form.UserForm;
import com.work4j.space.pojo.query.ArticleQuery;
import com.work4j.space.pojo.query.CollectionQuery;
import com.work4j.space.pojo.query.ReplyQuery;
import com.work4j.space.pojo.query.UserQuery;
import com.work4j.space.service.ArticleService;
import com.work4j.space.service.CollectionService;
import com.work4j.space.service.ReplyService;
import com.work4j.space.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final String INDEX_PAGE = "modules/user/index";
    private static final String COLLECTION_PAGE = "modules/user/collection";
    private static final String SET_PAGE = "modules/user/set";
    private static final String DETAIL_PAGE = "modules/user/detail";
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private ReplyService replyService;

    /**
     * index页面
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView listPage(final ArticleQuery query) {
        ModelAndView mav = new ModelAndView(INDEX_PAGE);
        //查询我的文章
        query.setUserId(SystemHelper.getCurrentUser().getId());
        query.setEnabled(1);
        mav.addObject("result", articleService.findByPage(query));
        CollectionQuery collectionQuery = new CollectionQuery();
        collectionQuery.setUserId(SystemHelper.getCurrentUser().getId());
        mav.addObject("count", collectionService.findByPage(collectionQuery).getTotal());
        return mav;
    }

    /**
     * collection页面
     */
    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public ModelAndView listPage(final CollectionQuery query) {
        ModelAndView mav = new ModelAndView(COLLECTION_PAGE);
        //查询我的收藏
        query.setUserId(SystemHelper.getCurrentUser().getId());
        mav.addObject("result", collectionService.findByPage(query));
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setUserId(SystemHelper.getCurrentUser().getId());
        articleQuery.setEnabled(1);
        mav.addObject("count", articleService.findByPage(articleQuery).getTotal());
        return mav;
    }

    /**
     * set页面
     */
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public ModelAndView setPage() {
        ModelAndView mav = new ModelAndView(SET_PAGE);
        mav.addObject("result", SystemHelper.getCurrentUser());
        return mav;
    }

    /**
     * detail页面
     */
    @RequestMapping(value = "/detail_{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") final String id) {
        ModelAndView mav = new ModelAndView(DETAIL_PAGE);
        User result = userService.get(id);
        if (result != null && result.getEnabled() == 1) {
            mav.addObject("result", result);
            ArticleQuery query = new ArticleQuery();
            query.setUserId(id);
            query.setEnabled(1);
            mav.addObject("articles", articleService.findByPage(query));
            ReplyQuery replyQuery = new ReplyQuery();
            query.setUserId(id);
            query.setEnabled(1);
            query.setLimit(10);
            mav.addObject("replys", replyService.findByPage(replyQuery));
        } else {
            mav.setViewName("redirect:/fore/404");
        }
        return mav;
    }

    /**
     * 修改 User
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> edit(final UserForm form) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (SystemHelper.getCurrentUser() == null) {
            map.put("success", false);
            map.put("msg", "请先登录");
        } else {
            String id = SystemHelper.getCurrentUser().getId();
            form.setId(id);
            userService.update(form);
            SystemHelper.setCurrentUser(userService.get(id));
            map.put("success", true);
        }
        return map;
    }
}