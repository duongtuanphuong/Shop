package com.example.shop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private long roleId;

    private String roleName;

    private List<UserDTO> UserDTOs;
}
