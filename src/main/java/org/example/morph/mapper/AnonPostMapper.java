package org.example.morph.mapper;

import org.example.morph.dto.AnonPostDto;

import java.util.List;

public interface AnonPostMapper {
    AnonPostDto.DetailResDto detail(AnonPostDto.DetailSevDto detailSevDto);
    List<AnonPostDto.ListResDto> list(AnonPostDto.ListSevDto listSevDto);
}
