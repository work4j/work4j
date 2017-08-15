package com.work4j.space.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * User 
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // id
    private String userName; // userName
    private String password; // password
    private String email; // email
    private String nickname; // nickname
    private String realName; // realName
    private java.util.Date registerTime; // registerTime
    private Integer userType; // userType
    private String city; //city
    private Integer sex; //sex
    private String sign; //sign
    private String head; //head
    private Integer enabled; // enabled
    private java.util.Date createDataTime; // createDataTime
    private String createDataUsername; // createDataUsername
    private java.util.Date updateDataTime; // updateDataTime
    private String updateDataUsername; // updateDataUsername
}