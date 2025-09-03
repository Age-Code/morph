package org.example.morph.service;

import org.example.morph.dto.AnonPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnonPostService {
    AnonPostDto.CreateResDto create(AnonPostDto.CreateSevDto createSevDto);
    AnonPostDto.DetailResDto detail(AnonPostDto.DetailSevDto detailSevDto);
    List<AnonPostDto.ListResDto> list(AnonPostDto.ListSevDto listSevDto);
    void update(AnonPostDto.UpdateSevDto updateSevDto);
    void delete(AnonPostDto.DeleteSevDto deleteSevDto);
}
