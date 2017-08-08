package com.work4j.space.pojo.form;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

/**
 * UserForm 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private String userName; // userName
	private String password; // password
	private String email; // email
	private String nickname; // nickname
	private String realName; // realName
	private java.util.Date registerTime; // registerTime
	private Integer userType; // userType
	private Integer enabled; // enabled
	private java.util.Date createDataTime; // createDataTime
	private String createDataUsername; // createDataUsername
	private java.util.Date updateDataTime; // updateDataTime
	private String updateDataUsername; // updateDataUsername
}