package com.atstudy.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userAvatarurl;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private String userSalt;
    private Integer userSecuritylevel;
    private Integer userGender;
    private LocalDate userBirthday;
    private String userRegion;
    private String userMotto;
    private Byte userStatus;
    private String userToken;
    private LocalDateTime userExpiretime;
    private LocalDateTime userLoggedtime;
    private String userLoggedip;
    private Integer userCreatefrom;
    private LocalDate createtime;
    private LocalDate updatetime;
}
