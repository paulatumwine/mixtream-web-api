package org.mixtream.mixtreamwebapi.adapter;

import org.mixtream.mixtreamwebapi.dto.UserDTO;
import org.mixtream.mixtreamwebapi.model.User;

public class UserAdapter {

    public static User getUser(UserDTO obj) {
        return User.builder()
                .id(obj.getId())
                .email(obj.getEmail())
                .password(obj.getPassword())
                .avatar(obj.getAvatar())
                .roleList(obj.getRoleList())
                .build();
    }

    public static UserDTO getUserDTO(User obj) {
        return obj == null ? UserDTO.builder().build() : UserDTO.builder()
                .id(obj.getId())
                .email(obj.getEmail())
                .password(obj.getPassword())
                .avatar(obj.getAvatar())
                .roleList(obj.getRoleList())
                .build();
    }
}
