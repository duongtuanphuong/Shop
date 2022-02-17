package com.example.shop.model.dto;

import com.example.shop.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String email;

    private String password;

    private String fullname;

    private String phone;

    private String address;
    
    private String gender;

    private boolean verify;

    private String avatar;

    private Role role;
}

