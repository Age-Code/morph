package org.example.morph.mapper;

import org.example.morph.dto.NoticeDto;

import java.util.List;

public interface NoticeMapper {
    NoticeDto.DetailResDto detail(NoticeDto.DetailSevDto detailSevDto);
    List<NoticeDto.ListResDto> list(NoticeDto.ListSevDto listSevDto);
}
