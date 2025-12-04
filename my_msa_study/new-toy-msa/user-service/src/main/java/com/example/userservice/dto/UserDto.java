package com.example.userservice.dto;

import com.example.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String userId;
    private String email;
    private String name;
    private Date createAt;
    private String pwd;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
