package org.example.morph.service;

import org.example.morph.dto.RoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    RoleDto.CreateResDto create(RoleDto.CreateSevDto createSevDto);
}
