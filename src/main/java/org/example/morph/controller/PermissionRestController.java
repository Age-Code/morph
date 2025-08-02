package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.RoleDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list")
    public ResponseEntity<List<PermissionDto.ListResDto>> list(PermissionDto.ListReqDto listReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        PermissionDto.ListSevDto listSevDto = PermissionDto.ListSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        listSevDto = (PermissionDto.ListSevDto) listSevDto.afterBuild(listReqDto);

        return ResponseEntity.ok(permissionService.list(listSevDto));
    }

}
