package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.RoleDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.RoleUserService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Void> add(@RequestBody RoleUserDto.AddUserReqDto addUserReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        RoleUserDto.AddUserSevDto addUserSevDto = RoleUserDto.AddUserSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        addUserSevDto = (RoleUserDto.AddUserSevDto) addUserSevDto.afterBuild(addUserReqDto);
        roleUserService.add(addUserSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/addUserList")
    public ResponseEntity<List<RoleUserDto.AddListResDto>> addUserList(RoleUserDto.AddListReqDto addListReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        RoleUserDto.AddListSevDto addListSevDto = RoleUserDto.AddListSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        addListSevDto = (RoleUserDto.AddListSevDto) addListSevDto.afterBuild(addListReqDto);

        return ResponseEntity.ok(roleUserService.addUserList(addListSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody RoleUserDto.DeleteReqDto deleteReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        RoleUserDto.DeleteSevDto deleteSevDto = RoleUserDto.DeleteSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        deleteSevDto = (RoleUserDto.DeleteSevDto) deleteSevDto.afterBuild(deleteReqDto);
        roleUserService.delete(deleteSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
