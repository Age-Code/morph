package org.example.morph.mapper;

import org.example.morph.dto.OffPostDto;

import java.util.List;

public interface OffPostMapper {
    OffPostDto.DetailResDto detail(OffPostDto.DetailSevDto detailSevDto);
    List<OffPostDto.ListResDto> list(OffPostDto.ListSevDto listSevDto);
}
