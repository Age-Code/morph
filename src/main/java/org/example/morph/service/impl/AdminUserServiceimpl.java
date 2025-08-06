package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.User;
import org.example.morph.dto.AdminUserDto;
import org.example.morph.mapper.AdminUserMapper;
import org.example.morph.repository.AdminUserRepository;
import org.example.morph.service.AdminUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUserServiceimpl implements AdminUserService {

    final AdminUserRepository adminUserRepository;
    final AdminUserMapper adminUserMapper;


    // Create
    @Override
    public AdminUserDto.CreateResDto create(AdminUserDto.CreateSevDto createSevDto) {
        AdminUserDto.CreateResDto res = adminUserRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public AdminUserDto.DetailResDto detail(AdminUserDto.DetailSevDto detailSevDto){
        AdminUserDto.DetailResDto res = adminUserMapper.detail(detailSevDto);

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
        User role = adminUserRepository.findById(updateSevDto.getId()).orElse(null);
        if(role == null){
            throw new RuntimeException("no data");
        }

        if(updateSevDto.getUsername() != null){
            role.setUsername(updateSevDto.getUsername());
        }
        if(updateSevDto.getEmail() != null){
            role.setEmail(updateSevDto.getEmail());
        }
        if(updateSevDto.getUniversity() != null){
            role.setUniversity(updateSevDto.getUniversity());
        }
        if(updateSevDto.getNickname() != null){
            role.setNickname(updateSevDto.getNickname());
        }

        adminUserRepository.save(role);
    }

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
