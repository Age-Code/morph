package org.example.morph.service;

import org.example.morph.dto.RoleUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleUserService {
    void add(RoleUserDto.AddUserSevDto addUserSevDto);
    List<RoleUserDto.ListResDto> list(RoleUserDto.ListSevDto listSevDto);
    List<RoleUserDto.UserListResDto> userList(RoleUserDto.UserListSevDto addListSevDto);
}
