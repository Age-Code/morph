package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.RoleDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/role")
@RestController
public class RoleRestController {

    final RoleService roleService;

    public Long getReqUserId(PrincipalDetails principalDetails) {
        if(principalDetails == null || principalDetails.getUser() == null || principalDetails.getUser().getId() == null) {
            return null;
        }

        return principalDetails.getUser().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("")
    public ResponseEntity<RoleDto.CreateResDto> create(@RequestBody RoleDto.CreateReqDto createReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        Long reqUserId = getReqUserId(principalDetails);

        RoleDto.CreateSevDto createSevDto = RoleDto.CreateSevDto.builder().reqUserId(reqUserId).build();
        createSevDto = (RoleDto.CreateSevDto) createSevDto.afterBuild(createReqDto);

        return ResponseEntity.ok(roleService.create(createSevDto));
    }
}
