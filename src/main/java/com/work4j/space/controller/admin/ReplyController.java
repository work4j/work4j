package com.work4j.space.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
import com.work4j.space.common.SystemHelper;
import com.work4j.space.pojo.form.ReplyForm;
import com.work4j.space.pojo.query.ReplyQuery;
import com.work4j.space.service.ReplyService;

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
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage() {
        return EDIT_PAGE;
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
	public String delete(@PathVariable("id") final String id) {
		replyService.delete(id);
		HttpServletRequest request = SystemHelper.getRequest();
		String url = request.getHeader("Referer");
		return "redirect:" + url;
	}	
	
	/**
     * 启用 Reply
     */
    @RequestMapping(value = "/enabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final boolean enabled(@PathVariable("id") final String id){
        replyService.changeEnabled(id, 1);
        return true;
    }
	
	/**
     * 停用 Reply
     */
    @RequestMapping(value = "/disabled_{id}", method = RequestMethod.POST)
    @ResponseBody
    public final boolean disabled(@PathVariable("id") final String id){
        replyService.changeEnabled(id, 2);
        return true;
    }
}