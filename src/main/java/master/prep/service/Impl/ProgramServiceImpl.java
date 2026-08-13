package master.prep.service.Impl;

import lombok.RequiredArgsConstructor;
import master.prep.dto.program.ProgramRequestDto;
import master.prep.dto.program.ProgramResponseDto;
import master.prep.entity.Program;
import master.prep.mapstruct.ProgramMapper;
import master.prep.repository.ProgramRepository;
import master.prep.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;
    private final ProgramMapper programMapper;

    @Override
    public ProgramResponseDto create(ProgramRequestDto request){
        if (programRepository.existsByCode(request.getCode())){
            throw new RuntimeException("Программа с кодом " + request.getCode() + " уже существует");
        }
        Program program = programMapper.toEntity(request);
        programRepository.save(program);

        return programMapper.toResponseDto(program);
    }

    @Override
    public ProgramResponseDto getById(UUID id) {
        return programRepository.findById(id)
                .map(programMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Программа с ID " + id + " не найдена"));
    }

    @Override
    public List<ProgramResponseDto> getAll() {
        return programRepository.findAll().stream()
                .map(programMapper::toResponseDto)
                .toList();
    }
}