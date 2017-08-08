package com.work4j.space.controller.fore;

import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.form.TagForm;
import com.work4j.space.pojo.query.TagQuery;
import com.work4j.space.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * TagController 
 */
@Controller
@RequestMapping("/tag")
public class TagController {
    private static final String LIST_PAGE = "modules/tag/list";
    private static final String ADD_PAGE = "modules/tag/add";
    private static final String EDIT_PAGE = "modules/tag/edit";
    @Autowired
    private TagService tagService;
    
    /**
     *  Tag页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final TagQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", tagService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 Tag
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final TagQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", tagService.find(query));
		return mav;
    }
    
    /**
     * 新增 Tag
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }
    
    /**
     * 新增 Tag
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final TagForm form) {
		tagService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 Tag
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage() {
        return EDIT_PAGE;
    }
    
    /**
     * 修改 Tag
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final TagForm form) {
		tagService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 Tag
     */
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") final String id) {
		tagService.delete(id);
		HttpServletRequest request = SystemHelper.getRequest();
		String url = request.getHeader("Referer");
		return "redirect:" + url;
	}	
	
	/**
     * 启用 Tag
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final boolean enabled(@PathVariable("id") final String id){
        tagService.changeEnabled(id, 1);
        return true;
    }
	
	/**
     * 停用 Tag
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final boolean disabled(@PathVariable("id") final String id){
        tagService.changeEnabled(id, 2);
        return true;
    }
}