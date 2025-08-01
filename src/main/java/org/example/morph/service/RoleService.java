package org.example.morph.service;

import org.example.morph.dto.RoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    RoleDto.CreateResDto create(RoleDto.CreateSevDto createSevDto);
    RoleDto.DetailResDto detail(RoleDto.DetailSevDto detailSevDto);
    List<RoleDto.ListResDto> list(RoleDto.ListSevDto listSevDto);
    void update(RoleDto.UpdateSevDto updateSevDto);
    void delete(RoleDto.DeleteSevDto deleteSevDto);
}
