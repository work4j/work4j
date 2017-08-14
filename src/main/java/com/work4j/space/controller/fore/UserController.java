package com.work4j.space.controller.fore;

import com.work4j.space.common.SystemHelper;
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
     *  index页面
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView listPage(final ArticleQuery query){
        ModelAndView mav = new ModelAndView(INDEX_PAGE);
        //查询我的文章
        query.setUserId(SystemHelper.getCurrentUser().getId());
        query.setEnabled(1);
		mav.addObject("result", articleService.findByPage(query));
		return mav;
    }

    /**
     *  collection页面
     */
    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public ModelAndView listPage(final CollectionQuery query){
        ModelAndView mav = new ModelAndView(COLLECTION_PAGE);
        //查询我的收藏
        query.setUserId(SystemHelper.getCurrentUser().getId());
		mav.addObject("result", collectionService.findByPage(query));
		return mav;
    }

    /**
     * set页面
     */
    @RequestMapping(value = "/set", method = RequestMethod.GET)
   public ModelAndView setPage(final UserQuery query){
        ModelAndView mav = new ModelAndView(SET_PAGE);
		mav.addObject("result", userService.find(query));
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
     * 新增 User
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final UserForm form) {
		userService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 User
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final UserForm form) {
		userService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 User
     */
    @RequestMapping(value = "/delete_{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") final String id) {
		Map<String, Object> map = new HashMap<String, Object>();
        userService.delete(id);
        map.put("success", true);
        return map;
	}	
	
	/**
     * 启用 User
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> enabled(@PathVariable("id") final String id){
        Map<String, Object> map = new HashMap<String, Object>();
        userService.changeEnabled(id, 1);
        map.put("success", true);
        return map;
    }
	
	/**
     * 停用 User
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id){
		Map<String, Object> map = new HashMap<String, Object>();
        userService.changeEnabled(id, 2);
        map.put("success", true);
        return map;
    }
}