package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.AnonPostDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.AnonPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/anonPost")
@RestController
public class AnonPostRestController {

    final AnonPostService anonPostService;

    public Long getReqUserId(PrincipalDetails principalDetails) {
        if(principalDetails == null || principalDetails.getUser() == null || principalDetails.getUser().getId() == null) {
            return null;
        }

        return principalDetails.getUser().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("")
    public ResponseEntity<AnonPostDto.CreateResDto> create(@RequestBody AnonPostDto.CreateReqDto createReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonPostDto.CreateSevDto createSevDto = AnonPostDto.CreateSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        createSevDto = (AnonPostDto.CreateSevDto) createSevDto.afterBuild(createReqDto);

        return ResponseEntity.ok(anonPostService.create(createSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/detail")
    public ResponseEntity<AnonPostDto.DetailResDto> detail(AnonPostDto.DetailReqDto detailReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonPostDto.DetailSevDto detailSevDto = AnonPostDto.DetailSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        detailSevDto = (AnonPostDto.DetailSevDto) detailSevDto.afterBuild(detailReqDto);

        return ResponseEntity.ok(anonPostService.detail(detailSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list")
    public ResponseEntity<List<AnonPostDto.ListResDto>> list(@AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonPostDto.ListSevDto listSevDto = AnonPostDto.ListSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();

        return ResponseEntity.ok(anonPostService.list(listSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody AnonPostDto.UpdateReqDto updateReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonPostDto.UpdateSevDto updateSevDto = AnonPostDto.UpdateSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        updateSevDto = (AnonPostDto.UpdateSevDto) updateSevDto.afterBuild(updateReqDto);
        anonPostService.update(updateSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody AnonPostDto.DeleteReqDto deleteReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonPostDto.DeleteSevDto deleteSevDto = AnonPostDto.DeleteSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        deleteSevDto = (AnonPostDto.DeleteSevDto) deleteSevDto.afterBuild(deleteReqDto);
        anonPostService.delete(deleteSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
