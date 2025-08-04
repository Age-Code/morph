package org.example.morph.service;

import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.RoleUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleUserService {
    RoleUserDto.AddResDto add(RoleUserDto.AddSevDto addSevDto);
    List<RoleUserDto.ListResDto> list(RoleUserDto.ListSevDto listSevDto);
}
