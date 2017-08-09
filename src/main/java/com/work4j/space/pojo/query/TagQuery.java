package com.work4j.space.pojo.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * TagQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TagQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String name; // name
    private Integer enabled; // enabled
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime = new Date(); // updateDataTime
    private String updateDataUsername; // updateDataUsername
	
    private Integer page = 1;
    private Integer limit = 20;
    private String search;
}