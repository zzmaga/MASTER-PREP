package master.prep.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import master.prep.dto.subject.SubjectRequestDto;
import master.prep.dto.subject.SubjectResponseDto;
import master.prep.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(subjectService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDto> create(@Valid @RequestBody SubjectRequestDto dto){
        return ResponseEntity.ok(subjectService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponseDto>> getAll(){
        return ResponseEntity.ok(subjectService.getAll());
    }
}
