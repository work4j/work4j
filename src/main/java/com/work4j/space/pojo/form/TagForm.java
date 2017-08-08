package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

/**
 * TagForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TagForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String name; // name
	private Integer enabled; // enabled
	private java.util.Date createDataTime; // createDataTime
	private String createDataUsername; // createDataUsername
	private java.util.Date updateDataTime; // updateDataTime
	private String updateDataUsername; // updateDataUsername
}