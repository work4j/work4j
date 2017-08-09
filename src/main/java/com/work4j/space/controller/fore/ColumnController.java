package com.work4j.space.controller.fore;

import com.work4j.space.pojo.Column;
import com.work4j.space.pojo.form.ColumnForm;
import com.work4j.space.pojo.query.ColumnQuery;
import com.work4j.space.service.ColumnService;
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
 * ColumnController
 */
@Controller
@RequestMapping("/column")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    /**
     * 查询 Column
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Column> listPage(final ColumnQuery query) {
        query.setEnabled(1);
        return columnService.find(query);
    }
}