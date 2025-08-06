package org.example.morph.mapper;

import org.example.morph.dto.AdminUserDto;

import java.util.List;

public interface AdminUserMapper {
    AdminUserDto.DetailResDto detail(AdminUserDto.DetailSevDto detailSevDto);
    List<AdminUserDto.ListResDto> list(AdminUserDto.ListSevDto listSevDto);
}
