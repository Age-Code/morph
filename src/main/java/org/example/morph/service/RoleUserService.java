package org.example.morph.service;

import org.example.morph.dto.RoleUserDto;
import org.springframework.stereotype.Service;

@Service
public interface RoleUserService {
    RoleUserDto.AddResDto add(RoleUserDto.AddSevDto addSevDto);
}
