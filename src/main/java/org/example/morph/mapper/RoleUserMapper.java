package org.example.morph.mapper;

import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.RoleUserDto;

import java.util.List;

public interface RoleUserMapper {
    List<RoleUserDto.ListResDto> list(RoleUserDto.ListSevDto listSevDto);
}
