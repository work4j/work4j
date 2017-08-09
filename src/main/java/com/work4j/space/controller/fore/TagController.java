package com.work4j.space.controller.fore;

import com.work4j.space.pojo.Column;
import com.work4j.space.pojo.Tag;
import com.work4j.space.pojo.form.TagForm;
import com.work4j.space.pojo.query.ColumnQuery;
import com.work4j.space.pojo.query.TagQuery;
import com.work4j.space.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TagController 
 */
@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 查询 Tag
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Tag> listPage(final TagQuery query) {
        query.setEnabled(1);
        return tagService.find(query);
    }
}