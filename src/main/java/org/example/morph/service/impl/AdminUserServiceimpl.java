package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.User;
import org.example.morph.dto.AdminUserDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.mapper.AdminUserMapper;
import org.example.morph.repository.AdminUserRepository;
import org.example.morph.service.AdminUserService;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUserServiceimpl implements AdminUserService {

    final String permission = "user";

    final AdminUserRepository adminUserRepository;
    final AdminUserMapper adminUserMapper;
    final RoleUserService roleUserService;


    // Create
    @Override
    public AdminUserDto.CreateResDto create(AdminUserDto.CreateSevDto createSevDto) {
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(createSevDto.getReqUserId()).permission(permission).func(120).build());

        AdminUserDto.CreateResDto res = adminUserRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public AdminUserDto.DetailResDto detail(AdminUserDto.DetailSevDto detailSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(detailSevDto.getReqUserId()).permission(permission).func(150).build());

        AdminUserDto.DetailResDto res = adminUserMapper.detail(detailSevDto);

        res.setUserRoleList(roleUserService.roleList(RoleUserDto.ListSevDto.builder().deleted(false).reqId(detailSevDto.getId()).reqUserId(detailSevDto.getReqUserId()).build()));

        return res;
    }

    // List
    @Override
    public List<AdminUserDto.ListResDto> list(AdminUserDto.ListSevDto listSevDto){
        List<AdminUserDto.ListResDto> res = adminUserMapper.list(listSevDto);

        return res;
    }

    // Update
    @Override
    public void update(AdminUserDto.UpdateSevDto updateSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(updateSevDto.getReqUserId()).permission(permission).func(180).build());

        User user = adminUserRepository.findById(updateSevDto.getId()).orElse(null);
        if(user == null){
            throw new RuntimeException("no data");
        }

        if(updateSevDto.getUsername() != null){
            user.setUsername(updateSevDto.getUsername());
        }
        if(updateSevDto.getEmail() != null){
            user.setEmail(updateSevDto.getEmail());
        }
        if(updateSevDto.getUniversity() != null){
            user.setUniversity(updateSevDto.getUniversity());
        }
        if(updateSevDto.getNickname() != null){
            user.setNickname(updateSevDto.getNickname());
        }

        adminUserRepository.save(user);
    }

    // Delete
    @Override
    public void delete(AdminUserDto.DeleteSevDto deleteSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(deleteSevDto.getReqUserId()).permission(permission).func(200).build());

        User user = adminUserRepository.findById(deleteSevDto.getId()).orElse(null);
        if(user == null){
            throw new RuntimeException("no data");
        }

        user.setDeleted(true);

        adminUserRepository.save(user);
    }
}
