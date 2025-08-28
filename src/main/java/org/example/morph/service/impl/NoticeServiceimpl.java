package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.Notice;
import org.example.morph.dto.NoticeDto;
import org.example.morph.dto.RoleUserDto;
import org.example.morph.mapper.NoticeMapper;
import org.example.morph.repository.NoticeRepository;
import org.example.morph.service.NoticeService;
import org.example.morph.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeServiceimpl implements NoticeService {

    final String permission = "notice";
    final RoleUserService roleUserService;

    final NoticeRepository noticeRepository;
    final NoticeMapper noticeMapper;

    // Create
    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateSevDto createSevDto) {
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(createSevDto.getReqUserId()).permission(permission).func(120).build());

        NoticeDto.CreateResDto res = noticeRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public NoticeDto.DetailResDto detail(NoticeDto.DetailSevDto detailSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(detailSevDto.getReqUserId()).permission(permission).func(150).build());

        NoticeDto.DetailResDto res = noticeMapper.detail(detailSevDto);

        return res;
    }

    // List
    @Override
    public List<NoticeDto.ListResDto> list(NoticeDto.ListSevDto listSevDto){
        List<NoticeDto.ListResDto> res = noticeMapper.list(listSevDto);

        return res;
    }

    // Update
    @Override
    public void update(NoticeDto.UpdateSevDto updateSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(updateSevDto.getReqUserId()).permission(permission).func(180).build());

        Notice notice = noticeRepository.findById(updateSevDto.getId()).orElse(null);
        if(notice == null){
            throw new RuntimeException("no data");
        }

        if(updateSevDto.getTitle() != null){
            notice.setTitle(updateSevDto.getTitle());
        }
        if(updateSevDto.getContent() != null){
            notice.setContent(updateSevDto.getContent());
        }

        noticeRepository.save(notice);
    }

    // Delete
    @Override
    public void delete(NoticeDto.DeleteSevDto deleteSevDto){
        roleUserService.permit(RoleUserDto.PermitSevDto.builder().reqUserId(deleteSevDto.getReqUserId()).permission(permission).func(200).build());

        Notice notice = noticeRepository.findById(deleteSevDto.getId()).orElse(null);
        if(notice == null){
            throw new RuntimeException("no data");
        }

        notice.setDeleted(true);

        noticeRepository.save(notice);
    }
}
