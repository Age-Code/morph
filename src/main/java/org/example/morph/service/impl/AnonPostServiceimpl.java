package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.AnonPost;
import org.example.morph.dto.AnonPostDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.mapper.AnonPostMapper;
import org.example.morph.repository.AnonPostRepository;
import org.example.morph.service.AnonPostService;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnonPostServiceimpl implements AnonPostService {

    final String permission = "anon";
    final RoleUserService roleUserService;

    final AnonPostRepository anonPostRepository;
    final AnonPostMapper anonPostMapper;

    // Create
    @Override
    public AnonPostDto.CreateResDto create(AnonPostDto.CreateSevDto createSevDto) {
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(createSevDto.getReqUserId()).permission(permission).func(120).build());

        AnonPostDto.CreateResDto res = anonPostRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public AnonPostDto.DetailResDto detail(AnonPostDto.DetailSevDto detailSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(detailSevDto.getReqUserId()).permission(permission).func(150).build());

        AnonPostDto.DetailResDto res = anonPostMapper.detail(detailSevDto);

        return res;
    }

    // List
    @Override
    public List<AnonPostDto.ListResDto> list(AnonPostDto.ListSevDto listSevDto){
        List<AnonPostDto.ListResDto> res = anonPostMapper.list(listSevDto);

        return res;
    }

    // Update
    @Override
    public void update(AnonPostDto.UpdateSevDto updateSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(updateSevDto.getReqUserId()).permission(permission).func(180).build());

        AnonPost anonPost = anonPostRepository.findById(updateSevDto.getId()).orElse(null);
        if(anonPost == null){
            throw new RuntimeException("no data");
        }

        if(updateSevDto.getContent() != null){
            anonPost.setContent(updateSevDto.getContent());
        }

        anonPostRepository.save(anonPost);
    }

    // Delete
    @Override
    public void delete(AnonPostDto.DeleteSevDto deleteSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(deleteSevDto.getReqUserId()).permission(permission).func(200).build());

        AnonPost anonPost = anonPostRepository.findById(deleteSevDto.getId()).orElse(null);
        if(anonPost == null){
            throw new RuntimeException("no data");
        }

        anonPost.setDeleted(true);

        anonPostRepository.save(anonPost);
    }
}
