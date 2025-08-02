package org.example.morph.service;

import org.example.morph.dto.PermissionDto;
import org.springframework.stereotype.Service;

@Service
public interface PermissionService {
    PermissionDto.ToggleResDto toggle(PermissionDto.ToggleSevDto toggleSevDto);
}
