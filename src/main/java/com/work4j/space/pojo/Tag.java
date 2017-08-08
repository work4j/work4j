package com.work4j.space.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * Tag 
 */
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String name; // name
    private Integer enabled; // enabled
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername
}