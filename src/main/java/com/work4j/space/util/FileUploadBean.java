package com.work4j.space.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/16 0016.
 */
public class FileUploadBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private CommonsMultipartFile commonsMultipartFile;

    public final CommonsMultipartFile getFile() {
        return this.commonsMultipartFile;
    }

    public final void setFile(CommonsMultipartFile file) {
        this.commonsMultipartFile = file;
    }
}
