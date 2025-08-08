package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.Notice;
import org.example.morph.dto.PermissionDto;
import org.example.morph.dto.NoticeDto;
import org.example.morph.mapper.NoticeMapper;
import org.example.morph.repository.NoticeRepository;
import org.example.morph.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeServiceimpl implements NoticeService {

    final NoticeRepository noticeRepository;
    final NoticeMapper noticeMapper;

    // Create
    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateSevDto createSevDto) {
        NoticeDto.CreateResDto res = noticeRepository.save(createSevDto.toEntity()).toCreateResDto();

        return res;
    }

    // Detail
    @Override
    public NoticeDto.DetailResDto detail(NoticeDto.DetailSevDto detailSevDto){
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
        Notice notice = noticeRepository.findById(deleteSevDto.getId()).orElse(null);
        if(notice == null){
            throw new RuntimeException("no data");
        }

        notice.setDeleted(true);

        noticeRepository.save(notice);
    }
}
