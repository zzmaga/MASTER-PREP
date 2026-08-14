package master.prep.service.Impl;

import lombok.RequiredArgsConstructor;
import master.prep.dto.subject.SubjectRequestDto;
import master.prep.dto.subject.SubjectResponseDto;
import master.prep.entity.Subject;
import master.prep.mapstruct.ProgramMapper;
import master.prep.mapstruct.SubjectMapper;
import master.prep.repository.SubjectRepository;
import master.prep.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectResponseDto getById(UUID id){
        return subjectRepository.findById(id)
                .map(subjectMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("subject with id: " + id + "not found"));
    };

    public SubjectResponseDto create(SubjectRequestDto request) {
        if (subjectRepository.existsByTitle(request.getTitle())){
            throw new RuntimeException("title already exists");
        };

        Subject subject = subjectMapper.toEntity(request);

        subjectRepository.save(subject);
        return subjectMapper.toResponseDto(subject);
    };

    public List<SubjectResponseDto> getAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toResponseDto)
                .toList();
    }
}
