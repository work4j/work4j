package com.work4j.space.controller.fore;

import com.work4j.space.pojo.form.CollectionForm;
import com.work4j.space.pojo.query.CollectionQuery;
import com.work4j.space.service.CollectionService;
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
 * CollectionController 
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {
    private static final String LIST_PAGE = "modules/collection/list";
    private static final String ADD_PAGE = "modules/collection/add";
    private static final String EDIT_PAGE = "modules/collection/edit";
    @Autowired
    private CollectionService collectionService;
    
    /**
     *  Collection页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final CollectionQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", collectionService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 Collection
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final CollectionQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", collectionService.find(query));
		return mav;
    }
    
    /**
     * 新增 Collection
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }
    
    /**
     * 新增 Collection
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final CollectionForm form) {
		collectionService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 Collection
     */
    @RequestMapping(value = "/edit_{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") final String id) {
		ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", collectionService.get(id));
		return mav;
    }
    
    /**
     * 修改 Collection
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final CollectionForm form) {
		collectionService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 Collection
     */
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> delete(@PathVariable("id") final String id) {
		Map<String, Object> map = new HashMap<String, Object>();
        collectionService.delete(id);
        map.put("success", true);
        return map;
	}	
	
	/**
     * 启用 Collection
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> enabled(@PathVariable("id") final String id){
        Map<String, Object> map = new HashMap<String, Object>();
        collectionService.changeEnabled(id, 1);
        map.put("success", true);
        return map;
    }
	
	/**
     * 停用 Collection
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id){
		Map<String, Object> map = new HashMap<String, Object>();
        collectionService.changeEnabled(id, 2);
        map.put("success", true);
        return map;
    }
}