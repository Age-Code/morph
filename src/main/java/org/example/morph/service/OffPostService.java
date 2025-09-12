package org.example.morph.service;

import org.example.morph.dto.OffPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OffPostService {
    OffPostDto.CreateResDto create(OffPostDto.CreateSevDto createSevDto);
    OffPostDto.DetailResDto detail(OffPostDto.DetailSevDto detailSevDto);
    List<OffPostDto.ListResDto> list(OffPostDto.ListSevDto listSevDto);
    void delete(OffPostDto.DeleteSevDto deleteSevDto);
}
