package org.example.morph.mapper;

import org.example.morph.dto.AnonCommentDto;

import java.util.List;

public interface AnonCommentMapper {
    AnonCommentDto.DetailResDto detail(AnonCommentDto.DetailSevDto detailSevDto);
    List<AnonCommentDto.ListResDto> list(AnonCommentDto.ListSevDto listSevDto);
}
