package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.AnonCommentDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.AnonCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/anonComment")
@RestController
public class AnonCommentRestController {

    final AnonCommentService anonCommentService;

    public Long getReqUserId(PrincipalDetails principalDetails) {
        if(principalDetails == null || principalDetails.getUser() == null || principalDetails.getUser().getId() == null) {
            return null;
        }

        return principalDetails.getUser().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("")
    public ResponseEntity<AnonCommentDto.CreateResDto> create(@RequestBody AnonCommentDto.CreateReqDto createReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonCommentDto.CreateSevDto createSevDto = AnonCommentDto.CreateSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        createSevDto = (AnonCommentDto.CreateSevDto) createSevDto.afterBuild(createReqDto);

        return ResponseEntity.ok(anonCommentService.create(createSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/detail")
    public ResponseEntity<AnonCommentDto.DetailResDto> detail(AnonCommentDto.DetailReqDto detailReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonCommentDto.DetailSevDto detailSevDto = AnonCommentDto.DetailSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        detailSevDto = (AnonCommentDto.DetailSevDto) detailSevDto.afterBuild(detailReqDto);

        return ResponseEntity.ok(anonCommentService.detail(detailSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list")
    public ResponseEntity<List<AnonCommentDto.ListResDto>> list(@AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonCommentDto.ListSevDto listSevDto = AnonCommentDto.ListSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();

        return ResponseEntity.ok(anonCommentService.list(listSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody AnonCommentDto.UpdateReqDto updateReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonCommentDto.UpdateSevDto updateSevDto = AnonCommentDto.UpdateSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        updateSevDto = (AnonCommentDto.UpdateSevDto) updateSevDto.afterBuild(updateReqDto);
        anonCommentService.update(updateSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody AnonCommentDto.DeleteReqDto deleteReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        AnonCommentDto.DeleteSevDto deleteSevDto = AnonCommentDto.DeleteSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        deleteSevDto = (AnonCommentDto.DeleteSevDto) deleteSevDto.afterBuild(deleteReqDto);
        anonCommentService.delete(deleteSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
