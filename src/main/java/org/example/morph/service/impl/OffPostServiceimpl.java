package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.OffPost;
import org.example.morph.dto.OffPostDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.mapper.OffPostMapper;
import org.example.morph.repository.OffPostRepository;
import org.example.morph.service.OffPostService;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OffPostServiceimpl implements OffPostService {

    final String permission = "off";
    final RoleUserService roleUserService;

    final OffPostRepository offPostRepository;
    final OffPostMapper offPostMapper;

    // Create
    @Override
    public OffPostDto.CreateResDto create(OffPostDto.CreateSevDto createSevDto) {
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(createSevDto.getReqUserId()).permission(permission).func(120).build());

        OffPostDto.CreateResDto res = offPostRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public OffPostDto.DetailResDto detail(OffPostDto.DetailSevDto detailSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(detailSevDto.getReqUserId()).permission(permission).func(150).build());

        OffPostDto.DetailResDto res = offPostMapper.detail(detailSevDto);

        return res;
    }

    // List
    @Override
    public List<OffPostDto.ListResDto> list(OffPostDto.ListSevDto listSevDto){
        List<OffPostDto.ListResDto> res = offPostMapper.list(listSevDto);

        return res;
    }

    // Delete
    @Override
    public void delete(OffPostDto.DeleteSevDto deleteSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(deleteSevDto.getReqUserId()).permission(permission).func(200).build());

        OffPost offPost = offPostRepository.findById(deleteSevDto.getId()).orElse(null);
        if(offPost == null){
            throw new RuntimeException("no data");
        }

        offPost.setDeleted(true);

        offPostRepository.save(offPost);
    }
}
