package master.prep.service;

import master.prep.dto.program.ProgramRequestDto;
import master.prep.dto.program.ProgramResponseDto;

import java.util.List;
import java.util.UUID;

public interface ProgramService {
    ProgramResponseDto create(ProgramRequestDto dto);
    ProgramResponseDto getById(UUID id);
    List<ProgramResponseDto> getAll();
}
