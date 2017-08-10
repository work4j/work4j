package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
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
	private String code; // code
	private Integer enabled = 1; // enabled
	private java.util.Date createDataTime = new Date(); // createDataTime
	private String createDataUsername; // createDataUsername
	private java.util.Date updateDataTime; // updateDataTime
	private String updateDataUsername; // updateDataUsername
}