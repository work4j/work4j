package com.work4j.space.controller.fore;

import com.work4j.space.pojo.form.ToolForm;
import com.work4j.space.pojo.query.ToolQuery;
import com.work4j.space.service.ToolService;
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
 * ToolController 
 */
@Controller
@RequestMapping("/tool")
public class ToolController {
    private static final String LIST_PAGE = "modules/tool/list";
    private static final String ADD_PAGE = "modules/tool/add";
    private static final String EDIT_PAGE = "modules/tool/edit";
    @Autowired
    private ToolService toolService;
    
    /**
     *  Tool页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final ToolQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", toolService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 Tool
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final ToolQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", toolService.find(query));
		return mav;
    }
    
    /**
     * 新增 Tool
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }
    
    /**
     * 新增 Tool
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final ToolForm form) {
		toolService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 Tool
     */
    @RequestMapping(value = "/edit_{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") final String id) {
		ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", toolService.get(id));
		return mav;
    }
    
    /**
     * 修改 Tool
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final ToolForm form) {
		toolService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 Tool
     */
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.GET)
	public Map<String, Object> delete(@PathVariable("id") final String id) {
		Map<String, Object> map = new HashMap<String, Object>();
        toolService.delete(id);
        return map;
	}	
	
	/**
     * 启用 Tool
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> enabled(@PathVariable("id") final String id){
        Map<String, Object> map = new HashMap<String, Object>();
        toolService.changeEnabled(id, 1);
        return map;
    }
	
	/**
     * 停用 Tool
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id){
		Map<String, Object> map = new HashMap<String, Object>();
        toolService.changeEnabled(id, 2);
        return map;
    }
}