package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.Role;
import org.example.morph.domain.RoleUser;
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

                RoleUser roleUser = roleUserRepository.findByRoleIdAndUserId(each.getRoleId(), each.getUserId()).orElse(null);

                if(roleUser == null) {
                    roleUser = each.toEntity();
                }else{
                    roleUser.setDeleted(false);
                }

                roleUserRepository.save(roleUser).toAddResDto();
            }
        }
    }

    // UserList
    @Override
    public List<RoleUserDto.ListResDto> userList(RoleUserDto.ListSevDto listSevDto){

        List<RoleUserDto.ListResDto> res = roleUserMapper.userList(listSevDto);

        return res;
    }

    // AddUserList
    @Override
    public List<RoleUserDto.AddListResDto> addUserList(RoleUserDto.AddListSevDto addListSevDto){

        addListSevDto.setDeleted(true);

        List<RoleUserDto.AddListResDto> res = roleUserMapper.addUserList(addListSevDto);

        return res;
    }

    // RoleList
    @Override
    public List<RoleUserDto.ListResDto> roleList(RoleUserDto.ListSevDto listSevDto){

        List<RoleUserDto.ListResDto> res = roleUserMapper.roleList(listSevDto);

        return res;
    }

    @Override
    public void delete(RoleUserDto.DeleteSevDto deleteSevDto){
        RoleUser roleUser = roleUserRepository.findByRoleIdAndUserId(deleteSevDto.getRoleId(), deleteSevDto.getUserId()).orElse(null);

        if(roleUser == null){
            throw new RuntimeException("no data");
        }

        roleUser.setDeleted(true);

        roleUserRepository.save(roleUser);
    }

}
