package org.example.morph.service;

import org.example.morph.dto.PermissionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService {
    PermissionDto.ToggleResDto toggle(PermissionDto.ToggleSevDto toggleSevDto);
    List<PermissionDto.ListResDto> list(PermissionDto.ListSevDto listSevDto);
}
