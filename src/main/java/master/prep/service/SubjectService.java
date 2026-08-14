package master.prep.service;

import master.prep.dto.subject.SubjectRequestDto;
import master.prep.dto.subject.SubjectResponseDto;

import java.util.List;
import java.util.UUID;

public interface SubjectService {
    SubjectResponseDto create(SubjectRequestDto dto);
    SubjectResponseDto getById(UUID id);
    List<SubjectResponseDto> getAll();
}
