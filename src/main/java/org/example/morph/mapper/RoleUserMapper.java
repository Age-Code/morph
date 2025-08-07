package org.example.morph.mapper;

import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.RoleUserDto;

import java.util.List;

public interface RoleUserMapper {
    List<RoleUserDto.ListResDto> userList(RoleUserDto.ListSevDto listSevDto);
    List<RoleUserDto.AddListResDto> addUserList(RoleUserDto.AddListSevDto addListSevDto);
    List<RoleUserDto.ListResDto> roleList(RoleUserDto.ListSevDto listSevDto);
    List<RoleUserDto.AddListResDto> addRoleList(RoleUserDto.AddListSevDto addListSevDto);
}
