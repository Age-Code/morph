package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.Role;
import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.RoleDto;
import org.example.morph.mapper.RoleMapper;
import org.example.morph.repository.RoleRepository;
import org.example.morph.service.PermissionService;
import org.example.morph.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceimpl implements RoleService {

    final RoleRepository roleRepository;
    final RoleMapper roleMapper;
    private final PermissionService permissionService;

    // Create
    @Override
    public RoleDto.CreateResDto create(RoleDto.CreateSevDto createSevDto) {
        RoleDto.CreateResDto res = roleRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public RoleDto.DetailResDto detail(RoleDto.DetailSevDto detailSevDto){
        RoleDto.DetailResDto res = roleMapper.detail(detailSevDto);

        res.setPermissionList(permissionService.list(PermissionDto.ListSevDto.builder().deleted(false).roleId(detailSevDto.getId()).build()));
        res.setPermissions(RoleDto.permissions);

        return res;
    }

    // List
    @Override
    public List<RoleDto.ListResDto> list(RoleDto.ListSevDto listSevDto){
        List<RoleDto.ListResDto> res = roleMapper.list(listSevDto);

        return res;
    }

    // Update
    @Override
    public void update(RoleDto.UpdateSevDto updateSevDto){
        Role role = roleRepository.findById(updateSevDto.getId()).orElse(null);
        if(role == null){
            throw new RuntimeException("no data");
        }

        if(updateSevDto.getRoleName() != null){
            role.setRoleName(updateSevDto.getRoleName());
        }
        if(updateSevDto.getContent() != null){
            role.setContent(updateSevDto.getContent());
        }

        roleRepository.save(role);
    }

    // Delete
    @Override
    public void delete(RoleDto.DeleteSevDto deleteSevDto){
        Role role = roleRepository.findById(deleteSevDto.getId()).orElse(null);
        if(role == null){
            throw new RuntimeException("no data");
        }

        role.setDeleted(true);

        roleRepository.save(role);
    }
}
