package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.RoleDto;
import org.example.morph.repository.RoleRepository;
import org.example.morph.service.RoleService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceimpl implements RoleService {

    final RoleRepository roleRepository;

    // Create
    @Override
    public RoleDto.CreateResDto create(RoleDto.CreateSevDto createSevDto) {
        RoleDto.CreateResDto res = roleRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }
}
