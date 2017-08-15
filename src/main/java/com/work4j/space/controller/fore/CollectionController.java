package com.work4j.space.controller.fore;

import com.work4j.space.common.SystemHelper;
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
     * 收藏
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(final CollectionForm form) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (SystemHelper.getCurrentUser() == null) {
            map.put("success", false);
            map.put("msg", "请先登录");
        } else {
            form.setUserId(SystemHelper.getCurrentUser().getId());
            collectionService.add(form);
            map.put("success", true);
        }
        return map;
    }

    /**
     * 取消收藏
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(final CollectionQuery query) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (SystemHelper.getCurrentUser() == null) {
            map.put("success", false);
            map.put("msg", "请先登录");
        } else {
            query.setUserId(SystemHelper.getCurrentUser().getId());
            collectionService.delete(query);
            map.put("success", true);
        }
        return map;
    }
}