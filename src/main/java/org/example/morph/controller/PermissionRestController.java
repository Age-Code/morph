package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.PermissionDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/permision")
@RestController
public class PermissionRestController {

    final PermissionService permissionService;

    public Long getReqUserId(PrincipalDetails principalDetails) {
        if(principalDetails == null || principalDetails.getUser() == null || principalDetails.getUser().getId() == null) {
            return null;
        }

        return principalDetails.getUser().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/toggle")
    public ResponseEntity<PermissionDto.ToggleResDto> toggle(@RequestBody PermissionDto.ToggleReqDto toggleReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        PermissionDto.ToggleSevDto toggleSevDto = PermissionDto.ToggleSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        toggleSevDto = (PermissionDto.ToggleSevDto) toggleSevDto.afterBuild(toggleReqDto);

        return ResponseEntity.ok(permissionService.toggle(toggleSevDto));
    }

}
