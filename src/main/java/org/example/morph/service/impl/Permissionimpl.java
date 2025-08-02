package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.Permission;
import org.example.morph.dto.PermissionDto;
import org.example.morph.repository.PermissionRepository;
import org.example.morph.service.PermissionService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Permissionimpl implements PermissionService {

    final PermissionRepository permissionRepository;

    // Toggle
    public PermissionDto.ToggleResDto toggle(PermissionDto.ToggleSevDto toggleSevDto){
        Permission permission = permissionRepository.findByRoleIdAndPermissionAndFunc(toggleSevDto.getRoleId(), toggleSevDto.getPermission(), toggleSevDto.getFunc());

        if(permission != null){
            if(toggleSevDto.getActive()){
                return permissionRepository.save(toggleSevDto.toEntity()).toToggleResDto();
            }
        }else{
            permission.setDeleted(!toggleSevDto.getActive());
            return permissionRepository.save(permission).toToggleResDto();
        }

        return PermissionDto.ToggleResDto.builder().id((long)-100).build();
    }
}
