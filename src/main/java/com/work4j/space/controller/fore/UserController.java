package com.work4j.space.controller.fore;

import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.form.UserForm;
import com.work4j.space.pojo.query.UserQuery;
import com.work4j.space.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * UserController 
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final String LIST_PAGE = "modules/user/list";
    private static final String ADD_PAGE = "modules/user/add";
    private static final String EDIT_PAGE = "modules/user/edit";
    @Autowired
    private UserService userService;
    
    /**
     *  User页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final UserQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", userService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 User
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final UserQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", userService.find(query));
		return mav;
    }
    
    /**
     * 新增 User
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
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
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage() {
        return EDIT_PAGE;
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
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") final String id) {
		userService.delete(id);
		HttpServletRequest request = SystemHelper.getRequest();
		String url = request.getHeader("Referer");
		return "redirect:" + url;
	}	
	
	/**
     * 启用 User
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final boolean enabled(@PathVariable("id") final String id){
        userService.changeEnabled(id, 1);
        return true;
    }
	
	/**
     * 停用 User
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final boolean disabled(@PathVariable("id") final String id){
        userService.changeEnabled(id, 2);
        return true;
    }
}