package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.AnonComment;
import org.example.morph.dto.AnonCommentDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.mapper.AnonCommentMapper;
import org.example.morph.repository.AnonCommentRepository;
import org.example.morph.service.AnonCommentService;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnonCommentServiceimpl implements AnonCommentService {

    final String permission = "anon";
    final RoleUserService roleUserService;

    final AnonCommentRepository anonCommentRepository;
    final AnonCommentMapper anonCommentMapper;

    // Create
    @Override
    public AnonCommentDto.CreateResDto create(AnonCommentDto.CreateSevDto createSevDto) {
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(createSevDto.getReqUserId()).permission(permission).func(120).build());

        AnonCommentDto.CreateResDto res = anonCommentRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public AnonCommentDto.DetailResDto detail(AnonCommentDto.DetailSevDto detailSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(detailSevDto.getReqUserId()).permission(permission).func(150).build());

        AnonCommentDto.DetailResDto res = anonCommentMapper.detail(detailSevDto);

        return res;
    }

    // List
    @Override
    public List<AnonCommentDto.ListResDto> list(AnonCommentDto.ListSevDto listSevDto){
        List<AnonCommentDto.ListResDto> res = anonCommentMapper.list(listSevDto);

        return res;
    }

    // Update
    @Override
    public void update(AnonCommentDto.UpdateSevDto updateSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(updateSevDto.getReqUserId()).permission(permission).func(180).build());

        AnonComment anonComment = anonCommentRepository.findById(updateSevDto.getId()).orElse(null);
        if(anonComment == null){
            throw new RuntimeException("no data");
        }

        if(updateSevDto.getContent() != null){
            anonComment.setContent(updateSevDto.getContent());
        }

        anonCommentRepository.save(anonComment);
    }

    // Delete
    @Override
    public void delete(AnonCommentDto.DeleteSevDto deleteSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(deleteSevDto.getReqUserId()).permission(permission).func(200).build());

        AnonComment anonComment = anonCommentRepository.findById(deleteSevDto.getId()).orElse(null);
        if(anonComment == null){
            throw new RuntimeException("no data");
        }

        anonComment.setDeleted(true);

        anonCommentRepository.save(anonComment);
    }
}
