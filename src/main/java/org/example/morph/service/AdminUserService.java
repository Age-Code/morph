package org.example.morph.service;

import org.example.morph.dto.AdminUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminUserService {
    AdminUserDto.CreateResDto create(AdminUserDto.CreateSevDto createSevDto);
    AdminUserDto.DetailResDto detail(AdminUserDto.DetailSevDto detailSevDto);
    List<AdminUserDto.ListResDto> list(AdminUserDto.ListSevDto listSevDto);
    void update(AdminUserDto.UpdateSevDto updateSevDto);
//    void delete(AdminUserDto.DeleteSevDto deleteSevDto);
}
