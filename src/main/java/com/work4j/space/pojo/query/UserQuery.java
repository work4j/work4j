package com.work4j.space.pojo.query;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * UserQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
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
	
    private Integer page = 1;
    private Integer limit = 20;
    private String search;
}