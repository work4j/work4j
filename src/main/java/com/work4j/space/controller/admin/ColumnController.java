package com.work4j.space.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.work4j.space.pojo.form.ColumnForm;
import com.work4j.space.pojo.query.ColumnQuery;
import com.work4j.space.service.ColumnService;
import java.util.HashMap;
import java.util.Map;

/**
 * ColumnController 
 */
@Controller
@RequestMapping("/column")
public class ColumnController {
    private static final String LIST_PAGE = "modules/column/list";
    private static final String ADD_PAGE = "modules/column/add";
    private static final String EDIT_PAGE = "modules/column/edit";
    @Autowired
    private ColumnService columnService;
    
    /**
     *  Column页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final ColumnQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", columnService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 Column
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final ColumnQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", columnService.find(query));
		return mav;
    }
    
    /**
     * 新增 Column
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }
    
    /**
     * 新增 Column
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final ColumnForm form) {
		columnService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 Column
     */
    @RequestMapping(value = "/edit_{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") final String id) {
		ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", columnService.get(id));
		return mav;
    }
    
    /**
     * 修改 Column
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final ColumnForm form) {
		columnService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 Column
     */
    @RequestMapping(value = "/delete_{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") final String id) {
		Map<String, Object> map = new HashMap<String, Object>();
        columnService.delete(id);
        map.put("success", true);
        return map;
	}	
	
	/**
     * 启用 Column
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> enabled(@PathVariable("id") final String id){
        Map<String, Object> map = new HashMap<String, Object>();
        columnService.changeEnabled(id, 1);
        map.put("success", true);
        return map;
    }
	
	/**
     * 停用 Column
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id){
		Map<String, Object> map = new HashMap<String, Object>();
        columnService.changeEnabled(id, 2);
        map.put("success", true);
        return map;
    }
}