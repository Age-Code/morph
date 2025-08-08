package org.example.morph.mapper;

import org.example.morph.dto.FaqDto;

import java.util.List;

public interface FaqMapper {
    FaqDto.DetailResDto detail(FaqDto.DetailSevDto detailSevDto);
    List<FaqDto.ListResDto> list(FaqDto.ListSevDto listSevDto);
}
