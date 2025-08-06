package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.AdminUserDto;
import org.example.morph.mapper.AdminUserMapper;
import org.example.morph.repository.AdminUserRepository;
import org.example.morph.service.AdminUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUserServiceimpl implements AdminUserService {

    final AdminUserRepository roleRepository;
    final AdminUserMapper roleMapper;


    // Create
    @Override
    public AdminUserDto.CreateResDto create(AdminUserDto.CreateSevDto createSevDto) {
        AdminUserDto.CreateResDto res = roleRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public AdminUserDto.DetailResDto detail(AdminUserDto.DetailSevDto detailSevDto){
        AdminUserDto.DetailResDto res = roleMapper.detail(detailSevDto);

        return res;
    }

    // List
    @Override
    public List<AdminUserDto.ListResDto> list(AdminUserDto.ListSevDto listSevDto){
        List<AdminUserDto.ListResDto> res = roleMapper.list(listSevDto);

        return res;
    }

//    // Update
//    @Override
//    public void update(AdminUserDto.UpdateSevDto updateSevDto){
//        AdminUser role = roleRepository.findById(updateSevDto.getId()).orElse(null);
//        if(role == null){
//            throw new RuntimeException("no data");
//        }
//
//        if(updateSevDto.getAdminUserName() != null){
//            role.setAdminUserName(updateSevDto.getAdminUserName());
//        }
//        if(updateSevDto.getContent() != null){
//            role.setContent(updateSevDto.getContent());
//        }
//
//        if (updateSevDto.getPermissionUpdate() != null) {
//            for (PermissionDto.ToggleSevDto each : updateSevDto.getPermissionUpdate()) {
//                each.setAdminUserId(role.getId());
//                permissionService.toggle(each);
//            }
//        }
//
//        roleRepository.save(role);
//    }
//
//    // Delete
//    @Override
//    public void delete(AdminUserDto.DeleteSevDto deleteSevDto){
//        AdminUser role = roleRepository.findById(deleteSevDto.getId()).orElse(null);
//        if(role == null){
//            throw new RuntimeException("no data");
//        }
//
//        role.setDeleted(true);
//
//        roleRepository.save(role);
//    }
}
