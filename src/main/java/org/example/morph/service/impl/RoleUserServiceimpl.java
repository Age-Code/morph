package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.RoleUser;
import org.example.morph.domain.User;
import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.RoleDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.mapper.RoleUserMapper;
import org.example.morph.repository.RoleUserRepository;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleUserServiceimpl implements RoleUserService {

    final RoleUserRepository roleUserRepository;
    final RoleUserMapper roleUserMapper;

    // Add
    @Override
    public RoleUserDto.AddResDto add(RoleUserDto.AddSevDto addSevDto) {

        RoleUser roleUser = roleUserRepository.findByRoleIdAndUserId(addSevDto.getRoleId(), addSevDto.getUserId());

        if(roleUser == null) {
            roleUser = addSevDto.toEntity();
        }else{
            roleUser.setDeleted(false);
        }

        RoleUserDto.AddResDto res = roleUserRepository.save(roleUser).toAddResDto();

        return res;
    }

    // List
    @Override
    public List<RoleUserDto.ListResDto> list(RoleUserDto.ListSevDto listSevDto){
        List<RoleUserDto.ListResDto> res = roleUserMapper.list(listSevDto);

        return res;
    }

}
