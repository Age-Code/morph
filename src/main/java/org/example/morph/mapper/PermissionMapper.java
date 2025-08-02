package org.example.morph.mapper;

import org.example.morph.dto.PermissionDto;

import java.util.List;

public interface PermissionMapper {
    List<PermissionDto.ListResDto> list(PermissionDto.ListSevDto listSevDto);
}
