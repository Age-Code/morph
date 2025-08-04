package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.RoleDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.RoleUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/roleUser")
@RestController
public class RoleUserRestController {

    final RoleUserService roleUserService;

    public Long getReqUserId(PrincipalDetails principalDetails) {
        if(principalDetails == null || principalDetails.getUser() == null || principalDetails.getUser().getId() == null) {
            return null;
        }

        return principalDetails.getUser().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<RoleUserDto.AddResDto> add(@RequestBody RoleUserDto.AddReqDto addReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        RoleUserDto.AddSevDto addSevDto = RoleUserDto.AddSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        addSevDto = (RoleUserDto.AddSevDto) addSevDto.afterBuild(addReqDto);

        return ResponseEntity.ok(roleUserService.add(addSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/addList")
    public ResponseEntity<List<RoleUserDto.AddListResDto>> addList(RoleUserDto.AddListReqDto detailReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        RoleUserDto.AddListSevDto addListSevDto = RoleUserDto.AddListSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();

        return ResponseEntity.ok(roleUserService.addList(addListSevDto));
    }

}
