package com.work4j.space.controller.fore;

import com.work4j.space.util.FileUploadBean;
import com.work4j.space.util.FileUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wanshipeng on 2017/3/17.
 */
@Controller
@RequestMapping("/upload")
@Data
public class UploadController {
    @Value("${file.uploadpath}")
    private String uploadpath;
    @Value("${file.filepath}")
    private String filepath;

    /**
     * 文件上传
     */
    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public Map<String, Object> uploadFile(final FileUploadBean uploadItem) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String originalFilename = uploadItem.getFile().getOriginalFilename();   //原始文件名
        String suffix = FileUtil.getSuffix(originalFilename);   //文件后缀名
        String attachPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/")) + UUID.randomUUID().toString();
        String realPath = uploadpath + attachPath;
        // ****上传文件****
        // 上传路径://真实路径/文件上传路径/日期/时间.后缀
        String targetPathNameWithoutSuffix = realPath;
        FileUtil.uploadFileSpringMVC(uploadItem.getFile(), targetPathNameWithoutSuffix);
        String path = filepath + attachPath + "." + suffix;
        result.put("code", 0);
        result.put("msg", "");
        result.put("url", path);
        return result;
    }
}
