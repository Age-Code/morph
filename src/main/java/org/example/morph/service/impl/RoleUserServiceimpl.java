package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.RoleUser;
import org.example.morph.domain.User;
import org.example.morph.dto.RoleDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.repository.RoleUserRepository;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleUserServiceimpl implements RoleUserService {

    final RoleUserRepository roleuserRepository;

    // Add
    @Override
    public RoleUserDto.AddResDto add(RoleUserDto.AddSevDto addSevDto) {

        RoleUser roleUser = roleuserRepository.findByRoleIdAndUserId(addSevDto.getRoleId(), addSevDto.getUserId());

        if(roleUser == null) {
            roleUser = addSevDto.toEntity();
        }else{
            roleUser.setDeleted(false);
        }

        RoleUserDto.AddResDto res = roleuserRepository.save(roleUser).toAddResDto();

        return res;
    }

}
