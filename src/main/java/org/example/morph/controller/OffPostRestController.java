package org.example.morph.controller;

import lombok.RequiredArgsConstructor;
import org.example.morph.dto.OffPostDto;
import org.example.morph.security.PrincipalDetails;
import org.example.morph.service.OffPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/offPost")
@RestController
public class OffPostRestController {

    final OffPostService offPostService;

    public Long getReqUserId(PrincipalDetails principalDetails) {
        if(principalDetails == null || principalDetails.getUser() == null || principalDetails.getUser().getId() == null) {
            return null;
        }

        return principalDetails.getUser().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("")
    public ResponseEntity<OffPostDto.CreateResDto> create(@RequestBody OffPostDto.CreateReqDto createReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        OffPostDto.CreateSevDto createSevDto = OffPostDto.CreateSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        createSevDto = (OffPostDto.CreateSevDto) createSevDto.afterBuild(createReqDto);

        return ResponseEntity.ok(offPostService.create(createSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/detail")
    public ResponseEntity<OffPostDto.DetailResDto> detail(OffPostDto.DetailReqDto detailReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        OffPostDto.DetailSevDto detailSevDto = OffPostDto.DetailSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        detailSevDto = (OffPostDto.DetailSevDto) detailSevDto.afterBuild(detailReqDto);

        return ResponseEntity.ok(offPostService.detail(detailSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list")
    public ResponseEntity<List<OffPostDto.ListResDto>> list(@AuthenticationPrincipal PrincipalDetails principalDetails) {

        OffPostDto.ListSevDto listSevDto = OffPostDto.ListSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();

        return ResponseEntity.ok(offPostService.list(listSevDto));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody OffPostDto.DeleteReqDto deleteReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        OffPostDto.DeleteSevDto deleteSevDto = OffPostDto.DeleteSevDto.builder().reqUserId(getReqUserId(principalDetails)).build();
        deleteSevDto = (OffPostDto.DeleteSevDto) deleteSevDto.afterBuild(deleteReqDto);
        offPostService.delete(deleteSevDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
