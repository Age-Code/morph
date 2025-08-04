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
    public void add(RoleUserDto.AddUserSevDto addUserSevDto) {

        if (addUserSevDto.getAddSevDtoList() != null) {
            for (RoleUserDto.AddSevDto each : addUserSevDto.getAddSevDtoList()) {
                each.setReqUserId(addUserSevDto.getReqUserId());

                RoleUser roleUser = roleUserRepository.findByRoleIdAndUserId(each.getRoleId(), each.getUserId());

                if(roleUser == null) {
                    roleUser = each.toEntity();
                }else{
                    roleUser.setDeleted(false);
                }

                roleUserRepository.save(roleUser).toAddResDto();
            }
        }
    }

    // List
    @Override
    public List<RoleUserDto.ListResDto> list(RoleUserDto.ListSevDto listSevDto){

        listSevDto.setDeleted(false);

        List<RoleUserDto.ListResDto> res = roleUserMapper.list(listSevDto);

        return res;
    }

    // AddList
    @Override
    public List<RoleUserDto.AddListResDto> addList(RoleUserDto.AddListSevDto addListSevDto){

        addListSevDto.setDeleted(true);

        List<RoleUserDto.AddListResDto> res = roleUserMapper.addList(addListSevDto);

        return res;
    }

}
