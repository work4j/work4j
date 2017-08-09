package com.work4j.space.controller.fore;

import com.work4j.space.pojo.form.ArticleTagForm;
import com.work4j.space.pojo.query.ArticleTagQuery;
import com.work4j.space.service.ArticleTagService;
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
 * ArticleTagController 
 */
@Controller
@RequestMapping("/articleTag")
public class ArticleTagController {
    private static final String LIST_PAGE = "modules/articleTag/list";
    private static final String ADD_PAGE = "modules/articleTag/add";
    private static final String EDIT_PAGE = "modules/articleTag/edit";
    @Autowired
    private ArticleTagService articleTagService;
    
    /**
     *  ArticleTag页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final ArticleTagQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", articleTagService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 ArticleTag
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final ArticleTagQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", articleTagService.find(query));
		return mav;
    }
    
    /**
     * 新增 ArticleTag
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }
    
    /**
     * 新增 ArticleTag
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final ArticleTagForm form) {
		articleTagService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 ArticleTag
     */
    @RequestMapping(value = "/edit_{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") final String id) {
		ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", articleTagService.get(id));
		return mav;
    }
    
    /**
     * 修改 ArticleTag
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final ArticleTagForm form) {
		articleTagService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 ArticleTag
     */
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> delete(@PathVariable("id") final String id) {
		Map<String, Object> map = new HashMap<String, Object>();
        articleTagService.delete(id);
        map.put("success", true);
        return map;
	}	
	
	/**
     * 启用 ArticleTag
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> enabled(@PathVariable("id") final String id){
        Map<String, Object> map = new HashMap<String, Object>();
        articleTagService.changeEnabled(id, 1);
        map.put("success", true);
        return map;
    }
	
	/**
     * 停用 ArticleTag
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id){
		Map<String, Object> map = new HashMap<String, Object>();
        articleTagService.changeEnabled(id, 2);
        map.put("success", true);
        return map;
    }
}