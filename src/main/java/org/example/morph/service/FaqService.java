package org.example.morph.service;

import org.example.morph.dto.FaqDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FaqService {
    FaqDto.CreateResDto create(FaqDto.CreateSevDto createSevDto);
    FaqDto.DetailResDto detail(FaqDto.DetailSevDto detailSevDto);
    List<FaqDto.ListResDto> list(FaqDto.ListSevDto listSevDto);
    void update(FaqDto.UpdateSevDto updateSevDto);
    void delete(FaqDto.DeleteSevDto deleteSevDto);
}
