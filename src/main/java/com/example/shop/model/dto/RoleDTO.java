package com.example.shop.model.dto;

import java.util.List;

import com.example.shop.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private long roleId;

    private String roleName;

    private List<User> users;
}
