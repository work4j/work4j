package com.work4j.space.controller.fore;

import com.work4j.space.pojo.form.ReplyForm;
import com.work4j.space.pojo.query.ReplyQuery;
import com.work4j.space.service.ReplyService;
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
 * ReplyController 
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {
    private static final String LIST_PAGE = "modules/reply/list";
    private static final String ADD_PAGE = "modules/reply/add";
    private static final String EDIT_PAGE = "modules/reply/edit";
    @Autowired
    private ReplyService replyService;
    
    /**
     *  Reply页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPage(final ReplyQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", replyService.findByPage(query));
		return mav;
    }
    
    /**
     * 查询 Reply
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
   public ModelAndView listAllPage(final ReplyQuery query){
        ModelAndView mav = new ModelAndView(LIST_PAGE);
		mav.addObject("result", replyService.find(query));
		return mav;
    }
    
    /**
     * 新增 Reply
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }
    
    /**
     * 新增 Reply
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(final ReplyForm form) {
		replyService.add(form);
		return "redirect:list";
	}
	
    /**
     * 修改 Reply
     */
    @RequestMapping(value = "/edit_{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") final String id) {
		ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", replyService.get(id));
		return mav;
    }
    
    /**
     * 修改 Reply
     */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(final ReplyForm form) {
		replyService.update(form);
		return "redirect:list";
	}
	
	/**
     * 根据id删除 Reply
     */
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.GET)
	public Map<String, Object> delete(@PathVariable("id") final String id) {
		Map<String, Object> map = new HashMap<String, Object>();
        replyService.delete(id);
        return map;
	}	
	
	/**
     * 启用 Reply
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> enabled(@PathVariable("id") final String id){
        Map<String, Object> map = new HashMap<String, Object>();
        replyService.changeEnabled(id, 1);
        return map;
    }
	
	/**
     * 停用 Reply
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final Map<String, Object> disabled(@PathVariable("id") final String id){
		Map<String, Object> map = new HashMap<String, Object>();
        replyService.changeEnabled(id, 2);
        return map;
    }
}