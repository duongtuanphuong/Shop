package com.example.shop.model.mapper;

import com.example.shop.entity.User;
import com.example.shop.model.dto.UserDTO;

public class UserMapper {
    public static UserDTO toUserDTO(User user){
        UserDTO tmp = new UserDTO();
        tmp.setId(user.getId());
        tmp.setEmail(user.getEmail());
        tmp.setFullname(user.getFullname());
        tmp.setPhone(user.getPhone());
        tmp.setAddress(user.getAddress());
        tmp.setGender(user.getGender());
        tmp.setVerify(user.isVerify());
        tmp.setAvatar(user.getAvatar());
        tmp.setRole(user.getRole());
        return tmp;
    }

    public static User toUser(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getFullname());

        // Hash ??
        user.setPassword(userDTO.getPassword());


        user.setFullname(userDTO.getFullname());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setGender(userDTO.getGender());
        user.setAvatar(userDTO.getAvatar());
        user.setVerify(userDTO.isVerify());
        user.setRole(userDTO.getRole());
        return user;
    }
}
