package org.example.morph.mapper;

import org.example.morph.dto.RoleDto;

import java.util.List;

public interface RoleMapper {
    RoleDto.DetailResDto detail(RoleDto.DetailSevDto detailSevDto);
    List<RoleDto.ListResDto> list(RoleDto.ListSevDto listSevDto);
}
