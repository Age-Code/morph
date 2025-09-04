package org.example.morph.service;

import org.example.morph.dto.AnonCommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnonCommentService {
    AnonCommentDto.CreateResDto create(AnonCommentDto.CreateSevDto createSevDto);
    AnonCommentDto.DetailResDto detail(AnonCommentDto.DetailSevDto detailSevDto);
    List<AnonCommentDto.ListResDto> list(AnonCommentDto.ListSevDto listSevDto);
    void update(AnonCommentDto.UpdateSevDto updateSevDto);
    void delete(AnonCommentDto.DeleteSevDto deleteSevDto);
}
