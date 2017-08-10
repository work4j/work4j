package com.work4j.space.controller.fore;

import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.Article;
import com.work4j.space.pojo.form.ArticleForm;
import com.work4j.space.pojo.query.ArticleQuery;
import com.work4j.space.pojo.query.ColumnQuery;
import com.work4j.space.pojo.query.ReplyQuery;
import com.work4j.space.service.ArticleService;
import com.work4j.space.service.ColumnService;
import com.work4j.space.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ArticleController
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    private static final String LIST_PAGE = "modules/article/list";
    private static final String ADD_PAGE = "modules/article/add";
    private static final String EDIT_PAGE = "modules/article/edit";
    private static final String DETAIL_PAGE = "modules/article/detail";
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private ColumnService columnService;

    /**
     * Article页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final ArticleQuery query) {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        mav.addObject("result", articleService.findByPage(query));
        ColumnQuery columnQuery = new ColumnQuery();
        columnQuery.setEnabled(1);
        mav.addObject("columns", columnService.find(columnQuery));
        return mav;
    }

    /**
     * 查询 Article
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView listAllPage(final ArticleQuery query) {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        mav.addObject("result", articleService.find(query));
        return mav;
    }

    /**
     * 新增 Article
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(HttpServletRequest request) {
        if (SystemHelper.getCurrentUser() == null) {
            return "redirect:/fore/login?redirect=" + request.getRequestURI();
        }
        return ADD_PAGE;
    }

    /**
     * 新增 Article
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(final ArticleForm form) {
        articleService.add(form);
        return "redirect:list";
    }

    /**
     * 修改 Article
     */
    @RequestMapping(value = "/edit_{id}", method = RequestMethod.GET)
    public ModelAndView editPage(HttpServletRequest request, @PathVariable("id") final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        Article result = articleService.get(id);
        if (SystemHelper.getCurrentUser() == null) {
            mav.setViewName("redirect:/fore/login?redirect=" + request.getRequestURI());
            return mav;
        }
        if (result != null) {
            if (!SystemHelper.getCurrentUser().getId().equals(result.getUserId())) {
                mav.setViewName("redirect:/fore/noPermission");
            } else {
                mav.addObject("result", result);
            }
        } else {
            mav.setViewName("redirect:/fore/404");
        }
        return mav;
    }

    /**
     * 修改 Article
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(final ArticleForm form) {
        articleService.update(form);
        return "redirect:detail_" + form.getId();
    }

    /**
     * 查看 Article
     */
    @RequestMapping(value = "/detail_{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") final String id, ReplyQuery query) {
        ModelAndView mav = new ModelAndView(DETAIL_PAGE);
        Article result = articleService.get(id);
        if (result != null) {
            mav.addObject("result", result);
            query.setArticleId(id);
            mav.addObject("replys", replyService.findByPage(query));
            articleService.updateSeeNum(id);
        } else {
            mav.setViewName("redirect:/fore/404");
        }
        return mav;
    }

    /**
     * 停用 Article
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Article result = articleService.get(id);
        if (SystemHelper.getCurrentUser() != null || result == null || !SystemHelper.getCurrentUser().getId().equals(result.getUserId())) {
            map.put("success", false);
        } else {
            articleService.changeEnabled(id, 2);
            map.put("success", true);
        }
        return map;
    }
}