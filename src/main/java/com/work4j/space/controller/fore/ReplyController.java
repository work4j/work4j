package com.work4j.space.controller.fore;

import com.work4j.space.common.SystemHelper;
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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ReplyController
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * 新增 Reply
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, final ReplyForm form) {
        String url = request.getHeader("Referer");
        if (SystemHelper.getCurrentUser() == null) {
            String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            return "redirect:/fore/login?redirect=" + url.replace(host, "");
        }
        replyService.add(form);
        return "redirect:" + url;
    }
}